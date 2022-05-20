package com.lqs.design.patterns.template;

/**
 * @author : 李奇凇
 * @date : 2022/5/20 下午12:55
 * @do : 模板模式测试
 *       模板模式：
 *          在面向对象的设计过程中，程序员常常会遇到这种情况：设计一个系统时候知道了算法所需的关键步骤，而且确定了这些步骤的执行顺序，比如炒菜，
 *          但是这些步骤中的一些步骤实现还是未知的，或者说某些步骤的实现与具体的环境相关，就是用这个中模式
 */
public class TemplatePatternsTest {

    public static void main(String[] args) {
        // 炒包菜
        ConcreateClass_BaoCai baoCai = new ConcreateClass_BaoCai();
        baoCai.cookProcess();


        System.out.println("==============");

        // 炒菜新
        ConcreateClass_CaiXin caiXin = new ConcreateClass_CaiXin();
        caiXin.cookProcess();
    }

}
