package com.lqs.design.patterns.template;

/**
 * @author : 李奇凇
 * @date : 2022/5/20 下午12:53
 * @do : 炒菜心
 */
public class ConcreateClass_CaiXin extends AbstractClass{

    @Override
    public void pourVegetable() {
        System.out.println("下锅的是菜心");
    }

    @Override
    public void pourSauce() {
        System.out.println("下锅的是蒜融");
    }
}
