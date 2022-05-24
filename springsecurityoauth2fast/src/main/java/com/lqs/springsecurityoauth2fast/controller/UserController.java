package com.lqs.springsecurityoauth2fast.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : 李奇凇
 * @date : 2022/5/24 下午8:17
 * @do : 定义资源，模拟资源服务器
 */

@RestController
@RequestMapping("/user")
public class UserController {

    // 获取当前用户
    @GetMapping("/getCurrentUser")
    public Object getCurrentUser(Authentication authentication){
        return authentication.getPrincipal();
    }


}
