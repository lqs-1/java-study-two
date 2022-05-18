package com.lqs.design.patterns.adapter.objectadapter;

import com.lqs.design.patterns.adapter.objectadapter.sd.SdCardImpl;
import com.lqs.design.patterns.adapter.objectadapter.tf.TfCardImpl;

/**
 * @author : 李奇凇
 * @date : 2022/5/17 9:58
 * @do : 对象适配器模式测试,对象适配器模式采用聚合的方式
 */
public class ObjectAdapterPatternsTest {

    public static void main(String[] args) {
        Computer computer = new Computer();

        computer.readSd(new SdCardImpl());


        // 计算机读取tf卡
        computer.readSd(new Adapter(new TfCardImpl()));
    }

}
