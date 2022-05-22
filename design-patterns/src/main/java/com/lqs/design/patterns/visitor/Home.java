package com.lqs.design.patterns.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午2:23
 * @do : 对象结构类
 */
public class Home {

    // 存放具体元素
    private List<Animal> animalList = new ArrayList<>();

    // 添加具体的元素
    public void add(Animal animal){
        animalList.add(animal);
    }

    // 让访问这来访问所有的具体元素
    public void action(Visitor visitor){
        for (Animal animal : animalList) {
            animal.acccept(visitor);
        }
    }


}
