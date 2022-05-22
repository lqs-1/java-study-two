package com.lqs.design.patterns.interpreter;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午3:41
 * @do : 抽象表达式类
 */
public abstract class AbstractExpression {

    public abstract int interpret(Context context);

}
