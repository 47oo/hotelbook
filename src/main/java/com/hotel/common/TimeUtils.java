package com.hotel.common;

import lombok.extern.log4j.Log4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hp on 2017/5/7.
 */
@Log4j
public class TimeUtils {

    private static final long ONE_DAY = 24 * 60 * 60 * 1000;
    //获得当前时间
    public static long now() {
        return System.currentTimeMillis();
    }
    //timestamp to date

    public static String format(long time, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(time));
    }

    public static Long getTimeStamp(String time, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            Date date = sdf.parse(time.trim());
            return date.getTime();
        } catch (ParseException e) {
           log.debug("时间格式错误: "+time,e);
        }
        return null;
    }

    public static int days(long begin,long end){

        return (end-begin)/ONE_DAY ==0?1: (int)Math.ceil ((end - begin) / ONE_DAY);
    }
}
