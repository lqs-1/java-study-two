package com.lqs.design.patterns.bridge;

import com.lqs.design.patterns.bridge.computer.Linux;
import com.lqs.design.patterns.bridge.video.AviFile;

/**
 * @author : 李奇凇
 * @date : 2022/5/17 14:43
 * @do : 桥接模式测试,如果在设计的时候存在两个维度，比如计算机类型和视频类型，比如图形类别和颜色，就采用这种设计模式
 */
public class BridgePatternsTest {

    public static void main(String[] args) {
        Linux linux = new Linux(new AviFile());

        linux.play("haha");
    }

}
