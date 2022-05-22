package com.lqs.springframework.beans;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午6:04
 * @do : 用来封装bean标签下的property标签的属性
 *       name属性
 *       ref属性
 *       value属性
 */
public class PropertyValue {

    private String name;
    private String ref;
    private String value;


    public PropertyValue() {
    }

    public PropertyValue(String name, String ref, String value) {
        this.name = name;
        this.ref = ref;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
