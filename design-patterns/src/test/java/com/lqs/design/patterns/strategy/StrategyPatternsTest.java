package com.lqs.design.patterns.strategy;

/**
 * @author : 李奇凇
 * @date : 2022/5/20 下午3:14
 * @do : 策略模式测试
 *       策略模式：
 *       当一个系统有多种替换方案的时候，可以选择用什么策略，比如，编程可以用idea。也可以用eclipse
 *       再比如，超市在不同节气的不同促销活动
 *       这种基于接口或者抽象类的策略模式，可以避免很多if else的操作，可以选择使用哪一种方案
 */
public class StrategyPatternsTest {

    public static void main(String[] args) {
        // 春节到了，使用春节促销活动
        SaleMan saleMan = new SaleMan(new StrategyA());
        saleMan.saleManShow();

        // 中秋到了，使用中秋促销活动
        SaleMan saleMan1 = new SaleMan(new StrategyB());
        saleMan1.saleManShow();
    }

}
