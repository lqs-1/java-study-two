package com.lqs.design.patterns.interpreter;

import com.lqs.design.patterns.interpreter.expression.Veriable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午3:42
 * @do : 环境角色类
 */
public class Context {

    // 定义一个map集合，用来存储变量及对应的值
    private Map<Veriable, Integer> map = new HashMap<>();

    // 添加变量的功能
    public void assign(Veriable veriable, Integer value){
        map.put(veriable, value);
    }

    // 根据变量获取对应的值
    public int getValue(Veriable veriable){
        return map.get(veriable);
    }

}
