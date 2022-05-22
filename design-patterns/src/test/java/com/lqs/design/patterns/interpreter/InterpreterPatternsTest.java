package com.lqs.design.patterns.interpreter;

import com.lqs.design.patterns.interpreter.expression.Minus;
import com.lqs.design.patterns.interpreter.expression.Plus;
import com.lqs.design.patterns.interpreter.expression.Veriable;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午3:54
 * @do : 解释器模式测试类
 */
public class InterpreterPatternsTest {

    public static void main(String[] args) {
        // 创建环境对象
        Context context = new Context();
        // 创建多个变量对象并存储到环境中
        Veriable a = new Veriable("a");
        Veriable b = new Veriable("b");
        Veriable c = new Veriable("c");
        Veriable d = new Veriable("d");
        Veriable e = new Veriable("e");
        context.assign(a, 1);
        context.assign(b, 2);
        context.assign(c, 3);
        context.assign(d, 4);
        context.assign(e, 5);
        // 获取抽象语法树 a-(b+c-d)+e
        AbstractExpression expression = new Plus(new Minus(a, new Minus(new Plus(b, c), d)), e);

        // 解释（计算）
        int result = expression.interpret(context);
        System.out.println(expression + "=" + result);
    }

}
