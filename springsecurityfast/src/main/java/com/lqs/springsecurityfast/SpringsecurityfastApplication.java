package com.lqs.springsecurityfast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
/**
 * EnableGlobalMethodSecurity注解，开启全局的方法认证
 * securedEnabled:这个开关是设置为@Secured注解能够使用
 * prePostEnabled：这个开关是设置 @PreAuthorize 和 @PostAuthorize注解能够使用
 */

public class SpringsecurityfastApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringsecurityfastApplication.class, args);
    }


    @Bean
    // 加密对象，用来对数据进行加密，在我们项目中用于对密码的加密
    public PasswordEncoder passwrodEncoder(){
        return new BCryptPasswordEncoder();
    }

}
