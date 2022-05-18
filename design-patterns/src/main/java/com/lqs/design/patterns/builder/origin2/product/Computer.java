package com.lqs.design.patterns.builder.origin2.product;

/**
 * @author : 李奇凇
 * @date : 2022/5/15 9:17
 * @do : 原始的构建者模式，使用默认数据，用户看不到
 */

/**
 * Product: 最终要生成的对象，例如 Computer实例。
 * Builder： 构建者的抽象基类（有时会使用接口代替）。其定义了构建Product的抽象步骤，其实体类需要实现这些步骤。其会包含一个用来返回最终产品的方法Product getProduct()。
 * ConcreteBuilder: Builder的实现类。
 * Director: 决定如何构建最终产品的算法. 其会包含一个负责组装的方法void Construct(Builder builder)， 在这个方法中通过调用builder的方法，就可以设置builder，等设置完成后，就可以通过builder的 getProduct() 方法获得最终的产品。
 */

public class Computer {

    private String cpu;  // 必填
    private String ram;  // 必填

    private String color;  // 选填
    private String display;  // 选填
    private String birthday;  // 选填

    // 构造函数，用于必填
    public Computer(String cpu, String ram){
        this.cpu = cpu;
        this.ram = ram;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", color='" + color + '\'' +
                ", display='" + display + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
