package com.lqs.design.patterns.state.state;

import com.lqs.design.patterns.state.Context;
import com.lqs.design.patterns.state.LiftState;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 上午10:57
 * @do : 电梯停止状态类
 */
public class StopingState extends LiftState {
    @Override
    public void open() {
        super.context.setLiftState(Context.OPENING_STATE);
        super.context.open();
    }

    @Override
    public void close() {
        super.context.setLiftState(Context.CLOSING_STATE);
        super.context.close();
    }

    @Override
    public void run() {
        super.context.setLiftState(Context.RUNING_STATE);
        super.context.run();
    }

    // 电梯当前状态执行方法
    @Override
    public void stop() {
        System.out.println("电梯停止了");
    }
}
