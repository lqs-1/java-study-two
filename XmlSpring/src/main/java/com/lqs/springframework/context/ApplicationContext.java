package com.lqs.springframework.context;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午8:37
 * @do : 定义非延时加载功能
 */
public interface ApplicationContext extends BeanFactory{

    void refresh() throws Exception;

}
