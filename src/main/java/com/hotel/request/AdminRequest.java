package com.hotel.request;

import lombok.Data;

/**
 * Created by hp on 2017/5/8.
 */
@Data
public class AdminRequest {
    private String oldpwd;
    private String newpwd;
}
