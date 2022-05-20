package com.lqs.design.patterns.template;

/**
 * @author : 李奇凇
 * @date : 2022/5/20 下午12:53
 * @do : 炒包菜类
 */
public class ConcreateClass_BaoCai extends AbstractClass{

    @Override
    public void pourVegetable() {
        System.out.println("下锅的是包菜");
    }

    @Override
    public void pourSauce() {
        System.out.println("下锅的是辣椒");
    }
}
