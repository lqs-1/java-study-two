package com.lqs.design.patterns.builder.origin2;

import com.lqs.design.patterns.builder.origin2.builder.director.ComputerDirector;
import com.lqs.design.patterns.builder.origin2.builder.impl.MacComputerBuilder;
import com.lqs.design.patterns.builder.origin2.product.Computer;

/**
 * @author : 李奇凇
 * @date : 2022/5/16 11:03
 * @do : 构建者模式测试，具体创建细节不用用户来操作
 */
public class ComputerBuilderTest {

    public static void main(String[] args) {
        ComputerDirector computerDirector = new ComputerDirector(new MacComputerBuilder("cpu", "ram"));
        computerDirector.construct();
        Computer product = computerDirector.getProduct();
        System.out.println(product);
    }


}
