package com.lqs.design.patterns.bridge.video;

/**
 * @author : 李奇凇
 * @date : 2022/5/17 14:38
 * @do : Wmvb视频文件（具体的实现化角色）
 */
public class WmvbFile implements FIleVideo{
    @Override
    public void decode(String fileName) {
        System.out.println(fileName);
    }
}
