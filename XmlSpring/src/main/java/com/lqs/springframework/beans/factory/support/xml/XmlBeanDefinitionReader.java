package com.lqs.springframework.beans.factory.support.xml;

import com.lqs.springframework.beans.BeanDefinition;
import com.lqs.springframework.beans.MutablePropertyValues;
import com.lqs.springframework.beans.PropertyValue;
import com.lqs.springframework.beans.factory.support.BeanDefinitionReader;
import com.lqs.springframework.beans.factory.support.BeanDefinitionRegistry;
import com.lqs.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午7:14
 * @do : 针对xml配置文件进行解析的类
 */
public class XmlBeanDefinitionReader implements BeanDefinitionReader {

    // 声明注册表对象
    private BeanDefinitionRegistry registry;

    public XmlBeanDefinitionReader() {
        registry = new SimpleBeanDefinitionRegistry();
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return this.registry;
    }

    @Override
    public void loadBeanDefinitions(String configLocation) throws Exception {
        // 使用dom4j进行xml配置文件的解析
        SAXReader reader = new SAXReader();
        // 获取类路径下的配置文件
        InputStream is = XmlBeanDefinitionReader.class.getClassLoader().getResourceAsStream(configLocation);
        // 从输入流中获取Document对象
        Document document = reader.read(is);
        // 根据Document对象获取根标签对象（beans）
        Element rootElement = document.getRootElement();
        // 获取根标签下的所有bean标签
        List<Element> beanElements = rootElement.elements("bean");
        // 遍历集合
        for (Element beanElement : beanElements) {
            // 获取id属性
            String id = beanElement.attributeValue("id");
            // 获取class属性
            String className = beanElement.attributeValue("class");
            // 将id属性和class属性封装到BeanDefinition对象中
            // 判断用户是否配置了id
            if (id == null){
                id = generateBeanName(className);
            }
            // 创建BeanDifinition对象
            BeanDefinition beanDefinition = new BeanDefinition();
            beanDefinition.setId(id);
            beanDefinition.setClassName(className);

            // 获取property属性的值
            MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
            List<Element> properties = beanElement.elements("property");

            // 遍历
            for (Element property : properties) {
                String name = property.attributeValue("name");
                String ref = property.attributeValue("ref");
                String value = property.attributeValue("value");

                // 创建PropertyValue对象并封装数据
                PropertyValue propertyValue = new PropertyValue(name, ref, value);
                mutablePropertyValues.addPropertyValue(propertyValue);
            }
            // 封装propertyValue到BeanDefinition中
            beanDefinition.setPropertyValues(mutablePropertyValues);
            // 将BeanDefinition对象注册到注册表中
            registry.registerBeanDefinition(id,beanDefinition);
        }
    }
}
