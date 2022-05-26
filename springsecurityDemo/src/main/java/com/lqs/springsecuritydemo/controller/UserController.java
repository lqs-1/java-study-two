package com.lqs.springsecuritydemo.controller;

import com.lqs.springsecuritydemo.pojo.User;
import com.lqs.springsecuritydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : 李奇凇
 * @date : 2022/5/25 下午9:45
 * @do :
 */

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("register")
    public String register(@RequestParam("username") String username, @RequestParam("password") String password){

        User user = new User();
        user.setPassword(password);
        user.setUsername(username);

        try {
            userService.registerUser(user);
            return "redirect:/login.html";
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }


    @PreAuthorize("hasAnyRole('admin')")
    @GetMapping("userCenter")
    public String userCenter(){
        return "books_new";
    }



}
