package com.lqs.springsecurityfast.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    // @Secured("ROLE_abc") // 用在类或者方法上面， 在执行对应的方法或者对应类的方法的时候，先进行权限的判断，这里表示具有这个角色的才能访问，这里的参数只能有一个,且参数必须加上ROLE_
    @PreAuthorize("hasAuthority('admin') and hasAnyRole('abc')") // 用在类或者方法上面， 在执行对应的方法或者对应类的方法之前进行权限判断， 大多数情况下使用的都是这个注解，这个注解的参数和access方法参数取值相同，都是权限表达式, 如果是角色表达式可以ROLE_xxx，也可以不加ROLE_
    // @PostAuthorize("hasRole('abc') and hasAuthority('admin')")  // 用在类或者方法上面， 在执行对应的方法或者对应类的方法之后进行权限判断， 很少使用这个注解，这个注解的参数和access方法参数取值相同，都是权限表达式, 如果是角色表达式可以ROLE_xxx，也可以不加ROLE_
    @RequestMapping("annotation")
    @ResponseBody
    public String annotation(){
        return "hah";
    }


}
