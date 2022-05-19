package com.lqs.design.patterns.facede;

/**
 * @author : 李奇凇
 * @date : 2022/5/19 下午3:12
 * @do : 外观模式测试，外观模式就是在一个复杂的系统中，这个系统中有很多的子系统
 *       比如基金：
 *          基金可以用来投资、可以用来炒股等等
 *          但是用户在用的时候并不知道（并不关心这个基金究竟是干嘛了）
 *       比如一个智能音箱：
 *          一个智能音箱可以操作电视机，空调，电灯等等
 *          但是我们自己不需要直接去操作电灯
 *       就是用户通过系统提供的某个接口就可以直接的操作整个系统
 *       就是一系列组合操作
 */
public class FacedePatternsTest {

    public static void main(String[] args) {

        Smart smart = new Smart();
        smart.say("打开家电");
        System.out.println("-----------------");
        smart.say("关闭家电");

    }

}
