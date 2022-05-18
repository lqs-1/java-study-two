package spring.context;


import spring.annotation.Autowired;
import spring.annotation.Component;
import spring.annotation.ComponentScan;
import spring.annotation.Scope;
import spring.constant.Constant;
import spring.exception.InstantsTypeException;
import spring.exception.NotBeanException;

import javax.validation.constraints.NotNull;
import java.beans.Introspector;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : 李奇凇
 * @date : 2022/5/6 14:31
 * @do : 手写Spring Ioc
 */
public class AnnotationConfigContext {

    private Class<?> configClass;

    // 定义存放beanDefinition的map
    private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    // 定义存放单例模式的bean的map
    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();

    // 定义存放beanPostProcessor的列表
    private ArrayList<BeanPostProcessor> beanPostProcessorList = new ArrayList<>();

    // 定义存放被解析出来的文件的列表
    private List<String> classFileList = new ArrayList<>();



    // 构造方法
    public AnnotationConfigContext(Class<?> configClass){

        // 将配置类放到私有参数中
        this.configClass = configClass;


        /**
         * 扫描 ----  BeanDefinition ---- beanDefinitionMap
         */

        // 读取configClass
            // 是否包含ComponentScan注解
        if (configClass.isAnnotationPresent(ComponentScan.class)) {

            // 获取注解
            ComponentScan componentScan = configClass.getAnnotation(ComponentScan.class);

            // 读取注解的值
            String value = componentScan.value();

            // 将注解的值里面的.替换为/
            String basePackagePath = value.replace(".", "/");

            // 获取类加载器
            ClassLoader classLoader = AnnotationConfigContext.class.getClassLoader();

            // 通过类加载器获取给定相对路径的绝对路径
            URL resource = classLoader.getResource(basePackagePath);

            // 获取这个资源路径的文件，文件或者文件夹
            File resourceFile = new File(resource.getFile());


            // 获取所有的带有Component注解的文件
            getTargetAnnotationFile(resourceFile);

            // 循环添加找出Component注解
            for (String className : this.classFileList) {

                // 获取对应全限定名指定的类的字节码对象
                Class<?> clazz = null;
                try {

                    // 获取对应全限定名指定的类的字节码对象
                    clazz = classLoader.loadClass(className);

                    // 判断是否存在Component注解
                    if (clazz.isAnnotationPresent(Component.class)){

                        // 如果这个对象（字节码对象）实现了BeanPostProcessor这个接口
                        if (BeanPostProcessor.class.isAssignableFrom(clazz)){

                            // 将这个实现增强器接口的bean放到列表中
                            BeanPostProcessor postBean = (BeanPostProcessor) clazz.newInstance();

                            // 存放增强器
                            beanPostProcessorList.add(postBean);
                        }

                        // 创建BeanDefinition对象，用于存放bean的定义信息
                        BeanDefinition beanDefinition = new BeanDefinition();

                        // 如果有Component注解，那么就获取Component对象
                        Component component = clazz.getAnnotation(Component.class);

                        // 获取Component注解的值，也就是beanName
                        String beanName = component.value();

                        // 如果beanName没有写那么就生成一个
                        if (beanName.equals("")){

                            // 根据全限定名获取最后的类名
                            String beanNameString = className.substring(className.lastIndexOf("."));

                            // 将类名中的.去掉
                            beanNameString = beanNameString.replace(".", "");

                            // 生成一个beanName，这个生成方法，返回的是首字母小写
                            beanName = Introspector.decapitalize(beanNameString);

                        }


                        // 创建存放实例模式的对象
                        String instantsType = null;

                        // 判断是否使用Scope注解
                        if (clazz.isAnnotationPresent(Scope.class)){

                            // 如果使用了就获取Scope对象
                            Scope scope = clazz.getAnnotation(Scope.class);

                            // 获取scope的值
                            instantsType = scope.value();

                        }else {

                            // 如果没有Scope注解那么就是默认单例模式
                            instantsType = Constant.INSTANTS_DEFAULT_TYPE;

                        }

                        // 将对象类型放到BeanDefinition对象
                        beanDefinition.setObjectType(clazz);

                        // 将bean的创建方式放到beanDefinition
                        beanDefinition.setScope(instantsType);

                        // 将beanDefinition存放在map中
                        beanDefinitionMap.put(beanName, beanDefinition);

                    }

                } catch (ClassNotFoundException e) {

                    e.printStackTrace();

                } catch (InstantiationException e) {

                    e.printStackTrace();

                } catch (IllegalAccessException e) {

                    e.printStackTrace();

                }
            }

        }






        /**
         * 实例化单例bean，容器启动
         */

        // 遍历beanDefinition的Map的key
        for (String beanName : beanDefinitionMap.keySet()) {

            // 获取对应的BeanDefinition
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);

            if (beanDefinition.getScope().equals(Constant.SINGLETON_TYPE)){

                // 创建单例模式的bean
                Object bean = createBean(beanName, beanDefinition);

                // 将创建好的bean放到Map中
                singletonObjects.put(beanName, bean);

            }else if (beanDefinition.getScope().equals(Constant.PROTO_TYPE)) {

                // 如果是多例则不创建
                continue;

            }else {

                // 如果是其他实例化类型则直接报错
                throw new InstantsTypeException();

            }


        }

    }


    // 写一个读取class文件的方法
    private void getTargetAnnotationFile(File file){

        // 如果是一个文件夹
        if (file.isDirectory()) {

            // 获取文件夹下的所有文件
            File[] inResourceFiles = file.listFiles();

            // 遍历文件
            for (File fl : inResourceFiles) {

                // 递归调用找出所有的文件夹下买你的class文件
                getTargetAnnotationFile(fl);

            }
        }else{

            // 如果不是文件夹，就判断是否是.class文件
            if (file.getAbsolutePath().endsWith(".class")) {

                // 将.class结尾的所有文件的绝对路径进行切割，留下全全限定名的文件表示
                String className = (String) file.getAbsolutePath().subSequence(file.getAbsolutePath().indexOf("lqs\\"), file.getAbsolutePath().indexOf(".class"));

                // 将文件表示里卖弄的/替换成.
                className = className.replace("\\", ".");

                // 存放到全局变量中
                this.classFileList.add(className);
            }

        }
    }


    // 获取所有的beanDefinition
    public Map<String, BeanDefinition> getBeanDefinition(){
        return this.beanDefinitionMap;
    }


    // 创建对象
    private <T> T createBean(String beanName, BeanDefinition beanDefinition){

        // 获取字节码
        Class<?> clazz = beanDefinition.getObjectType();

        // 创建存放bean的对现象
        Object bean = null;

        try {

            // 实例化bean对象
            bean = clazz.getConstructor().newInstance();

            // 属性注入autowired版本
            for (Field declaredField : clazz.getDeclaredFields()) {

                // 字段上面是否使用了autowired注解
                if (declaredField.isAnnotationPresent(Autowired.class)){

                    // 打开读写权限
                    declaredField.setAccessible(true);

                    // 设置值，这里比较死板，变量名字和被填充的beanName一样哈
                    declaredField.set(bean, getBean(declaredField.getName()));

                }

            }

            // 各种Aware处理
                // 如果这个对象是实现了BeanNameAware的话
            if (bean instanceof BeanNameAware){

                // 把beanName传递过去
                ((BeanNameAware)bean).setBeanName(beanName);

            }

            // 初始化之前前置处理器
            for (BeanPostProcessor beanPostProcessor: beanPostProcessorList){

                // 每一个对象创建的时候，再初始化之前都进行一下判断
                bean = (Object) beanPostProcessor.postProcessBeforeInitialization(beanName, bean);

            }

            // 初始化
                // 如果这个对象是实现了InitializingBean的话
            if (bean instanceof InitializingBean){

                // 把beanName传递过去
                ((InitializingBean)bean).afterPropertiesSet();

            }

            // 初始化后 AOP  BeanPostProcessor
            // 初始化之后后置处理器
            for (BeanPostProcessor beanPostProcessor: beanPostProcessorList){

                // 每一个对象创建的时候，再初始化之后都进行一下判断
                bean = (Object) beanPostProcessor.postProcessAfterInitialization(beanName, bean);

            }

        } catch (InstantiationException e) {

            e.printStackTrace();

        } catch (IllegalAccessException e) {

            e.printStackTrace();

        } catch (InvocationTargetException e) {

            e.printStackTrace();

        } catch (NoSuchMethodException e) {

            e.printStackTrace();

        }

        // 返回bean对象
        return (T) bean;

    }


    // 内部使用的获取bean的方法
    private <T> T getBean(String beanName, BeanDefinition beanDefinition) {

        String scope = beanDefinition.getScope();

        if (scope.equals(Constant.SINGLETON_TYPE)){

            // 如果是单例模式，先从map中获取，因为再容器启动的时候，就会创建处理
            Object bean = singletonObjects.get(beanName);

            // 如果没有获取到就创建一个
            if (bean == null){

                Object createBean = createBean(beanName, beanDefinition);

                // 将创建的bean放到map中
                singletonObjects.put(beanName, createBean);

                return (T) createBean;

            }

            return (T) bean;

        }else {

            // 多例对象,直接创建
            Object bean = createBean(beanName, beanDefinition);

            return (T) bean;

        }


    }


    // 遍历获取beanDefinition进行对比
    private <T> T getSingleton(Class<T> beanType){

        // 存放类型相同的beanDefinition
        Map<String, BeanDefinition> sameBeanDefinition = new HashMap<>();

        // 用于存放bean
        Object bean = null;

        // 遍历beanDefinitionMap
        for (String beanName : beanDefinitionMap.keySet()) {

            // 拿到每一个beanDefinition
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);

            Class<?> objectType = beanDefinition.getObjectType();

            // 如果这个beanDefinition里面存放的BeanType是实现了我们的目标Bean
            if (beanType.isAssignableFrom(objectType)){

                // 就保存这个beanDefinition
                sameBeanDefinition.put(beanName, beanDefinition);

            }

        }


        // 如果存放实现这个bean的定义信息不存在,抛出异常
        if (sameBeanDefinition.size() == 0){

            throw new NotBeanException();

        }


        // 如果只有一个实现了这个bean
        if (sameBeanDefinition.size() == 1){

            // 创建bean
            for (String beanName : sameBeanDefinition.keySet()) {

                // 获取beanDefinition
                BeanDefinition beanDefinition = sameBeanDefinition.get(beanName);

                // 获取bean的核心步骤
                bean = getBean(beanName, beanDefinition);

            }

        }


        // 如果实现了这个bean的不止一个，我们默认获取第一个
        if (sameBeanDefinition.size() > 1){

            for (String beanName : sameBeanDefinition.keySet()) {

                // 获取对象
                bean = getBean(beanName, sameBeanDefinition.get(beanName));

                break;
            }

        }

        return (T) bean;

    }


    // 通过类型+名字获取对象
    public <T> T getBean(@NotNull Class<T> beanType, @NotNull String beanName){

        // 用于存放bean
        Object bean = null;

        // 去beanDefinitionMap中获取对应的beanDefinition
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);

        // 如果没有这个beanDefinition信息直接抛出异常
        if (beanDefinition == null){

            throw new NotBeanException();

        }

        // 先根据类型获取对象
        Object byTypeBean = getBean(beanName);

        // 然后根据名字获取对象
        Object byNameBean = getBean(beanName);

        // 判断是否是同一个对象
        if (byTypeBean == byNameBean

                || byNameBean.getClass().isAssignableFrom(byTypeBean.getClass())){

            bean = byNameBean;

        }else {

            throw new NotBeanException();

        }

        return (T) bean;

    }


    // 通过类型获取对象
    public <T> T getBean(@NotNull Class<T> beanType) {

        // 获取bean的具体逻辑
        T singleton = getSingleton(beanType);

        // 返回结果
        return singleton;

    }


    // 获取对象，通过名字
    public <T> T getBean(@NotNull String beanName){

        // 根据beanName获取对应的BeanDefinition
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);

        if (beanDefinition == null){

            // 如果对应的beanDefinition不存在就抛异常
            throw new NotBeanException();

        }else {

            // 如果存在相对应的beanDefinition那么就创建对象

            String scope = beanDefinition.getScope();

            // 获取bean的核心步骤
            return getBean(beanName, beanDefinition);

        }
    }

}
