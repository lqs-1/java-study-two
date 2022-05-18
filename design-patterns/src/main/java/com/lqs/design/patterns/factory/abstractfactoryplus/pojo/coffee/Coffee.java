package com.lqs.design.patterns.factory.abstractfactoryplus.pojo.coffee;

/**
 * @author : 李奇凇
 * @date : 2022/5/16 11:09
 * @do : 咖啡的抽象类
 */
public abstract class Coffee {
    public abstract String getName();

    public void addMilk(){
        System.out.println("加奶");
    }
}
