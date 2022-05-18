package com.lqs.design.patterns.proxy.jdk;

import com.lqs.design.patterns.proxy.jdk.pojo.Product;
import com.lqs.design.patterns.proxy.jdk.pojo.ProductImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : 李奇凇
 * @date : 2022/5/16 18:48
 * @do : jdk动态代理的工厂类，用于生产代理对象,jdk动态代理，是基于接口的，也就是说使用jdk动态代理，
 *       就必须有接口被实现，然后生成的代理对象也是这些接口的一个实现类，因为这样在执行对应的代理对象的方法的时候，才会知道要执行目标对象的中的某个方法，
 *       执行过程大概就是，在执行代理对象的方法的时候，代理对象会在这个方法里面去调用目标对象的这个方法
 */
public class JdkProxyFactory {
    private Product product = new ProductImpl();

    public Product getProxyObject(){

        Object proxyInstance = Proxy.newProxyInstance(
                product.getClass().getClassLoader(),  // 第一个参数是一个类加载器，用于将动态产生的代理对象，加载到内存
                product.getClass().getInterfaces(), // 第二个参数是获取对应目标类实现的接口们
                new InvocationHandler() {  // 第三个参数是一个匿名内部内，用于对对象的扩展，和执行对象的方法
                    @Override
                    public Object invoke(
                            Object proxy, // 第一个参数就是产生的代理对象,基本不用
                            Method method,  // 第二个是被执行的方法
                            Object[] args // 第三个是这个方法的参数
                    ) throws Throwable {
                        System.out.println("我是增强JDK方式");
                        Object obj = method.invoke(product, args);  // 使用对应的原始对象执行方法
                        return obj; // 返回的是对应方法的返回值
                    }
                }

        );

        return (Product) proxyInstance;

    }


}
