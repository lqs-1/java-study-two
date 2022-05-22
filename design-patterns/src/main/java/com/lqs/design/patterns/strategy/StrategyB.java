package com.lqs.design.patterns.strategy;

/**
 * @author : 李奇凇
 * @date : 2022/5/20 下午3:09
 * @do : 具体策略类，封装算法
 */
public class StrategyB extends AbstractStrategy{
    @Override
    public void show() {
        System.out.println("满200减50");
    }
}
