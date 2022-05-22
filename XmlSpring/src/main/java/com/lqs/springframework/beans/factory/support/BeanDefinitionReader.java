package com.lqs.springframework.beans.factory.support;

import java.beans.Introspector;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午7:11
 * @do : 用来解析配置文件的，而该接口只是定义了规范
 */
public interface BeanDefinitionReader {

    // 获取注册表对象
    BeanDefinitionRegistry getRegistry();

    // 加载配置文件并在注册表中进行注册
    void loadBeanDefinitions(String configLocation) throws Exception;

    // 如果用户没有配置id属性，那么就生成对应的beanName
    default String generateBeanName(String classPathName){
        String className = classPathName.substring(classPathName.lastIndexOf(".")).replace(".", "");
        return Introspector.decapitalize(className);
    }

}
