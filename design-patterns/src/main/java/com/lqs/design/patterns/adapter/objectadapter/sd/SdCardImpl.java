package com.lqs.design.patterns.adapter.objectadapter.sd;

/**
 * @author : 李奇凇
 * @date : 2022/5/17 9:43
 * @do : 目标类，计算机能够使用的对象
 */
public class SdCardImpl implements SdCard {
    @Override
    public void readSd() {
        System.out.println("sd读卡");
    }
}
