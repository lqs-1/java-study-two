package com.lqs.design.patterns.origin.simple;

/**
 * @author : 李奇凇
 * @date : 2022/5/16 18:34
 * @do : 原型模式的测试，为什么里面存在非普通对象也是深克隆？？？？？
 */
public class SimpleOriginPatternsTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Computer computer = new Computer();

        // 克隆computer
        Computer cloneComputer = computer.clone();

        Cpu cpu = new Cpu();
        cpu.setCpuName("haha");

        computer.setCpu(cpu);

        System.out.println(cloneComputer);
        System.out.println(computer);
    }


}
