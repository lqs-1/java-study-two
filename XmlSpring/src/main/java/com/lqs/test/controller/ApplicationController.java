package com.lqs.test.controller;

import com.lqs.springframework.context.ApplicationContext;
import com.lqs.springframework.context.support.ClassPathXmlApplicationContext;
import com.lqs.test.domain.Role;
import com.lqs.test.domain.User;
import com.lqs.test.service.UserService;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午9:29
 * @do :
 */
public class ApplicationController {

    public static void main(String[] args) throws Exception {
        ApplicationContext app = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        String[] beanDefinitionNames = app.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        System.out.println("============================================");

        UserService bean = app.getBean(UserService.class);

        User bean1 = app.getBean(User.class);
        System.out.println(bean1);

        bean.print();
    }

}
