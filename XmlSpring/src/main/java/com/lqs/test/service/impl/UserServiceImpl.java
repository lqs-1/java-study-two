package com.lqs.test.service.impl;

import com.lqs.test.domain.User;
import com.lqs.test.service.UserService;

/**
 * @author : 李奇凇
 * @date : 2022/5/23 上午10:03
 * @do :
 */
public class UserServiceImpl implements UserService {


    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void print() {
        System.out.println("userService里面的打印");
        System.out.println(user);
        System.out.println("userService打印结束");
    }
}
