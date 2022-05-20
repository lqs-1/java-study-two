package com.lqs.design.patterns.flyweight;

/**
 * @author : 李奇凇
 * @date : 2022/5/20 下午12:25
 * @do : O图形类 （具体享元角色）
 */
public class OBox extends AbstractBox{
    @Override
    public String getShape() {
        return "O";
    }
}
