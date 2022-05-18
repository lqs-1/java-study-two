package com.example.mybatispluspage.utils;



import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class R extends HashMap<String, Object> {

    /**
     * 向map中添加参数，成功和失败都可以用,前提是实例了R
     * @param key
     * @param msg
     * @return
     */
    public R put(String key, Object msg) {
        super.put(key, msg);
        return this;
    }


    /**
     * 构造方法，初始化一些值，这个再成功的时候调用
     */
    public R() {
        put("code", 0);
        put("msg", "success");
    }

    /**
     * 成功的方法，成功了就调用构造方法
     * @return
     */
    public static R ok() {
        return new R();
    }

    /**
     * 成功的方法，成功了就调用构造方法
     * @return
     */
    public static R ok(String msg){
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    /**
     * 成功的方法，成功了就调用构造方法,返回的是接受map
     * @return
     */
    public static R ok(Map<String, Object> param){
        R r = new R();
        r.putAll(param);
        return r;
    }


    /**
     * 失败的方法
     * @return
     */
    public static R error(int code, String msg){
        R r = new R();
        // 重写R里面的状态码和回显消息
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R error(){
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "服务器异常");
    }
    public static R error(String msg){
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }



}
