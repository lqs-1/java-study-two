package lqs.service.impl;

import lqs.bean.Class;
import lqs.bean.User;
import lqs.service.UserService;
import spring.annotation.Autowired;
import spring.annotation.Component;

/**
 * @author : 李奇凇
 * @date : 2022/5/8 16:37
 * @do :
 */
@Component
public class UserServiceImpl implements UserService {


    @Autowired
    private User user;

    @Autowired
    private Class aClass;


    @Override
    public void userTestMethod() {
        user.test();
        System.out.println("抓到你了");
        System.out.println(aClass.getName());
    }
}
