package com.lqs.springsecurityoauth2fast.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @author : 李奇凇
 * @date : 2022/5/24 下午8:08
 * @do : 授权服务器配置
 */
@Configuration
@EnableAuthorizationServer // 启用授权服务器对应的配置
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                // 配置client-id
                .withClient("admin")
                // 配置client-secret
                .secret(passwordEncoder.encode("123456"))

                // 配置访问token的有效期
                .accessTokenValiditySeconds(3600)
                // 配置redirect_uri,用于授权成功后跳转
                .redirectUris("https://www.jd.com")

                // 配置申请的权限范围
                .scopes("all")
                // 配置授权模式，grant_type为授权码模式
                .authorizedGrantTypes("authorization_code");
    }
}
