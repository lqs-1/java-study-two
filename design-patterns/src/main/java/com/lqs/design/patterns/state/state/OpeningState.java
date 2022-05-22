package com.lqs.design.patterns.state.state;

import com.lqs.design.patterns.state.Context;
import com.lqs.design.patterns.state.LiftState;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 上午10:57
 * @do : 电梯开启状态类
 */
public class OpeningState extends LiftState {
    // 当前状态要执行的方法
    @Override
    public void open() {
        System.out.println("电梯开启（开门）。。。");
    }

    @Override
    public void close() {
        // 修改状态
        super.context.setLiftState(Context.CLOSING_STATE);
        // 调用当前状态中的context中的close方法
        super.context.close();
    }

    @Override
    public void run() {
        // 什么都不做，开门的时候不能运行
    }

    @Override
    public void stop() {
        // 什么都不做，开门的时候本来就是停止的
    }
}
