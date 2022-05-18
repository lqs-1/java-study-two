package com.lqs.design.patterns.factory.factorymethod.factory;

import com.lqs.design.patterns.factory.factorymethod.pojo.AmericanCoffee;
import com.lqs.design.patterns.factory.factorymethod.pojo.Coffee;

/**
 * @author : 李奇凇
 * @date : 2022/5/16 11:31
 * @do : 美式咖啡工厂，只生产美式咖啡
 */
public class AmericanCoffeeFactory implements CoffeeFactory{
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }
}
