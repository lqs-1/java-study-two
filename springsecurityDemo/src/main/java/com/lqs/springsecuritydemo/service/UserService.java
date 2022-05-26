package com.lqs.springsecuritydemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lqs.springsecuritydemo.pojo.User;

/**
 * @author : 李奇凇
 * @date : 2022/5/26 上午11:20
 * @do :
 */
public interface UserService extends IService<User> {

    User selectUserByUserName(String userName);

    void registerUser(User user);
}
