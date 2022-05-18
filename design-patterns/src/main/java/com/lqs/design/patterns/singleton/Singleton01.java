package com.lqs.design.patterns.singleton;

/**
 * @author : 李奇凇
 * @date : 2022/5/16 10:47
 * @do : 饿汉式，类加载之前创建好的单例
 */
public class Singleton01 {

    private static Singleton01 singleton01 = new Singleton01();

    private Singleton01() {
    }


    public static Singleton01 getInstance(){
        return singleton01;
    }
}
