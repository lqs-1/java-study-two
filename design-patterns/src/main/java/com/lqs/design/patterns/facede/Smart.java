package com.lqs.design.patterns.facede;

/**
 * @author : 李奇凇
 * @date : 2022/5/19 下午3:26
 * @do : 智能音箱类，外观类，用户主要和该类交互
 */
public class Smart {

    private Light light;
    private TV tv;

    public Smart() {
        this.light = new Light();
        this.tv = new TV();
    }

    // 语音操控
    public void say(String message){
        if (message.contains("打开")){
            this.on();
        } else if (message.contains("关闭")) {
            this.off();
        }else {
            new RuntimeException("没有这个功能");
        }
    }

    // 打开家电
    private void on(){
        light.on();
        tv.on();
    }

    // 关闭家电
    private void off(){
        light.off();
        tv.off();
    }
}
