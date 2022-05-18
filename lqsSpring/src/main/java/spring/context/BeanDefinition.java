package spring.context;

/**
 * @author : 李奇凇
 * @date : 2022/5/6 15:24
 * @do :
 */

public class BeanDefinition {

    private Class<?> objectType;

    private String scope;


    public Class<?> getObjectType() {
        return objectType;
    }

    public void setObjectType(Class<?> objectType) {
        this.objectType = objectType;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
