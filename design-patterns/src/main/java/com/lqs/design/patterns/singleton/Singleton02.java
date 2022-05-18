package com.lqs.design.patterns.singleton;

/**
 * @author : 李奇凇
 * @date : 2022/5/16 10:51
 * @do : 懒汉式单例，在使用的时候才会创建对象,推荐使用
 */
public class Singleton02 {

    private Singleton02() {
    }

    private static class SingletonHolder{
        private static final Singleton02 INSTANCE = new Singleton02();
    }

    public static Singleton02 getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
