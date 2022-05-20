package com.lqs.design.patterns.flyweight;

/**
 * @author : 李奇凇
 * @date : 2022/5/20 下午12:23
 * @do : I图形类（具体享元角色）
 */
public class IBox extends AbstractBox{
    @Override
    public String getShape() {
        return "I";
    }
}
