package com.lqs.design.patterns.observer;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 上午11:38
 * @do : 抽象主题角色类
 */
public interface Subject {
    // 添加订阅者（观察者对象）
    void attach(Observer observer);

    // 删除订阅者
    void detach(Observer observer);

    // 通知订阅者更新消息
    void notify(String message);

}
