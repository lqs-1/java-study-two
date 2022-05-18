package com.lqs.design.patterns.builder.origin.builder.impl;

import com.lqs.design.patterns.builder.origin.builder.ComputerBuilder;
import com.lqs.design.patterns.builder.origin.product.Computer;
import com.sun.istack.internal.Nullable;

/**
 * @author : 李奇凇
 * @date : 2022/5/15 9:28
 * @do : 具体实现构建抽象类的构造者
 */
public class MacComputerBuilder extends ComputerBuilder {

    // 填充抽象父类中的computer对象
    public MacComputerBuilder(String cpu, String ram){
        computer = new Computer(cpu, ram);
    }

    // 可选
    @Override
    public ComputerBuilder setColor(@Nullable String color) {
        computer.setColor(color);
        return this;
    }
    // 可选
    @Override
    public ComputerBuilder setDisplay(@Nullable String display) {
        computer.setDisplay(display);
        return this;
    }
    // 可选
    @Override
    public ComputerBuilder setBirthday(@Nullable String birthday) {
        computer.setBirthday(birthday);
        return this;
    }

}
