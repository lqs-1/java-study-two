package com.lqs.design.patterns.factory.factorymethod;

import com.lqs.design.patterns.factory.factorymethod.factory.CoffeeFactory;
import com.lqs.design.patterns.factory.factorymethod.pojo.Coffee;

/**
 * @author : 李奇凇
 * @date : 2022/5/16 11:12
 * @do : 咖啡店,这种工厂方法模式，也不是23中设计模式，它解除了咖啡店和咖啡之间的耦合,满足开闭原则，但是如果产品过多，不止两种咖啡，那么，就会增加系统的复杂度，因为，增加
 *      就会添加咖啡，添加咖啡的工厂，而且这种方法只是生产一类产品
 */
public class CoffeeStore {

    private CoffeeFactory coffeeFactory;

    public void setCoffeeFactory(CoffeeFactory coffeeFactory){
        this.coffeeFactory = coffeeFactory;
    }

    // 也可以将这个方法设置为静态，让其变成静态工厂
    public Coffee orderCoffee(){
        Coffee coffee = this.coffeeFactory.createCoffee(); // 创建咖啡
        coffee.addMilk();
        return coffee;
    }


}
