package com.lqs.springsecuritydemo.controller;

import com.lqs.springsecuritydemo.mapper.UserMapper;
import com.lqs.springsecuritydemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : 李奇凇
 * @date : 2022/5/25 下午9:45
 * @do :
 */

@RestController
@RequestMapping("user")
public class UserController {


    @Autowired
    private UserMapper userMapper;

    @GetMapping("selectAll")
    public void selectAll(){
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }



}
