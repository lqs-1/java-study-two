package com.lqs.springframework.context.support;

import com.lqs.springframework.beans.BeanDefinition;
import com.lqs.springframework.beans.MutablePropertyValues;
import com.lqs.springframework.beans.PropertyValue;
import com.lqs.springframework.beans.factory.support.BeanDefinitionRegistry;
import com.lqs.springframework.beans.factory.support.xml.XmlBeanDefinitionReader;
import com.lqs.springframework.utils.StringUtils;
import com.lqs.springframework.utils.TypeConverter;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午8:48
 * @do : Ioc容器具体的子类实现
 *      用于加载类路径下的xml格式的配置文件
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext{

    public ClassPathXmlApplicationContext(String configLocation) {
        this.configLocation = configLocation;
        // 创建解析器对象
        this.beanDefinitionReader = new XmlBeanDefinitionReader();
        try {
            this.refresh();
        }catch (Exception e){
            // 什么也不做
        }
    }

    @Override
    public Object getBean(String beanName) throws Exception {
        Object bean = singletonObjects.get(beanName);
        if (bean == null){
            BeanDefinition beanDefinition = beanDefinitionReader.getRegistry().getBeanDefinition(beanName);
            String className = beanDefinition.getClassName();

            Class<?> clazz = Class.forName(className);
            bean = clazz.newInstance();
            // 进行依赖注入操作
            MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues) {
                // 获取name属性值
                String propertyName = propertyValue.getName();
                // 获取value属性值
                String value = propertyValue.getValue();
                // 获取ref属性值
                String ref = propertyValue.getRef();

                if (ref != null && !ref.equals("")){
                    // 获取依赖的bean对象
                    Object diBean = getBean(ref);
                    // 拼接方法名
                    String setterMethodByFieldName = StringUtils.getSetterMethodByFieldName(propertyName);
                    // 获取所有的方法对象
                    Method[] methods = clazz.getMethods();
                    // 执行对应的setter方法
                    for (Method method : methods) {
                        if (method.getName().equals(setterMethodByFieldName)){
                            method.invoke(bean, diBean);
                        }
                    }
                } else if (value != null && !value.equals("")){
                    // 拼接方法名
                    String setterMethodByFieldName = StringUtils.getSetterMethodByFieldName(propertyName);
                    //获取Field对象
                    Field[] fields = clazz.getDeclaredFields();
                    for (Field field : fields) {
                        field.setAccessible(true);
                        if (field.getName().equals(propertyName)){
                            if (field.getType().isAssignableFrom(String.class)){
                                field.set(bean, value);   // TODO
                            }else {
                                field.set(bean, TypeConverter.String2Integer(field.getType(), value));   // TODO
                            }
                        }
                    }
                }
            }

            singletonObjects.put(beanName, bean);
        }
        return bean;
    }

    @Override
    public <T> T getBean(String beanName, Class<? extends T> classType) throws Exception {

        Object bean = getBean(beanName);

        if (bean == null){

            return null;

        }

        return classType.cast(bean);
    }

    @Override
    public <T> T getBean(Class<? extends T> classType) throws Exception {

        Object bean = null;

        for (String beanName : singletonObjects.keySet()) {
            Object singletonObject = singletonObjects.get(beanName);
            if (classType.isAssignableFrom(singletonObject.getClass())){
                bean = singletonObject;
                break;
            }
        }

        if (bean == null){
            BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();

            String[] beanDefinitionNames = registry.getBeanDefinitionNames();

            for (String beanDefinitionName : beanDefinitionNames) {
                BeanDefinition beanDefinition = registry.getBeanDefinition(beanDefinitionName);

                String className = beanDefinition.getClassName();

                Class<?> clazz = Class.forName(className);

                if (clazz.isAssignableFrom(classType)){

                    bean = getBean(beanDefinitionName);

                    singletonObjects.put(beanDefinitionName, bean);

                    break;

                }

            }
        }

        return (T) bean;
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return this.beanDefinitionReader.getRegistry().getBeanDefinitionNames();
    }
}
