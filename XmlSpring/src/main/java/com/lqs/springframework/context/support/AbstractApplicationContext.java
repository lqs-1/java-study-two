package com.lqs.springframework.context.support;

import com.lqs.springframework.beans.factory.support.BeanDefinitionReader;
import com.lqs.springframework.beans.factory.support.BeanDefinitionRegistry;
import com.lqs.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午8:39
 * @do : ApplicationContext接口的实现类，用于立即加载
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    // 声明解析器变量
    protected BeanDefinitionReader beanDefinitionReader;

    // 定义用于存储Bean对象的容器
    protected Map<String, Object> singletonObjects = new HashMap<>();

    // 声明配置文件路径的变量
    protected String configLocation;

    @Override
    public void refresh() throws Exception {
        // 加载BeanDefinition对象
        beanDefinitionReader.loadBeanDefinitions(configLocation);
        // 初始化bean创建bean对象
        this.finishBeanInitialization();
    }

    // bean的初始化
    private void finishBeanInitialization() throws Exception{
        // 获取注册表对象
        BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();
        // 获取BeanDefinition对象
        String[] beanNames = registry.getBeanDefinitionNames();
        // 进行bean的初始化
        for (String beanName : beanNames) {
            getBean(beanName);
        }

    }
}
