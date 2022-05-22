package com.lqs.springframework.beans;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午6:55
 * @do : 用来存储bean的信息
 *      id
 *      class
 *      propertyvalue
 */
public class BeanDefinition {

    private String id;
    private String className;
    private MutablePropertyValues propertyValues;

    public BeanDefinition() {
        this.propertyValues = new MutablePropertyValues();
    }

    public BeanDefinition(String id, String className, MutablePropertyValues propertyValues) {
        this.id = id;
        this.className = className;
        this.propertyValues = propertyValues;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public MutablePropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(MutablePropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
