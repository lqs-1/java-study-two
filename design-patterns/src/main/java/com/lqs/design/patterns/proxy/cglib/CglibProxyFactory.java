package com.lqs.design.patterns.proxy.cglib;

import com.lqs.design.patterns.proxy.cglib.pojo.Product;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author : 李奇凇
 * @date : 2022/5/16 19:05
 * @do : Cglib动态代理工厂类，用于生产代理对象
 *       Cglib和Jdk的区别：
 *       1、Jdk动态代理是基于接口的，通过接口将代理对象生成为一个对应接口的实现类
 *       2、Cglib动态代理是基于目标类的，具体实现是生成一个目标类的子类，通过调用父类的方法，来调用目标对象的代理方式
 */
public class CglibProxyFactory implements MethodInterceptor {

    private Product product = new Product();


    public Product getProxyObject(){

        // 创建Enhancer增强对象,类似于JDK代理中的Proxy类
        Enhancer enhancer = new Enhancer();

        // 设置父类的字节码对象（目标类的字节码对象）
        enhancer.setSuperclass(Product.class);

        // 创建回调函数, 这个方法通过实现MethodInterceptor来获取,所以这里传递的参数就是实现了这个接口的类
        enhancer.setCallback(this);

        // 创建代理对象
        Object proxyObject = enhancer.create();

        return (Product) proxyObject;

    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib增强");
        Object obj = method.invoke(product, objects);
        return obj;
    }
}
