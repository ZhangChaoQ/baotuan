package com.lila.baotuan.config;

import java.net.HttpURLConnection;
import java.net.URL;

public class TestUrl {

    private static URL url;
    private static HttpURLConnection con;
    private static int state = -1;

    /**
     * 功能：检测当前URL是否可连接或是否有效,
     * 描述：链接url地址，链接失败则返回null
     *
     * @param urlStr 指定URL网络地址
     * @return URL
     */
    public synchronized static String isConnect(String urlStr) {

        if (urlStr == null || urlStr.length() <= 0) {
            return null;
        }

        try {
            url = new URL(urlStr);
            con = (HttpURLConnection) url.openConnection();
            state = con.getResponseCode();
            System.out.println("状态= "+state);
            if (state == 200) {
                System.out.println("URL可用！");
            }
        } catch (Exception ex) {
            urlStr = null;
        }
        //释放资源
        con.disconnect();
        return urlStr;
    }


    public static void main(String[] args) {

        int state = 0;

        String strURL[] = {"https://www.iesdouyin.com/share/video/6804423366250974479?mid=6800378415058193166"};
        int errorURL[] = new int[strURL.length];

        //访问所有的url地址
        for (int i = 0; i < strURL.length; i++) {

            String url = isConnect(strURL[i]);
//            System.out.println("url的状态="+url);
            //如果访问失败就记录下来
            if (url == null) {
                System.out.println("第" + (i + 1) + "个" + strURL[i] + "url地址不可以访问");
                errorURL[state] = i;
                state++;
            } else {
                System.out.println("第" + (i + 1) + "个" + strURL[i] + "url地址可以访问");
            }
        }
    }


}