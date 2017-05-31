package com.hotel.path;

import org.junit.Test;

/**
 * Created by hp on 2017/5/31.
 */
public class PathTest {

    @Test
    public void test(){
        String path = System.getProperty("user.dir");
        System.out.print(path);
    }
}
