package com.lqs.design.patterns.factory.abstractfactory.factory;

import com.lqs.design.patterns.factory.abstractfactory.pojo.coffee.Coffee;
import com.lqs.design.patterns.factory.abstractfactory.pojo.dessert.Dessert;

/**
 * @author : 李奇凇
 * @date : 2022/5/16 12:05
 * @do : 甜品工厂
 */
public interface DessertFactory {

    // 生产咖啡的功能
    Coffee createCoffee();

    // 生产甜品的功能
    Dessert createDessert();

}
