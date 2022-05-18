package com.example.mybatispluspage.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// springboot方式，mybatis分页插件
@EnableTransactionManagement  // 开启平台事物管理
@Configuration
@MapperScan("com.example.mybatispluspage.mapper")
public class PageIntercepter {
    @Bean
    // 引入分页拦截器，可以理解为分页插件，有了这个才可以分页查询
    public PaginationInterceptor paginationInnerInterceptor(){
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置请求的页面最大页后的操作，true调回首页，默认false，false为继续请求
        paginationInterceptor.setOverflow(true);
        // 设置最大单页限制数量，默认是500， -1为不限制
        paginationInterceptor.setLimit(1000L);
        return paginationInterceptor;
    }
}
