package com.lqs.design.patterns.singleton;

/**
 * @author : 李奇凇
 * @date : 2022/5/16 10:56
 * @do : 懒汉式单例测试
 */
public class Singleton02Test {

    public static void main(String[] args) {
        Singleton02 singleton02 = Singleton02.getInstance();
        Singleton02 singleton021 = Singleton02.getInstance();
        Singleton02 singleton022 = Singleton02.getInstance();

        System.out.println(singleton02);
        System.out.println(singleton021);
        System.out.println(singleton022);

        System.out.println(singleton02 == singleton021);
    }

}
