package com.hotel.common;

import com.hotel.request.Request;

import java.util.Date;

/**
 * Created by hp on 2017/5/7.
 */
public class CommonUtils {

    public static String randomOrderId(String idcard){

        return idcard+time();
    }
    private static long time(){
        return System.currentTimeMillis();
    }

    public static int start(Request request){

        return (request.getStart()-1)*request.getSize();
    }
}
