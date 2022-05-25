package com.lqs.springsecuritydemo.pojo;

import java.io.Serializable;

/**
 * @author : 李奇凇
 * @date : 2022/5/25 下午9:35
 * @do :
 */
public class User implements Serializable {

    private Integer id;
    private String username;
    private String password;
    private String roles;
    private String auth;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + roles + '\'' +
                ", auth='" + auth + '\'' +
                '}';
    }
}
