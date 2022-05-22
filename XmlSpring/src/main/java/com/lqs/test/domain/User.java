package com.lqs.test.domain;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午9:26
 * @do :
 */
public class User {
    private String userName;
    private String passWord;
    private Integer age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
