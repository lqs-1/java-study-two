package com.datetime.datetime.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtils {


    public static String formatDateTime(Date date){
        return formatDateTime(date, "yy-MM-dd:HH:mm:ss");
    }


    public static String formatDateTime(Date date, String dateFormat){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        String realDate = simpleDateFormat.format(date);
        return realDate;
    }
}
