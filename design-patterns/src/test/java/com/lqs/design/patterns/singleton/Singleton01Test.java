package com.lqs.design.patterns.singleton;

/**
 * @author : 李奇凇
 * @date : 2022/5/16 10:50
 * @do : 饿汉式单例测试
 */
public class Singleton01Test {

    public static void main(String[] args) {
        Singleton01 singleton01 = Singleton01.getInstance();
        Singleton01 singleton011 = Singleton01.getInstance();
        Singleton01 singleton012 = Singleton01.getInstance();


        System.out.println(singleton01);
        System.out.println(singleton011);
        System.out.println(singleton012);

        System.out.println(singleton01 == singleton011);
    }

}
