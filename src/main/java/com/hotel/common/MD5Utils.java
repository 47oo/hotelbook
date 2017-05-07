package com.hotel.common;


import com.hotel.exception.NoMD5Exception;
import lombok.extern.log4j.Log4j;
import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Log4j
public class MD5Utils {

    public static String passwordToMD5(String password){
        MessageDigest mdInst = null;
        try {
            mdInst = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            log.debug("no MD5");
        }
        if(mdInst==null){
            throw new NoMD5Exception();
        }
        return new String(Hex.encodeHex(mdInst.digest(password.getBytes())));
    }
}
