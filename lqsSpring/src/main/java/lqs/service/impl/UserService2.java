package lqs.service.impl;

import lqs.service.UserService;
import spring.annotation.Component;

/**
 * @author : 李奇凇
 * @date : 2022/5/8 19:33
 * @do :
 */
@Component
public class UserService2 implements UserService {
    @Override
    public void userTestMethod() {
        System.out.println("我是第一个");
    }
}
