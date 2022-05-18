package com.lqs.design.patterns.adapter.objectadapter;

import com.lqs.design.patterns.adapter.objectadapter.sd.SdCard;

/**
 * @author : 李奇凇
 * @date : 2022/5/17 9:40
 * @do : 计算机类,只能从sd卡中读取数据
 */
public class Computer {

    // 从SD卡中读取数据
    public void readSd(SdCard sdCard){
        if (sdCard == null){
            throw new NullPointerException("没有传递存储卡");
        }
        sdCard.readSd();
    }

}
