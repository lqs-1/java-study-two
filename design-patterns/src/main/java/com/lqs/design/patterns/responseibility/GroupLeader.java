package com.lqs.design.patterns.responseibility;

/**
 * @author : 李奇凇
 * @date : 2022/5/21 下午5:50
 * @do : 小组长类，具体的处理者
 */
public class GroupLeader extends Handler {

    public GroupLeader(){
        // 小组长只能处理不一天的
        super(0, Handler.NUM_ONE);
    }

    @Override
    protected void handleLeave(LeaveRequest leaveRequest) {
        System.out.println(leaveRequest.getName() + "请假" + leaveRequest.getNum() + "天" + leaveRequest.getContent());
        System.out.println("小组长审批：同意");
    }
}
