package com.lqs.springframework.utils;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午9:01
 * @do : 字符串处理工具类
 */
public class StringUtils {

    private StringUtils(){

    }

    // userDao ===> setUserDao
    public static String getSetterMethodByFieldName(String fieldName){
        String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
        return methodName;
    }

}
