package com.lqs.design.patterns.bridge.computer;

import com.lqs.design.patterns.bridge.video.FIleVideo;

/**
 * @author : 李奇凇
 * @date : 2022/5/17 14:39
 * @do : 抽象的操作系统类（抽象化角色）
 */
public abstract class OpratingSystem {

    protected FIleVideo fIleVideo;

    public OpratingSystem(FIleVideo fIleVideo) {
        this.fIleVideo = fIleVideo;
    }

    public abstract void play (String fileName);
}
