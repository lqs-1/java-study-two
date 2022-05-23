package com.lqs.springsecurityfast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author : 李奇凇
 * @date : 2022/5/23 下午4:03
 * @do : security测试
 *   在springboot中，resource资源文件夹下有两个特殊文件，一个是static另一个是templates，这两个文件夹中存放的是做前后端部分离项目时候的项目资源
 *   static中的文件一般是静态文件，可以通过外部直接方法，templates中的文件是动态文件，比如jsp，html文件等等需要渲染的文件，static中的就是一些图片等等
 *   有一个特殊的机制：
 *      静态页面的return默认是跳转到/static/目录下，
 *      当在pom.xml中引入了thymeleaf组件，动态跳转会覆盖默认的静态跳转，
 *      默认就会跳转到/templates/下，注意看两者return代码也有区别，动态没有html后缀。
 *
 *
 */

@Controller
@RequestMapping("st")
public class SecurityController {

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public void login(){
    }

    @RequestMapping(value = "loginSuccess")
    public String loginSuccess(){
        return "success";
    }

    @RequestMapping(value = "loginFail")
    public String loginFail(){
        return "fail";
    }


}
