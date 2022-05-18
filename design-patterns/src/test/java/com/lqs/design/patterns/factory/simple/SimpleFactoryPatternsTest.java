package com.lqs.design.patterns.factory.simple;

import com.lqs.design.patterns.factory.simple.pojo.Coffee;

/**
 * @author : 李奇凇
 * @date : 2022/5/16 11:18
 * @do : 简单工厂模式测试，不属于23中设计模式
 */
public class SimpleFactoryPatternsTest {

    public static void main(String[] args) {
        CoffeeStore store = new CoffeeStore();

        Coffee coffee = store.orderCoffee("Latte");
        System.out.println(coffee.getName());

        Coffee coffee1 = store.orderCoffee("American");
        System.out.println(coffee1.getName());
    }

}
