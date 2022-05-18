package com.lqs.design.patterns.decorator.ex;

import com.lqs.design.patterns.decorator.FastFood;
import com.lqs.design.patterns.decorator.Garnish;

/**
 * @author : 李奇凇
 * @date : 2022/5/17 13:54
 * @do : 培根配料类
 */
public class Bacon extends Garnish {

    public Bacon(Integer price, String desc, FastFood fastFood) {
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
