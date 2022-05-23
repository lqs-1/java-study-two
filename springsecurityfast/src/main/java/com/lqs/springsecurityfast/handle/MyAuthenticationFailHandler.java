package com.lqs.springsecurityfast.handle;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : 李奇凇
 * @date : 2022/5/23 下午7:03
 * @do : 自定义认证失败以后的跳转页面，前后分离的时候用
 */
public class MyAuthenticationFailHandler implements AuthenticationFailureHandler {

    private String url;

    public MyAuthenticationFailHandler(String url){
        this.url = url;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.sendRedirect(this.url);
    }
}
