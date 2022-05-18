package com.lqs.design.patterns.builder.origin;

import com.lqs.design.patterns.builder.origin.builder.ComputerBuilder;
import com.lqs.design.patterns.builder.origin.builder.impl.MacComputerBuilder;

/**
 * @author : 李奇凇
 * @date : 2022/5/15 9:39
 * @do : 原始的构建者模式测试,不使用指导者类，细节让用户操作
 */
public class ComputerBuilderPatternsNoDirector {

    public static void main(String[] args) {
        // 可以根据构建者来直接设置对象，这个时候没有必要用 指导者类
        ComputerBuilder macComputerBuilder = new MacComputerBuilder("酷睿i7 11代", "16GB").setColor("1").setDisplay("2").setBirthday("4");
        System.out.println(macComputerBuilder.getProduct());
    }
}
