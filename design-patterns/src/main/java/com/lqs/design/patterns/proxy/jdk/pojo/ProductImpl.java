package com.lqs.design.patterns.proxy.jdk.pojo;

/**
 * @author : 李奇凇
 * @date : 2022/5/16 18:50
 * @do : 实现接口的目标类
 */
public class ProductImpl implements Product{
    @Override
    public void run() {
        System.out.println("我已经运行了");
    }
}
