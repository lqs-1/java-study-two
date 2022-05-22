package com.lqs.design.patterns.state;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 上午10:53
 * @do : 抽象状态类
 */
public abstract class LiftState {

    // 申明环境角色类变量
    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    // 电梯开门操作
    public abstract void open();
    // 电梯关门操作
    public abstract void close();
    // 电梯运行操作
    public abstract void run();
    // 电梯停止操作
    public abstract void stop();
}
