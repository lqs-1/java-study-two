package com.lqs.design.patterns.state.state;

import com.lqs.design.patterns.state.Context;
import com.lqs.design.patterns.state.LiftState;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 上午10:57
 * @do : 电梯运行状态类
 */
public class RuningState extends LiftState {
    @Override
    public void open() {
        // 什么都不做，运行的时候开电梯门，找死
    }

    @Override
    public void close() {
        // 什么都不做，运行的时候本来就是关着门的
    }

    // 当前要执行的状态方法
    @Override
    public void run() {
        System.out.println("电梯运行了");
    }

    @Override
    public void stop() {
        super.context.setLiftState(Context.STOPING_STATE);
        super.context.stop();
    }
}
