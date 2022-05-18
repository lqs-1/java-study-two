package com.redis.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RestController
@RequestMapping("lqs")
public class RedisController {



    @Autowired
    JedisPool jedisPool;


    @GetMapping("lqs")
    public String get(){
        Jedis resource = jedisPool.getResource();
        resource.set("name", "liqisongliqisong");
        return "ok";
    }




}
