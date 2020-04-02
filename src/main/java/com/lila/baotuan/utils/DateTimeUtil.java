package com.lila.baotuan.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {

    public static String getNowDayBefore(){
        String Date=new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(new Date());
        return Date;
    }
    public static String getNowDayEnd(){
        String Date=new SimpleDateFormat("yyyy-MM-dd 23:59:59").format(new Date());
        return Date;
    }

    public static void main(String[] args) {
        System.out.println(getNowDayBefore());
        System.out.println(getNowDayEnd());
    }
}
