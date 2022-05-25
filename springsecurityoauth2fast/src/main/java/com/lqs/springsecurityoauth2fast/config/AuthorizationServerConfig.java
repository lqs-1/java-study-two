package com.lqs.springsecurityoauth2fast.config;

import com.lqs.springsecurityoauth2fast.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

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

    @Autowired
    private UserDetailsServiceImpl userDetailsService;


    // 使用密码模式的时候需要注入的身份认证管理器
    @Autowired
    private AuthenticationManager authenticationManager;

    // 注入token存储的bean，我们使用的是redis存储token
    @Autowired
    private TokenStore redisStore;

    // 使用密码模式所需配置
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // endpoints.authenticationManager(authenticationManager); // 如果是将token存储在内存中就使用这一条
        endpoints.authenticationManager(authenticationManager) // 如果要将token存储到redis就使用这一条
                .userDetailsService(userDetailsService) // 将User认证对象传进去。方便存储
                .tokenStore(redisStore); // 将存储对象传进去
    }

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
                .authorizedGrantTypes("authorization_code", "password");
    }

    /**
     * 1、授权码模式：
     *    需要一个client-id和secret，这个就是开发者的用户和密码
     *    设置token的有效期
     *    需要一个授权成功之后的跳转页面（跳过去会带有一个code=xxxx，也就是授权码）
     *    设置有效范围
     *    设置授权模式，可以多个并存
     * 2、密码模式：
     *    需要一个client-id和secret，这个就是开发者的用户和密码
     *    设置token的有效期
     *    设置有效范围
     *    设置授权模式，可以多个并存
     */
}
