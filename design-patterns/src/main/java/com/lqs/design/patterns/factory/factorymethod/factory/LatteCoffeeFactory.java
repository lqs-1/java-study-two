package com.lqs.design.patterns.factory.factorymethod.factory;

import com.lqs.design.patterns.factory.factorymethod.pojo.Coffee;
import com.lqs.design.patterns.factory.factorymethod.pojo.LatteCoffee;

/**
 * @author : 李奇凇
 * @date : 2022/5/16 11:32
 * @do : 拿铁咖啡工厂，只生产拿铁咖啡
 */
public class LatteCoffeeFactory implements CoffeeFactory{
    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }
}
