package com.lqs.design.patterns.adapter.classadapter;

import com.lqs.design.patterns.adapter.classadapter.sd.SdCard;
import com.lqs.design.patterns.adapter.classadapter.tf.TfCardImpl;

/**
 * @author : 李奇凇
 * @date : 2022/5/17 9:41
 * @do : 适配器类，将计算机不能直接使用的对象，适配成计算机能够使用的对象
 */
public class Adapter extends TfCardImpl implements SdCard {
    @Override
    public void readSd() {
        readTf();
    }
}
