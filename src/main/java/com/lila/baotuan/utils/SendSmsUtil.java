package com.lila.baotuan.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


public class SendSmsUtil {
    private static final String accName = "13070186672";
    private static final String accPwd = "guozi123";
    private static final String host = "http://sdk.lx198.com/sdk/send?";

    public static void main(String[] args) {
        String code = getCode();
        int time = 1;
        String phone = "18501350323";
        String context = "您好，您的验证码是" + code + "，" + time + "分钟内有效。 【爆团科技】";
        int msgId = 1;
        String result = new SendSmsUtil().sendSms(accName, MD5Util.getMd5String(accPwd).toUpperCase(), phone, context);
        System.out.println(result);

    }

    public static String getCode() {
        String code = "";
        //, 'a', 'A', 'b', 'B', 'c', 'C', 'd', 'D', 'e', 'E', 'f', 'F', 'g', 'G', 'h', 'H', 'i', 'I', 'j', 'J', 'k', 'K', 'l', 'L', 'm', 'M', 'n', 'N', 'o', 'O', 'p', 'P', 'q', 'Q', 'r', 'R', 's', 'S', 't', 'T', 'u', 'U', 'v', 'V', 'w', 'W', 'x', 'X', 'y', 'Y', 'z', 'Z'
        char[] arr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int i = 1;
        while (i++ <= 6) { //循环六次，得到六位数的验证码
            char msg = arr[(int) (Math.random() * 10)];
            code += msg;
        }
        return code;
    }

    public static String sendSms(String accName, String accPwd, String phone, String content) {
        StringBuffer sb = new StringBuffer(host);
        try {
            sb.append("&accName=" + accName);
            sb.append("&accPwd=" + MD5Util.getMd5String(accPwd).toUpperCase());
            sb.append("&aimcodes=" + phone);
            sb.append("&content=" + URLEncoder.encode(content, "UTF-8"));
            sb.append("&dataType=josn");
            URL url = new URL(sb.toString());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            return in.readLine();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
