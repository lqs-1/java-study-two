package com.lqs.springsecurityfast.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author : 李奇凇
 * @date : 2022/5/23 下午4:40
 * @do : 实现UserDetailsService来自定义我们的登录逻辑
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1、查询数据库，判断用户是否存在，如果不存在，抛出异常
        System.out.println(username);
        if (!"admin".equals(username)){
            throw new UsernameNotFoundException("用户名不存在");
        }
        // 2、查询出来的密码（注册的时候已经加密过的）进行解析，获取直接把密码放入构造方法

        String password = passwordEncoder.encode("123");
        // 返回security框架内部的User对象，第一个参数是用户名，第二个参数是密码（用户数据库里面的密码），第三个是权限和角色（可以只选择权限和角色二者之一配置，也可以都配置，但是不能传null）
        // 第三个参数详解：normal,admin,ROLE_abc,ROLE_DD" ==== > normal和admin是属于权限，ROLE_abc和ROLE_DD属于角色，角色只能用ROLE_开头
        return new User(username, password, AuthorityUtils.commaSeparatedStringToAuthorityList("normal,admin,ROLE_abc,ROLE_DD"));
    }
}
