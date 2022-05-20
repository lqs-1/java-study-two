package com.lqs.design.patterns.flyweight;

/**
 * @author : 李奇凇
 * @date : 2022/5/20 下午12:21
 * @do : 抽象享元角色，俄罗斯方块
 */
public abstract class AbstractBox {

    // 获取图形的方法
    public abstract String getShape();

    // 显示图形及其颜色
    public void display(String color){
        System.out.println("方块形状" + getShape() + "，颜色" + color);
    }


}
