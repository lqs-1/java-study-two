package com.lqs.springsecuritydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author : 李奇凇
 * @date : 2022/5/25 下午9:28
 * @do :
 */

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SpringSecurityApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

}
