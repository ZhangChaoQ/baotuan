package com.lila.baotuan.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = "classpath:smsConfig.properties")
public class Sendsms {
    // 短信应用 SDK AppID
    @Value("${appid}")
    int appid; // SDK AppID 以1400开头
    // 短信应用 SDK AppKey
    @Value("${appkey}")
    String appkey;
    // 签名
    @Value("${smsSign}")
    String smsSign; // NOTE: 签名参数使用的是`签名内容`，而不是`签名ID`。这里的签名"腾讯云"只是示例，真实的签名需要在短信控制台申请
    // 短信模板 ID，需要在短信应用中申请
    @Value("${templateId}")
    int templateId; // NOTE: 这里的模板 ID`7839`只是示例，真实的模板 ID 需要在短信控制台中申请

    public String sendsms(String phoneNumber) {
        /*try {
            String[] params = {"5678"};
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumber, templateId, params, smsSign, "", "");
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (HTTPException e) {
            e.printStackTrace();
        }*/
        return appid+appkey+smsSign+templateId;
    }

    public static void main(String[] args) {
        System.out.println(new Sendsms().sendsms("18501350323"));
    }

}
