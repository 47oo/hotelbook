package com.hotel.common.constant;

public interface Constant {
    interface User {
        int WRONG_CODE = 0;
        int RIGHT_CODE = 1;
    }

    interface Room {
        int WRONG_CODE = 0;
        int RIGHT_CODE = 1;
        int BIG_ROOM = 3;
        int MID_ROOM = 2;
        int SMALL_ROOM = 1;
        int BOOKING = 0; //预定
        int UNBOOK = -1; //未预定
        int BOOKED = 1;// 入住
    }
    interface Admin{
        int WRONG_CODE = 0;
        int RIGHT_CODE = 1;
    }
}
