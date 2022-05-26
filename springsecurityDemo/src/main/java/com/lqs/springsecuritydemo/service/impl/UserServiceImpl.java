package com.lqs.springsecuritydemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lqs.springsecuritydemo.mapper.UserMapper;
import com.lqs.springsecuritydemo.pojo.User;
import com.lqs.springsecuritydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author : 李奇凇
 * @date : 2022/5/26 上午11:23
 * @do :
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserByUserName(String userName) {
        User user = userMapper.selectUserByUserName(userName);


        return user;
    }

    @Override
    public void registerUser(User user) {
        String password = user.getPassword();
        String encodePassword = passwordEncoder.encode(password);
        user.setPassword(encodePassword);
        this.baseMapper.addUser(user);
    }
}
