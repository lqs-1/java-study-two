package com.lqs.design.patterns.observer;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 上午11:46
 * @do : 观察者模式测试，这个案例就是威信公众号的案例
 *       如果订阅者太多的话，一定会有延时
 */
public class ObserverPatternsTest {

    public static void main(String[] args) {
        // 创建公众号对象
        SubscriptionSubject subject = new SubscriptionSubject();

        // 订阅公众号
        subject.attach(new WXUser("lqs"));
        subject.attach(new WXUser("l22"));
        subject.attach(new WXUser("l33"));

        // 公众号更新，发布消息给订阅者
        subject.notify("大家好");
    }

}
