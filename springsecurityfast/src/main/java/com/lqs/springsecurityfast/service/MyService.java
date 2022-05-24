package com.lqs.springsecurityfast.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : 李奇凇
 * @date : 2022/5/24 下午2:10
 * @do : 自定义的认证方式
 */
public interface MyService {

    boolean hasPermission(HttpServletRequest request, Authentication authentication);

}
