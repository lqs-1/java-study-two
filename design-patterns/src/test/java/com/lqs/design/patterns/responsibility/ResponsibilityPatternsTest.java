package com.lqs.design.patterns.responsibility;

import com.lqs.design.patterns.responseibility.GeneralManager;
import com.lqs.design.patterns.responseibility.GroupLeader;
import com.lqs.design.patterns.responseibility.LeaveRequest;
import com.lqs.design.patterns.responseibility.Manager;

/**
 * @author : 李奇凇
 * @date : 2022/5/21 下午5:57
 * @do : 职责链模式测试, 类似于我们的这个请假的案例
 *       在请假的时候，我们的请假天数如果是一天，那么小组长有权利直接同意
 *       如果是两到三天，那么就需要部门领导人同意，这个前提是小组长同意之后
 *       如果是三到七天，那么就需要总经理同意，这个前提是小组长同意和部门领导人同意之后
 *       这个是动态的，如果给定请假的天数，自动执行到所规定的地方
 *
 *       不能保证没一个请求一定被处理，因为没有明确的接收者
 */
public class ResponsibilityPatternsTest {

    public static void main(String[] args) {
        // 创建一个请假条对象
        LeaveRequest request = new LeaveRequest("lqs",1,"身体不舒服");

        // 创建各级领导对象,处理者对象
        GroupLeader groupLeader = new GroupLeader();
        Manager manager = new Manager();
        GeneralManager generalManager = new GeneralManager();

        // 设置处理者链
        groupLeader.setNextHandler(manager); // 组长的上级是部门负责人
        manager.setNextHandler(generalManager); //部门负责人的上级是总经理

        // 提交请假申请
        groupLeader.subMit(request);


    }

}
