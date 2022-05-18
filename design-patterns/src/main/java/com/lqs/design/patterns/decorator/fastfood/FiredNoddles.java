package com.lqs.design.patterns.decorator.fastfood;

import com.lqs.design.patterns.decorator.FastFood;

/**
 * @author : 李奇凇
 * @date : 2022/5/17 13:45
 * @do : 炒面类
 */
public class FiredNoddles extends FastFood {

    public FiredNoddles(Integer price, String desc) {
        super(price, desc);
    }

    @Override
    public float cost() {
        return getPrice();
    }
}
