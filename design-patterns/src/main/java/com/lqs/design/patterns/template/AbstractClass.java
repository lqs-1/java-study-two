package com.lqs.design.patterns.template;

/**
 * @author : 李奇凇
 * @date : 2022/5/20 下午12:45
 * @do : 抽象类（定义模板方法和基本方法）,炒菜
 */
public abstract class AbstractClass {

    // 模板方法,执行顺序，final无法改变，无法重写
    public final void cookProcess(){
        pourOil();
        heatOil();
        pourVegetable();
        pourSauce();
        fry();
    }

    // 下面是基本方法

    // 第一步倒油，都会有
    public void pourOil(){
        System.out.println("倒油");
    }

    // 第二步热油，都会有
    public void heatOil(){
        System.out.println("热油");
    }

    // 第三步倒菜，倒菜不一样，菜不一样
    public abstract void pourVegetable();

    // 第四步调味，不一样
    public abstract void pourSauce();

    // 第五步翻炒，一样的，都会有
    public void fry(){
        System.out.println("翻炒");
    }



}
