package spring.context;

/**
 * @author : 李奇凇
 * @date : 2022/5/6 21:22
 * @do :
 */
public interface BeanPostProcessor {

    public Object postProcessBeforeInitialization(String beanName, Object bean);
    public Object postProcessAfterInitialization(String beanName, Object bean);




}
