package com.lqs.design.patterns.state.state;

import com.lqs.design.patterns.state.Context;
import com.lqs.design.patterns.state.LiftState;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 上午10:57
 * @do : 电梯关闭状态类
 */
public class ClosingState extends LiftState {
    @Override
    public void open() {
        super.context.setLiftState(Context.OPENING_STATE);
        super.context.open();
    }

    // 当前状态要执行的方法
    @Override
    public void close() {
        System.out.println("电梯关闭了（关门）。。。");
    }

    @Override
    public void run() {
        super.context.setLiftState(Context.RUNING_STATE);
        super.context.run();
    }

    @Override
    public void stop() {
        super.context.setLiftState(Context.STOPING_STATE);
        super.context.stop();
    }
}
