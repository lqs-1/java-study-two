package spring.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : 李奇凇
 * @date : 2022/5/6 16:36
 * @do :
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)

public @interface Autowired {

}
