package com.lila.baotuan.utils;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ServiceUtil {
    public static JSONObject getJsonData(HttpServletRequest request) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String s = null;
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
            JSONObject jsonObject = JSONObject.parseObject(sb.toString());
            return jsonObject;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
