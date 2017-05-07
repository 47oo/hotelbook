package com.hotel.common;

import java.util.Date;

/**
 * Created by hp on 2017/5/7.
 */
public class CommonUtils {

    public static String randomOrderId(String idcard){

        return idcard+time();
    }
    private static long time(){
        return new Date().getTime();
    }
}
