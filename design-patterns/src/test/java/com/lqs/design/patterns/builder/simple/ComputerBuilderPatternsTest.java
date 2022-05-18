package com.lqs.design.patterns.builder.simple;

/**
 * @author : 李奇凇
 * @date : 2022/5/15 9:08
 * @do : 简单构建者模式测试
 */
public class ComputerBuilderPatternsTest {

    public static void main(String[] args) {
        Computer computer = new Computer.Builder("酷睿i7 11 代", "16GB")
                .color("red")
                .display("LED")
                .birthday("2020")
                .build();
        System.out.println(computer);
    }

}
