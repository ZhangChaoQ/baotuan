package com.lila.baotuan.tools;

import org.springframework.util.DigestUtils;

public class MD5Util {
    public static String getMD5(String str) {
        String md5Password = DigestUtils.md5DigestAsHex(str.getBytes());
        return md5Password;
    }
}
