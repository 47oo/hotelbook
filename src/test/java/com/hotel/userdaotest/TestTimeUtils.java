package com.hotel.userdaotest;

import com.hotel.common.TimeUtils;
import org.junit.Test;

/**
 * Created by hp on 2017/5/7.
 */
public class TestTimeUtils {
    @Test
    public void test() {
        int days = TimeUtils.days(TimeUtils.getTimeStamp("2016-12-12", "yyyy-MM-dd"), TimeUtils.getTimeStamp("2016-12-13", "yyyy-MM-dd"));
        System.out.print(days);
    }
}
