package com.lqs.design.patterns.visitor;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午2:17
 * @do : 抽象元素角色类
 */
public interface Animal {

    // 接受访问者访问的功能
    void acccept(Visitor visitor);

}
