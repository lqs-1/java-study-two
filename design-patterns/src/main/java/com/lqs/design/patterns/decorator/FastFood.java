package com.lqs.design.patterns.decorator;

/**
 * @author : 李奇凇
 * @date : 2022/5/17 10:04
 * @do : 快餐抽象类
 */
public abstract class FastFood {

    private Integer price;  // 价格
    private String desc;  // 描述

    public FastFood(Integer price, String desc) {
        this.price = price;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public abstract float cost();
}
