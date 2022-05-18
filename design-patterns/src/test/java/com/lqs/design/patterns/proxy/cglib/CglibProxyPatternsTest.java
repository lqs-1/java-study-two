package com.lqs.design.patterns.proxy.cglib;

import com.lqs.design.patterns.proxy.cglib.pojo.Product;

/**
 * @author : 李奇凇
 * @date : 2022/5/16 19:19
 * @do : cglib动态代理测试
 */
public class CglibProxyPatternsTest {

    public static void main(String[] args) {
        CglibProxyFactory cglibProxyFactory = new CglibProxyFactory();

        Product proxyObject = cglibProxyFactory.getProxyObject();

        proxyObject.run();
    }

}
