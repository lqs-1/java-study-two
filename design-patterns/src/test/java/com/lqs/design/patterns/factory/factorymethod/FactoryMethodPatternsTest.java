package com.lqs.design.patterns.factory.factorymethod;

import com.lqs.design.patterns.factory.factorymethod.factory.AmericanCoffeeFactory;
import com.lqs.design.patterns.factory.factorymethod.factory.CoffeeFactory;
import com.lqs.design.patterns.factory.factorymethod.factory.LatteCoffeeFactory;
import com.lqs.design.patterns.factory.factorymethod.pojo.Coffee;

/**
 * @author : 李奇凇
 * @date : 2022/5/16 11:39
 * @do : 工厂方法的工厂模式的测试，也不属于23中设计模式
 */
public class FactoryMethodPatternsTest {

    public static void main(String[] args) {
        CoffeeStore coffeeStore = new CoffeeStore();

        CoffeeFactory coffeeFactory = new LatteCoffeeFactory();
        coffeeStore.setCoffeeFactory(coffeeFactory);
        Coffee coffee = coffeeStore.orderCoffee();
        System.out.println(coffee.getName());

        CoffeeFactory coffeeFactory1 = new AmericanCoffeeFactory();
        coffeeStore.setCoffeeFactory(coffeeFactory1);
        Coffee coffee1 = coffeeStore.orderCoffee();
        System.out.println(coffee1.getName());
    }

}
