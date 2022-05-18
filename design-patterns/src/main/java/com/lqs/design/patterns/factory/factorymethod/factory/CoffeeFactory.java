package com.lqs.design.patterns.factory.factorymethod.factory;

import com.lqs.design.patterns.factory.factorymethod.pojo.Coffee;

/**
 * @author : 李奇凇
 * @date : 2022/5/16 11:29
 * @do : 咖啡的抽象工厂
 */
public interface CoffeeFactory {

    // 创建咖啡对象的方法
    Coffee createCoffee();

}
