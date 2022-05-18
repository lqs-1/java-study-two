package com.lqs.design.patterns.factory.abstractfactoryplus;

import com.lqs.design.patterns.factory.abstractfactoryplus.factory.AmericanDessertFactory;
import com.lqs.design.patterns.factory.abstractfactoryplus.factory.DessertFactory;
import com.lqs.design.patterns.factory.abstractfactoryplus.factory.ItalyDessertFactory;
import com.lqs.design.patterns.factory.abstractfactoryplus.pojo.coffee.Coffee;
import com.lqs.design.patterns.factory.abstractfactoryplus.pojo.dessert.Dessert;

/**
 * @author : 李奇凇
 * @date : 2022/5/16 13:09
 * @do : 抽象工厂模式的升级，使用配置文件实现全解耦
 */
public class AbstractFactoryPlusPatternsTest {

    public static void main(String[] args) {
        DessertFactory americanDessertFactory = new AmericanDessertFactory();
        Dessert matchamousse = americanDessertFactory.createDessert("matchamousse");
        Coffee american = americanDessertFactory.createCoffee("american");
        System.out.println(american.getName());
        matchamousse.show();


        DessertFactory italyDessertFactory = new ItalyDessertFactory();
        Dessert trimisu = italyDessertFactory.createDessert("trimisu");
        Coffee latte = italyDessertFactory.createCoffee("latte");
        System.out.println(latte.getName());
        trimisu.show();
    }

}
