package com.hotel.request;

import lombok.Data;

/**
 * Created by hp on 2017/5/7.
 */
@Data
public class UserRequest {

    private String oldpwd;
    private String newpwd;
}
