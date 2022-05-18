package com.lqs.design.patterns.builder.simple;

/**
 * @author : 李奇凇
 * @date : 2022/5/15 8:57
 * @do : 简单构建者模式
 */
public class Computer {

    private String cpu;  // 必填
    private String ram;  // 必填

    private String color;  // 选填
    private String display;  // 选填
    private String birthday;  // 选填

    // 私有构造函数，给构建者内部内使用
    private Computer(Builder builder){
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.color = builder.color;
        this.display = builder.display;
        this.birthday = builder.birthday;
    }


    // 内部内，就是构建者，变量一摸一样
    public static class Builder{
        private String cpu;  // 必填
        private String ram;  // 必填

        private String color;  // 选填
        private String display;  // 选填
        private String birthday;  // 选填

        // 内部内的构造方法用于必填
        public Builder(String cpu, String ram) {
            this.cpu = cpu;
            this.ram = ram;
        }
        // 选填
        public Builder color(String color){
            this.color = color;
            return this;
        }
        // 选填
        public Builder display(String display){
            this.display = display;
            return this;
        }
        // 选填
        public Builder birthday(String birthday){
            this.birthday = birthday;
            return this;
        }
        // 构建，返回对象，并且将内部内传给上面的私有构造函数
        public Computer build(){
            return new Computer(this);
        }
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
