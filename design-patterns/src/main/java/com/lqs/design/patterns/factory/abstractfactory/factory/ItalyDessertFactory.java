package com.lqs.design.patterns.factory.abstractfactory.factory;

import com.lqs.design.patterns.factory.abstractfactory.pojo.coffee.Coffee;
import com.lqs.design.patterns.factory.abstractfactory.pojo.coffee.LatteCoffee;
import com.lqs.design.patterns.factory.abstractfactory.pojo.dessert.Dessert;
import com.lqs.design.patterns.factory.abstractfactory.pojo.dessert.Trimisu;

/**
 * @author : 李奇凇
 * @date : 2022/5/16 12:09
 * @do : 意大利风味的甜品，拿铁咖啡和提拉米苏
 */
public class ItalyDessertFactory implements DessertFactory{
    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new Trimisu();
    }
}
