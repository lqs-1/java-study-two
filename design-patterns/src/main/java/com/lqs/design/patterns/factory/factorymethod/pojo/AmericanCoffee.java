package com.lqs.design.patterns.factory.factorymethod.pojo;

import com.lqs.design.patterns.factory.factorymethod.pojo.Coffee;

/**
 * @author : 李奇凇
 * @date : 2022/5/16 11:11
 * @do : 美式咖啡
 */
public class AmericanCoffee extends Coffee {
    @Override
    public String getName() {
        return "美式咖啡";
    }
}
