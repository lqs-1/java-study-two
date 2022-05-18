package com.lqs.design.patterns.builder.origin;

import com.lqs.design.patterns.builder.origin.builder.ComputerBuilder;
import com.lqs.design.patterns.builder.origin.builder.director.ComputerDirector;
import com.lqs.design.patterns.builder.origin.builder.impl.MacComputerBuilder;

/**
 * @author : 李奇凇
 * @date : 2022/5/15 10:24
 * @do : 原始的构建者模式测试,使用指导者类，细节让用户操作
 */
public class ComputerBuilderPatternsHasDirector {

    public static void main(String[] args) {

        // 实例化构造器，传入product对象必须要传的值
        ComputerBuilder macComputerBuilder = new MacComputerBuilder("酷睿i5 12代", "32GB");

        // 使用指导者类完成构建（非必要属性的设置）
        ComputerDirector director = new ComputerDirector(macComputerBuilder);
        System.out.println(director.getProduct());
        // 构造
        director.construct();

        System.out.println(director.getProduct());




    }

}
