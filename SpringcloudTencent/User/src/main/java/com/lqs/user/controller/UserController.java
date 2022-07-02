package com.lqs.user.controller;

import com.lqs.common.to.RequestTo;
import com.lqs.common.utils.R;
import com.lqs.user.feign.GoodsFeignServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李奇凇
 * @date 2022年07月02日 下午1:44
 * @do 测试user模块
 */

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private GoodsFeignServer goodsFeignServer;


    @GetMapping("user")
    public R getUser(){
        return R.ok().put("user", "haha_user");
    }

    @GetMapping("origin")
    public R origin(){
        return goodsFeignServer.local();
    }

    @PostMapping("plusOrigin")
    public R plusOrigin(){
        RequestTo requestTo = new RequestTo();
        requestTo.setAge(12L);
        requestTo.setName("lqs");
        return goodsFeignServer.plusLocal(requestTo);
    }

}
