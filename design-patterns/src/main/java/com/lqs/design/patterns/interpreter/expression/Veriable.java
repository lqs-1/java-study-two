package com.lqs.design.patterns.interpreter.expression;

import com.lqs.design.patterns.interpreter.AbstractExpression;
import com.lqs.design.patterns.interpreter.Context;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午3:42
 * @do : 封装变量的类
 */
public class Veriable extends AbstractExpression {

    // 声明存储变量名的成员变量
    private String name;

    public Veriable(String name){
        this.name = name;
    }

    @Override
    public int interpret(Context context) {
        // 直接返回变量的值
        return context.getValue(this);
    }

    @Override
    public String toString() {
        return name;
    }
}
