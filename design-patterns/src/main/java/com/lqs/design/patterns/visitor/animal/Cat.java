package com.lqs.design.patterns.visitor.animal;

import com.lqs.design.patterns.visitor.Animal;
import com.lqs.design.patterns.visitor.Visitor;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午2:18
 * @do : 具体元素角色类（宠物猫）
 */
public class Cat implements Animal {

    @Override
    public void acccept(Visitor visitor) {
        visitor.feed(this);
        System.out.println("好吃喵喵");
    }
}
