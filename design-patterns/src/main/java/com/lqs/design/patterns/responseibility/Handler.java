package com.lqs.design.patterns.responseibility;

/**
 * @author : 李奇凇
 * @date : 2022/5/21 下午5:39
 * @do : 抽象处理者类
 */
public abstract class Handler {

    protected final static int NUM_ONE = 1;
    protected final static int NUM_THREE = 3;
    protected final static int NUM_SEVEN = 7;

    // 该领导处理的请求天数区间
    private int numStart;
    private int numEnd;

    // 声明后继者。上级领导
    private Handler nextHandler;

    // 构造方法
    public Handler(int numStart) {
        this.numStart = numStart;
    }

    public Handler(int numStart, int numEnd) {
        this.numStart = numStart;
        this.numEnd = numEnd;
    }

    // 设置上级领导对象
    public void setNextHandler(Handler nextHandler){
        this.nextHandler = nextHandler;
    }

    // 各级领导处理请假条的方法
    protected abstract void handleLeave(LeaveRequest leaveRequest);

    // 提交请假条
    public final void subMit(LeaveRequest leave){
        // 该领导先进行审批
        this.handleLeave(leave);
        if (this.nextHandler != null && leave.getNum() > this.numEnd){
            // 提交给上级领导进行审批
            this.nextHandler.subMit(leave);
        }else {
            System.out.println("流程结束");
        }
    }
}
