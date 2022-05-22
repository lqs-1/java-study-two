package com.lqs.design.patterns.state;

import com.lqs.design.patterns.state.state.RuningState;
import com.lqs.design.patterns.state.state.StopingState;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 上午10:52
 * @do : 状态模式测试
 *       状态模式：
 *          需要一个环境角色，抽象状态角色，具体状态角色
 *
 *          在本案例中，我们电梯有四个状态，停止运行，开始运行，开门和关门
 *          我们定义了对应这四个状态的具体状态类，又定义了公共的抽象类，还定义了一个上下文对象（环境角色类Context）
 *
 *          第一次是初始状态，由我们自己传递给环境角色类
 *          后面的，会根据我们要执行的状态自动的原则使用哪一个状态类，执行哪一个状态方法
 */
public class StatePatternsTest {

    public static void main(String[] args) {
        // 创建环境角色对象
        Context context = new Context();
        // 设置当前电梯状态
        context.setLiftState(new StopingState());
        // 如果开门就不能运行等等逻辑
        context.open();
        context.close();
        context.run();
        context.stop();
    }


}
