package com.lqs.design.patterns.order;

/**
 * @author : 李奇凇
 * @date : 2022/5/20 下午3:26
 * @do : 厨师类
 */
public class SeniorChef {

    // 制作食物的方法
    public void makeFood(String foodName, Integer foodNum){
        System.out.println(foodNum + "份" + foodName);
    }

}
