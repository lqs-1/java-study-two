package com.lqs.springsecurityfast.service.impl;

import com.lqs.springsecurityfast.service.MyService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * @author : 李奇凇
 * @date : 2022/5/24 下午2:13
 * @do : 自定义认证方式实现
 */
@Service // 要将这个类放到springioc中配置文件才能直接使用
public class MyServiceImpl implements MyService {
    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        // 获取请求地址
        String requestURI = request.getRequestURI();
        // 获取认证实体
        Object object = authentication.getPrincipal();
        // 判断认证实体是否是UserDetails类型
        if (object instanceof UserDetails){
            // 强转
            UserDetails userDetails = (UserDetails) object;
            // 获取UserDetails对象中的权限集合
            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
            // 判断权限列表中是否有这个对应的请求路径权限
            return authorities.contains(new SimpleGrantedAuthority(requestURI));
            /**
             * authorities这个权限列表中，的权限就是从数据库中差出来的数据，差出来的角色和权限，这里就是判断这个用户是不是真的有访问这个路径的权限
             */
        }
        return false;
    }
}
