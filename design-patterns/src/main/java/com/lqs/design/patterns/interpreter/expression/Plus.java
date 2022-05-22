package com.lqs.design.patterns.interpreter.expression;

import com.lqs.design.patterns.interpreter.AbstractExpression;
import com.lqs.design.patterns.interpreter.Context;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午3:45
 * @do : 加法表达式类
 */
public class Plus extends AbstractExpression {

    // + 左右的表达式
    private AbstractExpression left;
    private AbstractExpression right;

    public Plus(AbstractExpression left, AbstractExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        // 将 + 左边表达式的结果和右边表达式的结果进行相加
        return left.interpret(context) + right.interpret(context);
    }

    @Override
    public String toString() {
        return "（" + left.toString() + "+" + right.toString() + ")";
    }
}
