package com.lqs.springframework.context;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午8:34
 * @do : Ioc父容器接口，BeanFactory这个类的非ApplicationContext实现类都是延时加载，也就是在使用的时候才会创建
 */
public interface BeanFactory {

    Object getBean(String beanName) throws Exception;

    <T> T getBean(String beanName, Class<? extends T> classType) throws Exception;

    <T> T getBean(Class<? extends T> classType) throws Exception;


    // 获取全部的BeanDefinitionName
    String[] getBeanDefinitionNames();

}
