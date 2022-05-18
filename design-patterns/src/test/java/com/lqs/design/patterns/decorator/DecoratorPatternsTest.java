package com.lqs.design.patterns.decorator;

import com.lqs.design.patterns.decorator.ex.Bacon;
import com.lqs.design.patterns.decorator.ex.Egg;
import com.lqs.design.patterns.decorator.fastfood.FiredNoddles;
import com.lqs.design.patterns.decorator.fastfood.FiredRice;

/**
 * @author : 李奇凇
 * @date : 2022/5/17 13:56
 * @do : 装饰者模式测试
 */
public class DecoratorPatternsTest {

    public static void main(String[] args) {
        FastFood noddles = new FiredNoddles(20, "炒面");  // 没有配料的炒面
        FiredRice rice = new FiredRice(20, "炒饭");  // 没有配料的炒饭

        System.out.println(noddles.cost());  // 获取价格
        System.out.println(rice.cost());  // 获取价格

        noddles = new Egg(2, "鸡蛋", noddles);  // 加鸡蛋
        noddles = new Egg(2, "鸡蛋", noddles);
        noddles = new Egg(2, "鸡蛋", noddles);
        noddles = new Egg(2, "鸡蛋", noddles);
        noddles = new Egg(2, "鸡蛋", noddles);

        noddles = new Bacon(4, "培根", noddles);

        System.out.println(noddles.cost());
        System.out.println(noddles.getDesc());
    }

}
