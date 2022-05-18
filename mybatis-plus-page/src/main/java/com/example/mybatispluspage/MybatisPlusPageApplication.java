package com.example.mybatispluspage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//开启定时任务
@EnableScheduling
// springboot启动注解
@SpringBootApplication
public class MybatisPlusPageApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusPageApplication.class, args);
    }

}
