package com.lqs.design.patterns.adapter.classadapter.tf;

/**
 * @author : 李奇凇
 * @date : 2022/5/17 9:47
 * @do : 适配者类，计算机不能直接使用的对象
 */
public class TfCardImpl implements TfCard{
    @Override
    public void readTf() {
        System.out.println("Tf读卡");
    }
}
