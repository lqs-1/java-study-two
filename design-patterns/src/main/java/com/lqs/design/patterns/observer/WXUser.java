package com.lqs.design.patterns.observer;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 上午11:45
 * @do : 具体的观察者角色类
 */
public class WXUser implements Observer{

    private String userName;

    public WXUser(String userName){
        this.userName = userName;
    }

    @Override
    public void update(String message) {
        System.out.println(userName + "-" + message);
    }
}
