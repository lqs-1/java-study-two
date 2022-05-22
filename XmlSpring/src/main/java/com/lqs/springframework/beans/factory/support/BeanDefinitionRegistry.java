package com.lqs.springframework.beans.factory.support;

import com.lqs.springframework.beans.BeanDefinition;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午6:58
 * @do : 注册表对象接口
 */
public interface BeanDefinitionRegistry {
    // 注册BeanDefinition对象到注册表中
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    // 从注册表中删除指定名称的BeanDefinition对象
    void removeBeanDefinition(String beanName) throws Exception;

    // 根据名称从注册表中获取BeanDefinition对象
    BeanDefinition getBeanDefinition(String beanName) throws Exception;

    // 判断注册表中是否包含指定名称的BeanDefinition
    boolean containsBeanDefinition(String beanName);

    // 返回注册表中的所有的BeanDefinition的个数
    int getBeanDefinitionCount();

    // 返回注册表中的所有的BeanDefinition的beanName
    String[] getBeanDefinitionNames();


}
