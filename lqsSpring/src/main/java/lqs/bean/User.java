package lqs.bean;

import spring.annotation.Autowired;
import spring.annotation.Component;
import spring.annotation.Scope;
import spring.context.BeanNameAware;
import spring.context.InitializingBean;

/**
 * @author : 李奇凇
 * @date : 2022/5/6 14:24
 * @do :
 */


@Component
@Scope(value = "singleton")
public class User implements BeanNameAware, InitializingBean, UserProxy {
    private String username = "Liqisong";
    private Long age = 20L;

    private String beanName;

    private String xxx;

    public String getBeanName() {
        return beanName;
    }

    @Autowired
    private Class aClass;

    public Class getaClass() {
        return aClass;
    }


    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    @Override
    public void afterPropertiesSet() {
        // 初始化方法
        this.xxx = "liqisong";
    }

    public String getXxx() {
        return xxx;
    }

    @Override
    public void test() {
        System.out.println("现在打印的是被代理方法");
    }

    @Override
    public void test1() {
        System.out.println("第二个被代理的方法");
    }
}
