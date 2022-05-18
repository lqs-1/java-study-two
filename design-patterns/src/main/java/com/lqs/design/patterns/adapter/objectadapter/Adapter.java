package com.lqs.design.patterns.adapter.objectadapter;

import com.lqs.design.patterns.adapter.objectadapter.sd.SdCard;
import com.lqs.design.patterns.adapter.objectadapter.tf.TfCard;
import com.lqs.design.patterns.adapter.objectadapter.tf.TfCardImpl;

/**
 * @author : 李奇凇
 * @date : 2022/5/17 9:41
 * @do : 适配器类，将计算机不能直接使用的对象，适配成计算机能够使用的对象
 */
public class Adapter implements SdCard {

    private TfCard tfCard;

    public Adapter(TfCard tfCard) {
        this.tfCard = tfCard;
    }

    @Override
    public void readSd() {
        tfCard.readTf();
    }
}
