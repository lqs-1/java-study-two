package com.lqs.design.patterns.builder.origin.builder;

import com.lqs.design.patterns.builder.origin.product.Computer;
import com.sun.istack.internal.Nullable;

/**
 * @author : 李奇凇
 * @date : 2022/5/15 9:21
 * @do : Builder： 构建者的抽象基类（有时会使用接口代替）。其定义了构建Product的抽象步骤，其实体类需要实现这些步骤。其会包含一个用来返回最终产品的方法Product getProduct()
 */
public abstract class ComputerBuilder {
    // 要返回的对象，具体的值从实现类中填充
    protected Computer computer;


    // 三个可选参数组成部分的抽象构造方法
    public abstract ComputerBuilder setColor(@Nullable String color);
    public abstract ComputerBuilder setDisplay(@Nullable String display);
    public abstract ComputerBuilder setBirthday(@Nullable String birthday);

    // 获取对象的抽象方法
    public Computer getProduct(){
        return computer;
    }



}
