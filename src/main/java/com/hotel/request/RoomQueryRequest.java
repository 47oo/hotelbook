package com.hotel.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by hp on 2017/5/7.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RoomQueryRequest extends Request {
    private int room_id;
    private String citime;
    private String cotime;
}
