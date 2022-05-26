package com.lqs.springsecuritydemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author : 李奇凇
 * @date : 2022/5/25 下午9:36
 * @do : springSecurity配置类
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/user/loginPage")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/user/index");

        http.authorizeRequests()
                        .antMatchers("/user/loginPage", "/user/register", "/user/register", "/css/**", "/js/**", "/plugins/**").access("permitAll()")
                        .anyRequest().authenticated();

        http.csrf().disable();
    }
}
