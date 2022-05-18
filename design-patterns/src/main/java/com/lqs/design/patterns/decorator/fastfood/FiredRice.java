package com.lqs.design.patterns.decorator.fastfood;

import com.lqs.design.patterns.decorator.FastFood;

/**
 * @author : 李奇凇
 * @date : 2022/5/17 13:44
 * @do : 炒饭类
 */
public class FiredRice extends FastFood {

    public FiredRice(Integer price, String desc) {
        super(price, desc);
    }

    @Override
    public float cost() {
        return getPrice();
    }
}
