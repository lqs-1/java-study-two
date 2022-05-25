package com.lqs.springsecurityoauth2fast.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author : 李奇凇
 * @date : 2022/5/24 下午8:14
 * @do : 资源服务器配置
 */
@Configuration
@EnableResourceServer // 启用资源服务器对应的配置
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated() // 所有页面都要登录
                .and()
                .requestMatchers() // 匹配需要保护的资源
                .antMatchers("/user/**"); // /user下面的所有资源收到保护
    }
}
