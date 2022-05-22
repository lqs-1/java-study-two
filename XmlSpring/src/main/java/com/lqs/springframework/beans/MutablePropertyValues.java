package com.lqs.springframework.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午6:08
 * @do : 用户存储和管理的多个PropertyValue对象
 */
public class MutablePropertyValues implements Iterable<PropertyValue>{

    // 定义list对象，用来存储PropertyValue对象
    private final List<PropertyValue> propertyValueList;

    public MutablePropertyValues() {
        this.propertyValueList = new ArrayList<PropertyValue>();
    }

    public MutablePropertyValues(List<PropertyValue> propertyValueList) {
        if (propertyValueList == null){
            this.propertyValueList = new ArrayList<PropertyValue>();
        }else {
            this.propertyValueList = propertyValueList;
        }
    }

    // 获取所有的PropertyValue对象，返回数组的形式
    public PropertyValue[] getPropertyValues(){
        // 将集合转换为数组并返回
        return propertyValueList.toArray(new PropertyValue[0]);
    }

    // 根据name获取对应的PropertyValue对象
    public PropertyValue getPropertyValue(String propertyName){
        // 遍历集合对象
        for (PropertyValue propertyValue : propertyValueList) {
            if (propertyValue.getName().equals(propertyName)){
                return propertyValue;
            }
        }
        return null;
    }

    // 判断集合是否为空
    public boolean isEmpty(){
        return propertyValueList.isEmpty();
    }

    // 添加PropertyValue对象
    public MutablePropertyValues addPropertyValue(PropertyValue propertyValue){
        // 判断集合中存储的PropertyValue对象是否和存储的重复了，如果是，进行覆盖
        for (int i = 0; i < propertyValueList.size(); i++){
            // 获取集合中没一个PropertyValue对象
            PropertyValue pv = propertyValueList.get(i);
            if (pv.getName().equals(propertyValue.getName())){
                propertyValueList.set(i, propertyValue);
                return this; // 目的实现链式编程
            }
        }
        this.propertyValueList.add(propertyValue);
        return this;
    }

    // 判断是否存在指定的PropertyValue
    public boolean contains(PropertyValue propertyValue){
        return this.getPropertyValue(propertyValue.getName()) != null;
    }

    // 获取迭代器对象
    @Override
    public Iterator<PropertyValue> iterator() {
        return propertyValueList.iterator();
    }
}
