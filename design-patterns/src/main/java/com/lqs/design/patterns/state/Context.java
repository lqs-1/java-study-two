package com.lqs.design.patterns.state;

import com.lqs.design.patterns.state.state.ClosingState;
import com.lqs.design.patterns.state.state.OpeningState;
import com.lqs.design.patterns.state.state.RuningState;
import com.lqs.design.patterns.state.state.StopingState;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 上午10:54
 * @do : 环境角色类
 */
public class Context {

    // 定义对应状态对象的常量
    public final static OpeningState OPENING_STATE = new OpeningState();
    public final static ClosingState CLOSING_STATE = new ClosingState();
    public final static RuningState RUNING_STATE = new RuningState();
    public final static StopingState STOPING_STATE = new StopingState();

    // 接收当前状态变量
    private LiftState liftState;

    public LiftState getLiftState() {
        return liftState;
    }

    // 设置当前状态对象
    public void setLiftState(LiftState liftState) {
        this.liftState = liftState;
        // 设置当前状态对象的context对象
        this.liftState.setContext(this);
    }

    public void open(){
        this.liftState.open();
    }

    public void close(){
        this.liftState.close();
    }

    public void run(){
        this.liftState.run();
    }

    public void stop(){
        this.liftState.stop();
    }
}
