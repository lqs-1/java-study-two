package com.lqs.design.patterns.adapter.classadapter;

import com.lqs.design.patterns.adapter.classadapter.sd.SdCardImpl;

/**
 * @author : 李奇凇
 * @date : 2022/5/17 9:52
 * @do : 类适配器模式测试，类适配器模式采用继承方式
 */
public class ClassAdapterPatternsTest {

    public static void main(String[] args) {
        Computer computer = new Computer();

        computer.readSd(new SdCardImpl());

        // 读取tf卡里面的数据
        computer.readSd(new Adapter());
    }

}
