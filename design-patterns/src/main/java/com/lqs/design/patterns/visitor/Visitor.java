package com.lqs.design.patterns.visitor;

import com.lqs.design.patterns.visitor.animal.Cat;
import com.lqs.design.patterns.visitor.animal.Dog;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午2:14
 * @do : 访问者抽象类,抽象访问角色类
 */
public interface Visitor {
    // 给宠物猫喂食
    void feed(Cat cat);
    // 给宠物狗喂食
    void feed(Dog dog);


}
