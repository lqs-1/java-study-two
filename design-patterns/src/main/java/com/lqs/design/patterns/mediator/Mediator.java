package com.lqs.design.patterns.mediator;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 上午11:56
 * @do : 抽象中介者类
 */
public abstract class Mediator {
    // 客户和房主沟通的方法

    public abstract void constact(String message, Persion persion);
}
