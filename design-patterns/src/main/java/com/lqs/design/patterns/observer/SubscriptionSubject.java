package com.lqs.design.patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 上午11:41
 * @do : 具体主题类
 */
public class SubscriptionSubject implements Subject {

    // 定义一个集合，用来存储多个观察者对象
    private List<Observer> wxUserList = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        wxUserList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        wxUserList.remove(observer);
    }

    @Override
    public void notify(String message) {
        // 将新消息更新给每一个观察者，如果观察者太多，会有延时
        for (Observer observer : wxUserList) {
            observer.update(message);
        }
    }
}
