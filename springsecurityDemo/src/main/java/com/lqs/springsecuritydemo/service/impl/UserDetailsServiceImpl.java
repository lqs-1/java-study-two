package com.lqs.springsecuritydemo.service.impl;

import com.lqs.springsecuritydemo.pojo.MyUser;
import com.lqs.springsecuritydemo.pojo.User;
import com.lqs.springsecuritydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 李奇凇
 * @date : 2022/5/26 上午11:21
 * @do : 自定义用户认证逻辑
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.selectUserByUserName(username);
        if (user == null){
            throw new UsernameNotFoundException("没有这个用户");
        }

        String password = user.getPassword();
        String auth = user.getAuth();
        String roles = user.getRoles();

        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();

        if (auth != null && !auth.equals("")){
            String[] authes = auth.split(",");
            for (String authe : authes) {
                simpleGrantedAuthorities.add(new SimpleGrantedAuthority(authe));
            }
        }

        if (roles != null && !roles.equals("")){
            String[] roless = roles.split(",");
            for (String role : roless) {
                simpleGrantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role));
            }
        }


        return new MyUser(username, password, simpleGrantedAuthorities);
    }
}
