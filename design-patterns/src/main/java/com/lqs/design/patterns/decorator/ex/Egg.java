package com.lqs.design.patterns.decorator.ex;

import com.lqs.design.patterns.decorator.FastFood;
import com.lqs.design.patterns.decorator.Garnish;

/**
 * @author : 李奇凇
 * @date : 2022/5/17 13:46
 * @do : 鸡蛋配料类
 */
public class Egg extends Garnish {

    public Egg(Integer price, String desc, FastFood fastFood) {
        super(price, desc, fastFood);
    }

    @Override
    public float cost() {
        return getPrice() + getFastFood().cost();
    }

    @Override
    public String getDesc() {
        return super.getDesc() + getFastFood().getDesc();
    }
}
