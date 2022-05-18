package com.lqs.design.patterns.factory.abstractfactoryplus.factory;

import com.lqs.design.patterns.factory.abstractfactoryplus.pojo.coffee.Coffee;
import com.lqs.design.patterns.factory.abstractfactoryplus.pojo.coffee.LatteCoffee;
import com.lqs.design.patterns.factory.abstractfactoryplus.pojo.dessert.Dessert;
import com.lqs.design.patterns.factory.abstractfactoryplus.pojo.dessert.Trimisu;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author : 李奇凇
 * @date : 2022/5/16 12:09
 * @do : 意大利风味的甜品，拿铁咖啡和提拉米苏
 */
public class ItalyDessertFactory implements DessertFactory {

    // 将配置文件中的对象缓存
    private static Map<String, Object> objectMap = new HashMap<>();

    // 静态代码块，只会执行一次
    static {
        // 创建properties对象
        Properties properties = new Properties();
        // 获取配置资源输入流
        InputStream resourceAsStream = AmericanDessertFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            // 将配置资源加载到properties对象中
            properties.load(resourceAsStream);

            // 遍历properties对象，利用反射创建对象，并且缓存对象
            for (Object key : properties.keySet()) {
                // 获取对象的全类名
                String className = properties.getProperty((String) key);
                // 通过全类名加载字节码对象
                Class<?> clazz = Class.forName(className);
                // 通过字节码创建对象（反射）
                Object object = clazz.newInstance();
                // 缓存对象
                objectMap.put((String) key, object);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Coffee createCoffee(String typeName) {
        Object object = objectMap.get(typeName);
        return (Coffee) object;
    }

    @Override
    public Dessert createDessert(String typeName) {
        Object object = objectMap.get(typeName);
        return (Dessert) object;
    }
}
