package com.lqs.design.patterns.visitor;

import com.lqs.design.patterns.visitor.animal.Cat;
import com.lqs.design.patterns.visitor.animal.Dog;
import com.lqs.design.patterns.visitor.visitor.Owner;
import com.lqs.design.patterns.visitor.visitor.SomeOne;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午2:14
 * @do : 访问者模式测试,
 *      访问者模式：
 *          就比如就是，有一个宠物狗，自己可以喂，别人也可以喂，自己和别人就都是访问者，宠物狗就属于具体的元素，当然有很多的具体元素
 */
public class VisitorPatternsTest {

    public static void main(String[] args) {
        // 创建Home对象
        Home home = new Home();
        // 添加元素到home
        home.add(new Cat());
        home.add(new Dog());
        // 创建主人对象和别人对象，也就是访问者
        Owner owner = new Owner();
        SomeOne someOne = new SomeOne();

        home.action(someOne);
    }

}
