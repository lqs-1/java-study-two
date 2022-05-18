package com.lqs.design.patterns.builder.origin2.builder.impl;

import com.lqs.design.patterns.builder.origin2.builder.ComputerBuilder;
import com.lqs.design.patterns.builder.origin2.product.Computer;
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
    public void setColor() {
        computer.setColor("黑色");
    }
    // 可选
    @Override
    public void setDisplay() {
        computer.setDisplay("led");
    }
    // 可选
    @Override
    public void setBirthday() {
        computer.setBirthday("2011");
    }

}
