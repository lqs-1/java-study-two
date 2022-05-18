package com.datetime.datetime.utils;

public enum EnumConstant {

    USERNAME(1000, "男的"),
    AGE(1001, "10岁");

    private int code;
    private String msg;

    EnumConstant(int code, String msg){
        this.code = code;
        this.msg = msg;
    }


    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


    public static void main(String[] args) {
        System.out.println(EnumConstant.USERNAME.getCode());
        System.out.println(EnumConstant.AGE.getCode());
    }
}
