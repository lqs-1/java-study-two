package com.lqs.design.patterns.flyweight;

import java.util.HashMap;

/**
 * @author : 李奇凇
 * @date : 2022/5/20 下午12:26
 * @do : 工厂类，将该类设计为单例
 */
public class BoxFactory {

    private HashMap<String, AbstractBox> boxMap;

    // 在构造方法中进行初始化操作
    private BoxFactory(){
        boxMap = new HashMap<>();
        boxMap.put("I", new IBox());
        boxMap.put("L", new LBox());
        boxMap.put("O", new OBox());
    }

    // 根据名称获取图形对象,懒汗式
    public AbstractBox getShape(String boxName){
        return boxMap.get(boxName);
    }

    // 提供一个方法获取该工厂类对象
    public static BoxFactory getInstance(){
        return SingleTon.INSTANCE_OBJECT;
    }

    // 内部内单例
    private static class SingleTon{
        private static final BoxFactory INSTANCE_OBJECT = new BoxFactory();
    }


}
