package com.lqs.design.patterns.responseibility;

/**
 * @author : 李奇凇
 * @date : 2022/5/21 下午5:50
 * @do : 部门经理类，具体的处理者
 */
public class Manager extends Handler {

    public Manager(){
        // 小组长只能处理不一天的
        super(Handler.NUM_ONE, Handler.NUM_THREE);
    }

    @Override
    protected void handleLeave(LeaveRequest leaveRequest) {
        System.out.println(leaveRequest.getName() + "请假" + leaveRequest.getNum() + "天" + leaveRequest.getContent());
        System.out.println("部门经理审批：同意");
    }
}
