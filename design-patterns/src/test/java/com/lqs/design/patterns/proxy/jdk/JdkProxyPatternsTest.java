package com.lqs.design.patterns.proxy.jdk;

import com.lqs.design.patterns.proxy.jdk.pojo.Product;

/**
 * @author : 李奇凇
 * @date : 2022/5/16 19:03
 * @do : jdk动态代理的测试
 */
public class JdkProxyPatternsTest {

    public static void main(String[] args) {
        JdkProxyFactory jdkProxyFactory = new JdkProxyFactory();
        Product proxyObject = jdkProxyFactory.getProxyObject();

        proxyObject.run();
    }

}
