package com.publisher.publisher.controller;

import com.publisher.publisher.mq.RabbitMqPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("mq")
public class RabbitController {

    @Autowired
    private RabbitMqPublisher rabbitMqPublisher;

    @PostMapping("publisher")
    public String publisher(@RequestBody Map<String, Object> params){

        try{
            rabbitMqPublisher.publisherOne(params);
            // 成功返回数据
            return "ok";
        }catch (Exception e){
            e.printStackTrace();
            // 失败返回错误信息
            return "失败";
        }
    }


}
