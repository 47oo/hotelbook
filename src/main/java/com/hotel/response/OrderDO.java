package com.hotel.response;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Created by hp on 2017/5/7.
 */
@Data
public class OrderDO {

    private String order_id;
    private String citime;
    private String cotime;
    private int room_id;
    private double money;
}
