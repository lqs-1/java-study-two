package com.lqs.design.patterns.visitor.visitor;

import com.lqs.design.patterns.visitor.Visitor;
import com.lqs.design.patterns.visitor.animal.Cat;
import com.lqs.design.patterns.visitor.animal.Dog;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午2:21
 * @do : 具体访问者角色类（主人）
 */
public class Owner implements Visitor {
    @Override
    public void feed(Cat cat) {
        System.out.println("主人喂猫");
    }

    @Override
    public void feed(Dog dog) {
        System.out.println("主任喂狗");
    }
}
