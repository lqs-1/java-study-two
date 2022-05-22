package com.lqs.design.patterns.visitor.visitor;

import com.lqs.design.patterns.visitor.Visitor;
import com.lqs.design.patterns.visitor.animal.Cat;
import com.lqs.design.patterns.visitor.animal.Dog;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午2:21
 * @do : 具体访问者角色类（别人）
 */
public class SomeOne implements Visitor {
    @Override
    public void feed(Cat cat) {
        System.out.println("别人喂猫");
    }

    @Override
    public void feed(Dog dog) {
        System.out.println("别人喂狗");
    }
}
