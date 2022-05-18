package lqs.bean;


import spring.context.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : 李奇凇
 * @date : 2022/5/6 21:24
 * @do :
 */

//@Component
public class LiqisongBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(String beanName, Object bean) {

        if (bean instanceof BeanPostProcessor){

            System.out.println("我是: " + beanName + " 我实现的接口是: " + BeanPostProcessor.class.getTypeName());
        }

        return bean;
    }




    @Override
    public Object postProcessAfterInitialization(String beanName, Object bean) {

        if (bean instanceof User){

            /**
             * jdk和cglib代理：  最重要的就是接口，也挺麻烦的， 如果这个代理对象要完全代理目标类，那么就需要在接口中写全目标类的方法
             *  两个概念：代理接口     被代理类（目标类）
             *  第一步：创建一个接口，这个接口就代表的是代理对象，最终生成的对象就是这个类型
             *  第二步：让被代理对象实现这个接口
             *  第三步: 在后置处理器里创建对应的代理对象，并且返回这个对象
             *  第四步：在getBean的时候，beanName是被代理对象的beanName，但是返回的对象却是代理对象这个接口
             *  第五步: 只要实现了代理对象接口里的方法，那么在调用的时候，就会代理被代理对象的具体逻辑
             */

            // 生成jdk代理对象
            Object proxyInstance = Proxy.newProxyInstance (bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {

                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                    return method.invoke(bean, args);

                }

            });


            // cglib代理，和jdk代理差不多
            /*Object proxyInstance1 = Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                    return method.invoke(bean, objects);
                }
            });*/


            return proxyInstance;

        }

        return bean;

    }




}
