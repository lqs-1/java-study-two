package com.lqs.design.patterns.factory.abstractfactory.factory;

import com.lqs.design.patterns.factory.abstractfactory.pojo.coffee.AmericanCoffee;
import com.lqs.design.patterns.factory.abstractfactory.pojo.coffee.Coffee;
import com.lqs.design.patterns.factory.abstractfactory.pojo.dessert.Dessert;
import com.lqs.design.patterns.factory.abstractfactory.pojo.dessert.MatchaMousse;

/**
 * @author : 李奇凇
 * @date : 2022/5/16 12:07
 * @do : 美式甜品工厂，具有美式咖啡和抹茶慕斯
 */
public class AmericanDessertFactory implements DessertFactory{
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new MatchaMousse();
    }
}
