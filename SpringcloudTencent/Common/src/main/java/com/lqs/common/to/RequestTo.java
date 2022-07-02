package com.lqs.common.to;

import java.io.Serializable;

/**
 * @author 李奇凇
 * @date 2022年07月02日 下午3:38
 * @do 请用一句话描述该类功能
 */
public class RequestTo implements Serializable {

    private String name;

    private Long age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
