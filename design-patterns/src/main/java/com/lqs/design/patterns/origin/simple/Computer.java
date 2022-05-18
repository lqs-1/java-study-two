package com.lqs.design.patterns.origin.simple;

/**
 * @author : 李奇凇
 * @date : 2022/5/16 18:27
 * @do : 原型模式， 对象中的非普通对象（除了java.lang里的对象），在克隆的时候，不会被深克隆，只是将被克隆的对象进行了深克隆，为什么里面存在非普通对象也是深克隆？？？？？
 *     浅克隆：原对象和克隆对象指向的是同一块空间，修改其一另一个也会改变
 *     深克隆：原对象和克隆对象指向的不是同意块空间，彼此独立
 */
public class Computer implements Cloneable{

    private Cpu cpu = new Cpu();
    private String ram = "16+512";

    public Computer(){
        System.out.println("构造方法执行了");
    }


    @Override
    protected Computer clone() throws CloneNotSupportedException {
        System.out.println("克隆了");
        return (Computer) super.clone();
    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

}
