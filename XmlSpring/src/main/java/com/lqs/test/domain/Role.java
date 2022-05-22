package com.lqs.test.domain;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午9:27
 * @do :
 */
public class Role {

    private User user;

    private String role;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
