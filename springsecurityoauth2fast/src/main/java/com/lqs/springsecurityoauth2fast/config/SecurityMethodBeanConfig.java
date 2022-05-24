package com.lqs.springsecurityoauth2fast.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author : 李奇凇
 * @date : 2022/5/24 下午7:51
 * @do :
 */
@Configuration
public class SecurityMethodBeanConfig {

    // 密码的加密器
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
