package com.lqs.design.patterns.builder.origin.builder.director;

import com.lqs.design.patterns.builder.origin.builder.ComputerBuilder;
import com.lqs.design.patterns.builder.origin.product.Computer;

/**
 * @author : 李奇凇
 * @date : 2022/5/15 9:33
 * @do : 指导者类,指挥构建
 */
public class ComputerDirector {

    private ComputerBuilder computerBuilder;

    public ComputerDirector(ComputerBuilder builder){
        this.computerBuilder = builder;
    }



    public Computer getProduct(){
        return computerBuilder.getProduct();
    }

    public void construct(){
        computerBuilder.setBirthday("32");
        computerBuilder.setColor("23");
        computerBuilder.setDisplay("435");
    }
}
