package com.lqs.springsecurityfast.handle;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : 李奇凇
 * @date : 2022/5/23 下午6:59
 * @do : 自定义认证成功以后的跳转页面，前后分离的时候用
 */
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private String url;

    public MyAuthenticationSuccessHandler(String url){
        this.url = url;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        // 获取客户端ip
        System.out.println(request.getRemoteAddr());

        // 获取SpringSecurity里面的User对象
        User user = (User) authentication.getPrincipal();
        // 获取权限列表
        System.out.println(user.getAuthorities());
        //  获取用户名
        System.out.println(user.getUsername());
        // 获取用户密码，null，为了安全
        System.out.println(user.getPassword());
        response.sendRedirect(this.url);
    }
}
