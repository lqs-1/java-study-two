package com.lqs.design.patterns.bridge.computer;

import com.lqs.design.patterns.bridge.video.FIleVideo;

/**
 * @author : 李奇凇
 * @date : 2022/5/17 14:41
 * @do : 扩展抽象化角色（linux操作系统）
 */
public class Linux extends OpratingSystem{


    public Linux(FIleVideo fIleVideo) {
        super(fIleVideo);
    }

    @Override
    public void play(String fileName) {
        System.out.println("linux播放");
        fIleVideo.decode("haha");
    }
}
