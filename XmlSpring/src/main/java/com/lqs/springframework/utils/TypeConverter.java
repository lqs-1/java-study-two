package com.lqs.springframework.utils;

/**
 * @author : 李奇凇
 * @date : 2022/5/22 下午9:57
 * @do : 类型转换
 */
public class TypeConverter {

    public static Integer String2Integer(Class classType, String value){
       if (Integer.class.isAssignableFrom(classType)){
            return Integer.parseInt(value);
        }
       return null;
    }
    private TypeConverter(){

    }


}
