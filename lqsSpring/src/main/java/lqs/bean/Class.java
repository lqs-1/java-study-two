package lqs.bean;

import spring.annotation.Component;

/**
 * @author : 李奇凇
 * @date : 2022/5/6 16:38
 * @do :
 */

@Component("aClass")
public class Class {

    private String name = "移动2002";

    private Long num = 40L;


    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
