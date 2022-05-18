package lqs;

import lqs.bean.User;
import lqs.config.AnnotationConfig;
import spring.context.AnnotationConfigContext;
import spring.context.BeanDefinition;

import java.beans.Introspector;
import java.util.Map;


/**
 * @author : 李奇凇
 * @date : 2022/5/6 14:25
 * @do :
 */

public class Start {


    public static void annotationContextText(AnnotationConfigContext anApp){

        User bean = anApp.getBean(User.class);

        User order = anApp.getBean(User.class, "user");

        System.out.println(bean);
        System.out.println(order);

    }


    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        AnnotationConfigContext anApp = new AnnotationConfigContext(AnnotationConfig.class);

        System.out.println("================================容器中的beanDefinition=====================================");

        Map<String, BeanDefinition> beanDefinition = anApp.getBeanDefinition();

        System.out.println("beanDefinition一共: " + beanDefinition.size() + "个");

        for (String beanName : beanDefinition.keySet()) {

            System.out.println(beanDefinition.get(beanName).getObjectType());

        }

        System.out.println("================================容器中的beanDefinition=====================================");

        System.out.println();

        System.out.println();

        System.out.println();

        System.out.println("=========================================测试=============================================");

        Start.annotationContextText(anApp);

        System.out.println("=========================================测试=============================================");

    }
}
