package com.lqs.test.controller;

import com.lqs.springframework.context.ApplicationContext;
import com.lqs.springframework.context.support.ClassPathXmlApplicationContext;
import com.lqs.test.domain.User;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午9:29
 * @do :
 */
public class ApplicationController {

    public static void main(String[] args) throws Exception {
        ApplicationContext app = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        User user = (User) app.getBean("user");
        System.out.println(user.getUserName());
    }

}
