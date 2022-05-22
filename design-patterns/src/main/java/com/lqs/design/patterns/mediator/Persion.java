package com.lqs.design.patterns.mediator;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 上午11:57
 * @do : 抽象同事类
 */
public abstract class Persion {

    protected String name;
    protected Mediator mediator;

    public Persion(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }
}
