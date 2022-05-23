package com.lqs.springsecurityfast.config;

import com.lqs.springsecurityfast.handle.MyAuthenticationFailHandler;
import com.lqs.springsecurityfast.handle.MyAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author : 李奇凇
 * @date : 2022/5/23 下午4:37
 * @do : SpringSecurity配置类
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    // 加密对象，用来对数据进行加密，在我们项目中用于对密码的加密
    public PasswordEncoder passwrodEncoder(){
        return new BCryptPasswordEncoder();
    }

    // 重写的方法
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin() // 自定义表单登录
                .usernameParameter("username") // 自定义前端帐号变量名
                .passwordParameter("password") // 自定义前端密码变量名
                .loginProcessingUrl("/st/login") // 当发现/st/login时候认定为登录，必须和表单提交的地址一样，去执行我们的自定义登录逻辑方法,这个/st/login里可以什么也不设置，因为不会走这个逻辑
                .loginPage("/login.html") // 修改默认的登录页面
                /**
                 * 在跳转的时候，失败跳转的时候，需要注意，如果是转发或者重定向到本地的地址，那么就需要放行
                 */
                 .failureForwardUrl("/st/loginFail") // 登录失败跳转页面
                 // .failureHandler(new MyAuthenticationFailHandler("/st/loginFail")) // 登录成功以后跳转页面和上面的不能同时存在，这个是前后分离的时候用，一体项目也可以用
                 .successForwardUrl("/st/loginSuccess"); // 登录成功跳转页面
                 // .successHandler(new MyAuthenticationSuccessHandler("https://www.baidu.com")); // 登录成功跳转页面，和上面的不能同时存在,这个是前后分离的时候用，一体项目也可以用

        http.authorizeRequests() // 授权认证
                /**
                 * antMatchers匹配规则：
                 *  1、antMatchers的参数可以有多个，用逗号隔开，每个参数都是一个ant表达式,antMatchers也可以配置多个
                 *  2、ant表达式：？表示匹配一个字符    *表示匹配0个或任意多个字符   **表示匹配0个或者任意多个目录，用于放行某个目录中的所有文件
                 */
                 .antMatchers("/js/**", "/css/**", "/plugins/**", "/images/**").permitAll() // 放行static下面的所有静态文件
                // .antMatchers(HttpMethod.GET,"/js/**/*.js", "/css/**/*.css").permitAll() // 放行static下面所有的js文件和css文件,请求方式是Get的
                // .antMatchers(HttpMethod.GET, "/**/*.png").permitAll() // 只要后缀名是png,且请求方式是GET的全部放行，请求方式不同也不会放行
                 .antMatchers("/login.html", "/st/loginFail", "/change.css").permitAll() // 匹配url,不需要认证的url，放行页面地址`


                /**
                 * regexMatchers使用正则的方式来匹配，[.]表示的就是.是转意的
                 */
                // .regexMatchers(HttpMethod.GET, ".*[.]png").permitAll() // 放行所有Get请求的并且后缀名是png的文件
                // .regexMatchers("/js/.*", "/css/.*").permitAll() // 放行css和js下的所有资源


                /**
                 * mvcMatchers是用于配置了servletPath之后使用,servletPath配置的就是这个项目的前缀,不常用
                 *  如：spring.mvc.servlet.path=/lqs  就表示访问资源就是localhost:8080/lqs/xxxxx,如果没有配置这个path，那么就是原本的localhost:8080/xxxx
                 *  配置了servletPath之后，所有的路径都要变
                 */
                // .mvcMatchers("/login.html").servletPath("/lqs").permitAll() // 放行，配置了servletPath的情况下


                /**
                 * hasAnyAuthority是严格区分大小写的,这里表示这个url地址是只有这个或者这些权限的用户才能访问，他的参数也可以有多个，用逗号分开,如果没有权限就会403 Forbidden
                 * hasAuthority是严格区分大小写的,这里表示这个url地址是只有这个权限的用户才能访问，他的参数只能有一个，如果没有权限就会403 Forbidden
                 */
                // .antMatchers("/test.html").hasAnyAuthority("admin", "normal")
                // .antMatchers("/test.html").hasAuthority("admin")


                /**
                 * hasAnyRole是严格区分大小写的,这里表示这个url地址是只有这个或者这些角色的用户才能访问，他的参数也可以有多个，用逗号分开,如果没有权限就会403 Forbidden
                 * hasRole是严格区分大小写的,这里表示这个url地址是只有这个角色的用户才能访问，他的参数只能有一个,如果没有权限就会403 Forbidden
                 * 这里的角色不能是ROLE_xxx这种，因为框架会自动将ROLE_替换，如果这样写，会直接报错
                 */
                // .antMatchers("/test.html").hasAnyRole("DD","abc")
                // .antMatchers("/test.html").hasRole("DD")

                /**
                 * hasIpAddress是表示指定url要符合这个指定的ip才能访问
                 */
                // .antMatchers("/test.html").hasIpAddress("127.0.0.1")

                .anyRequest().authenticated(); // 剩下的所有的请求url都需要认证才能访问


        http.csrf() // csrf防护
                .disable(); // 关闭
    }
}
