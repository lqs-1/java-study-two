package com.lqs.design.patterns.factory.abstractfactoryplus.factory;

import com.lqs.design.patterns.factory.abstractfactoryplus.pojo.coffee.Coffee;
import com.lqs.design.patterns.factory.abstractfactoryplus.pojo.dessert.Dessert;

/**
 * @author : 李奇凇
 * @date : 2022/5/16 12:05
 * @do : 甜品工厂
 */
public interface DessertFactory {

    // 生产咖啡的功能
    Coffee createCoffee(String typeName);

    // 生产甜品的功能
    Dessert createDessert(String typeName);

}
