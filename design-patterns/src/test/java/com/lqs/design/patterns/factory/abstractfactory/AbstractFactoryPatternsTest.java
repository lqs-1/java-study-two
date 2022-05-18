package com.lqs.design.patterns.factory.abstractfactory;

import com.lqs.design.patterns.factory.abstractfactory.factory.AmericanDessertFactory;
import com.lqs.design.patterns.factory.abstractfactory.factory.DessertFactory;
import com.lqs.design.patterns.factory.abstractfactory.factory.ItalyDessertFactory;
import com.lqs.design.patterns.factory.abstractfactory.pojo.coffee.Coffee;
import com.lqs.design.patterns.factory.abstractfactory.pojo.dessert.Dessert;

/**
 * @author : 李奇凇
 * @date : 2022/5/16 11:55
 * @do : 抽象工厂模式是23中设计模式，要生产就是一套产品
 *     名词说明：
 *      同产品等级：就是同一类产品，比如美式咖啡和拿铁咖啡和卡布奇洛等都是咖啡,再比如抹茶慕斯和提拉米苏都是甜品
 *      同一产品族：就是一套中的组件，比如，意大利风味的产品，意大利蛋糕和意大利咖啡，再比如，人身上的衣服，运动套装，每一个部分都是同一个产品族的一个部分
 */
public class AbstractFactoryPatternsTest {

    public static void main(String[] args) {
        DessertFactory italyDessertFactory = new ItalyDessertFactory();
        Dessert dessert = italyDessertFactory.createDessert();
        Coffee coffee = italyDessertFactory.createCoffee();
        System.out.println(coffee.getName());
        dessert.show();

        DessertFactory americanDessertFactory = new AmericanDessertFactory();
        Dessert dessert1 = americanDessertFactory.createDessert();
        Coffee coffee1 = americanDessertFactory.createCoffee();
        System.out.println(coffee1.getName());
        dessert1.show();
    }

}
