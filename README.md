### SpringCloudTencent学习
##### [SpringCloudTencent项目地址](https://github.com/Tencent/spring-cloud-tencent)
##### [Polaris北极星服务注册项目地址](https://github.com/PolarisMesh)

##### [Polaris官网](https://polarismesh.cn)

### SpringCloudTencent项目搭建
> 第一步创建父工程，用于管理下面所有的微服务,普通maven工程就可以了
```java
<!--父工程打包pom-->
    <packaging>pom</packaging>

<!--    模块集中管理-->
    <modules>
        <module>Googs</module>
        <module>Common</module>
    </modules>
```
> 第二步创建共用工程common,普通maven工程，放工具包和共用坐标
```java
    <properties>
        <java.version>1.8</java.version>
        <!--        springcloudtencent的版本-->
        <spring-cloud-tencent.version>1.5.3-Hoxton.SR9</spring-cloud-tencent.version>
    </properties>

    <dependencies>
        
        <!--        服务注册发现-->
        <dependency>
            <groupId>com.tencent.cloud</groupId>
            <artifactId>spring-cloud-starter-tencent-polaris-discovery</artifactId>
        </dependency>

        <!--        解决polaris报错问题-->
        <dependency>
            <groupId>com.google.guava</groupId>
            <artifactId>guava</artifactId>
            <version>31.0.1-jre</version>
        </dependency>

        <!--        解决polaris报错问题-->
        <dependency>
            <groupId>org.apache.httpcomponents</groupId>
            <artifactId>httpcore</artifactId>
            <version>4.4.8</version>
        </dependency>

    </dependencies>

    <dependencyManagement>
        <dependencies>
            <!--            springcloudtencent依赖-->
            <dependency>
                <groupId>com.tencent.cloud</groupId>
                <artifactId>spring-cloud-tencent-dependencies</artifactId>
                <version>${spring-cloud-tencent.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
```
> 第三步创建各个为服务工程，springboot项目并且依赖共用工程，并做服务注册配置
```java
    <!--请注意这里有个坑，springboot，spring还有springcloud和springcloudtencent依赖的版本号要有所对应，可以去u官网查看-->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.3.2.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <properties>
        <java.version>1.8</java.version>
        <!--        springcloud的版本-->
        <spring-cloud.version>Hoxton.SR9</spring-cloud.version>
    </properties>
        
        
    <dependencies>

        <!--        springboot_test-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    
        <!--        springbootweb-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    
        <!--        服务之间的调用服务-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>
    
    
        <dependency>
            <groupId>com.lqs</groupId>
            <artifactId>Common</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>
    </dependencies>

    <dependencyManagement>
        <dependencies>
            <!--        springcloud依赖-->
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>


```
```java
spring:
  application:
    # 服务名称
    name: googs
  cloud:
    polaris:
      # polaris地址
      address: grpc://localhost:8091
      # 命名空间选择
      namespace: default
```


> 第四步网关工程搭建，注意网关也要将自己注册到polaris上面，并且配置好跨域，springboot项目
```java
    <!--请注意这里有个坑，springboot，spring还有springcloud和springcloudtencent依赖的版本号要有所对应，可以去u官网查看-->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.3.2.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <properties>
        <java.version>1.8</java.version>
        <!--        springcloud的版本-->
        <spring-cloud.version>Hoxton.SR9</spring-cloud.version>
    </properties>
        
        
    <dependencies>

        <!--        springboot_test-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    
        <!--        springbootweb-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!--        网关-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-gateway</artifactId>
        </dependency>
    
    
        <dependency>
            <groupId>com.lqs</groupId>
            <artifactId>Common</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>
    </dependencies>

    <dependencyManagement>
        <dependencies>
            <!--        springcloud依赖-->
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

```
```java
spring:
  application:
    # 服务名称
    name: gateway
  cloud:
    polaris:
      # polaris地址
      address: grpc://localhost:8091
      # 命名空间选择
      namespace: default
    # 网关
    gateway:
      routes:
        # goods
        - id: goods_router
          uri: lb://googs
          predicates:
            - Path=/goods/**
          filters:
              - RewritePath=(?<segment>/?.*),/$\{segment}


        # user
        - id: goods_router
          uri: lb://user
          predicates:
            - Path=/user/**
          filters:
              - RewritePath=(?<segment>/?.*),/$\{segment}

# 对于请求路径 /red/blue，当前的配置在请求到到达前会被重写为 /blue，由于YAML的语法问题，$符号后面应该加上\

# 在解释正则表达式前，我们需要学习一下java正则表达式分组的两个概念：
# 命名分组：(?<name>capturing text)
# 将匹配的子字符串捕获到一个组名称或编号名称中，在获得匹配结果时，可通过分组名进行获取。例如这里的示例，就是将 “capturing text” 捕获到名称为 “name” 的组中
# 引用捕获文本：${name}
# 将名称为name的命名分组所匹配到的文本内容替换到此处
# RewritePath=(?<segment>/?.*),/$\{segment}就是表示将匹配到的路径按照"/?.*"正则表达式提取出来，并且把提取出来的东西去个名字"segment","$\{segment}"就是使用提取出来的东西
```

```java
package com.lqs.getaway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * @author 李奇凇
 * @date 2022年07月02日 下午3:02
 * @do 请用一句话描述该类功能
 */
@Configuration  
public class CorsConfig { 
    /**
     * webflux中的reactive的拦截器
     * @return
     */

    @Bean
    public CorsWebFilter corsWebFilter() {
    
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    
        final CorsConfiguration config = new CorsConfiguration();
    
        config.setAllowCredentials(true); // 允许cookies跨域
    
        config.addAllowedOrigin("*");// #允许向该服务器提交请求的URI，*表示全部允许，在SpringMVC中，如果设成*，会自动转成当前请求头中的Origin
    
        config.addAllowedHeader("*");// #允许访问的头信息,*表示全部
    
        config.setMaxAge(18000L);// 预检请求的缓存时间（秒），即在这个时间段里，对于相同的跨域请求不会再预检了
    
        config.addAllowedMethod("*");// 允许提交请求的方法，*表示全部允许
    
        source.registerCorsConfiguration("/**", config);
    
        return new CorsWebFilter(source);
    
    }
}

```
### openfeign使用
> 环境两个微服务，googs和user，调用user/origin的时候，实际调用的就是goods/local
> 两个概念：1、发起调用的工程和被调用的工程

#### 发起调用的工程
> 开启远程调用功能@EnableFeignClients
> 编写调用服务接口
```java
package com.lqs.user.feign;

import com.lqs.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 李奇凇
 * @date 2022年07月02日 下午3:12
 * @do 向goods发起远程调用的服务
 */

// 写清楚被调用的微服务的名字
@FeignClient("googs")
public interface GoodsFeignServer {

    // 这个接口中所有的方法都和googs中对应的方法同名，请求方法和请求路径也是一样的，在使用的时候就和调用service一模一样
    @GetMapping ("/goods/local")
    R local();


    // 如果被调用的其他微服务有参数，那么照抄
    @PostMapping("/goods/plusLoacl")
    public R plusLocal(@RequestBody RequestTo requestTo);
}
```
> 使用
```java
    @Autowired
    private GoodsFeignServer goodsFeignServer;

    @GetMapping("origin")
    public R origin(){
            return goodsFeignServer.local();
            }
    
    @PostMapping("plusOrigin")
    public R plusOrigin(){
            RequestTo requestTo = new RequestTo();
            requestTo.setAge(12L);
            requestTo.setName("lqs");
            return goodsFeignServer.plusLocal(requestTo);
            }
```

#### 被调用的工程啥都不用干等着被调用就行了

