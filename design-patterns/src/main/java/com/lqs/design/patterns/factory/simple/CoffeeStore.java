package com.lqs.design.patterns.factory.simple;

import com.lqs.design.patterns.factory.simple.pojo.AmericanCoffee;
import com.lqs.design.patterns.factory.simple.pojo.Coffee;
import com.lqs.design.patterns.factory.simple.pojo.LatteCoffee;
import com.sun.istack.internal.NotNull;

/**
 * @author : 李奇凇
 * @date : 2022/5/16 11:12
 * @do : 咖啡店,这种简单工厂模式，违背了开闭原则，是咖啡和咖啡店之间的耦合，同时这种模式也不是23中设计模式
 */
public class CoffeeStore {

    // 也可以将这个方法设置为静态，让其变成静态工厂
    public Coffee orderCoffee(@NotNull String coffeeType){
        Coffee coffee = null;

        if ("American".equals(coffeeType)){
            coffee = new AmericanCoffee();
        }else if ("Latte".equals(coffeeType)){
            coffee = new LatteCoffee();
        }else {
            throw new RuntimeException("对不起,这种咖啡卖没了");
        }

        coffee.addMilk();

        return coffee;
    }


}
