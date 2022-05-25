package com.lqs.springsecurityoauth2fast.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @author : 李奇凇
 * @date : 2022/5/24 下午7:51
 * @do :
 */
@Configuration
public class SecurityMethodBeanConfig {


    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    // 密码的加密器
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    // 使用redis存储token配置
    @Bean
    public TokenStore redisStoreToken(){
        return new RedisTokenStore(redisConnectionFactory);
    }


}
