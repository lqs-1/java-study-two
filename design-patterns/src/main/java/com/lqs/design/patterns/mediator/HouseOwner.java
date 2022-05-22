package com.lqs.design.patterns.mediator;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午12:01
 * @do : 具体的同事角色类
 */
public class HouseOwner extends Persion {
    public HouseOwner(String name, Mediator mediator) {
        super(name, mediator);
    }

    // 和中介沟通的方法
    public void constact(String message){
        mediator.constact(message, this);
    }

    // 获取信息
    public void getMessage(String message){
        System.out.println("房主" + name + "获取到的信息：" + message);
    }


}
