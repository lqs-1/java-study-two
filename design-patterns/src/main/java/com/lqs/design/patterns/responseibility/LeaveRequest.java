package com.lqs.design.patterns.responseibility;

/**
 * @author : 李奇凇
 * @date : 2022/5/21 下午5:44
 * @do : 请假条类
 */
public class LeaveRequest {
    // 姓名
    private String name;

    // 请假天数
    private int num;

    // 请假内容
    private String content;

    public LeaveRequest(String name, int num, String content) {
        this.name = name;
        this.num = num;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public String getContent() {
        return content;
    }
}
