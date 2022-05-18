package com.lqs.design.patterns.bridge.computer;

import com.lqs.design.patterns.bridge.video.FIleVideo;

/**
 * @author : 李奇凇
 * @date : 2022/5/17 14:42
 * @do : 扩展抽象化角色（Mac操作系统）
 */
public class Mac extends OpratingSystem{
    public Mac(FIleVideo fIleVideo) {
        super(fIleVideo);
    }

    @Override
    public void play(String fileName) {
        System.out.println("mac播放");
        fIleVideo.decode("hehe");
    }
}
