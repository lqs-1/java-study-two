package com.lqs.design.patterns.decorator;

import com.lqs.design.patterns.decorator.FastFood;

/**
 * @author : 李奇凇
 * @date : 2022/5/17 13:49
 * @do : 快餐修饰类
 */
public abstract class Garnish extends FastFood {

    private FastFood fastFood;

    public Garnish(Integer price, String desc, FastFood fastFood) {
        super(price, desc);
        this.fastFood = fastFood;
    }

    public FastFood getFastFood(){
        return fastFood;
    }


    public void setFastFood(FastFood fastFood) {
        this.fastFood = fastFood;
    }
}
