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
        <!--        springcloud的版本-->
        <spring-cloud.version>Hoxton.SR9</spring-cloud.version>
        <!--        springcloudtencent的版本-->
        <spring-cloud-tencent.version>1.5.3-Hoxton.SR9</spring-cloud-tencent.version>
    </properties>

    <dependencies>
        <!--        服务之间的调用服务-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>

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
            <!--        springcloud依赖-->
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
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

    <dependencies>
        <dependency>
            <groupId>com.lqs</groupId>
            <artifactId>Common</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>
    </dependencies>
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