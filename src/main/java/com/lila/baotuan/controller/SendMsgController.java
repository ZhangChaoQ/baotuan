package com.lila.baotuan.controller;

import com.alibaba.fastjson.JSONObject;
import com.lila.baotuan.entity.Result;
import com.lila.baotuan.utils.SendSmsUtil;
import com.lila.baotuan.utils.ServiceUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@RequestMapping("/baotuan/sendMsg")
public class SendMsgController {

    @Value("${accName}")
    private String accName;
    @Value("${accPwd}")
    private String accPwd;
    @Value("${time}")
    private String time;
    @Value("${userPhone}")
    private String userPhone;

    @RequestMapping("/sendmsg")
    @ResponseBody
    public Result sendMassage(HttpServletRequest request) {
        String phone = request.getParameter("phone");
        Result result = new Result();
        String code = SendSmsUtil.getCode();
        String context = "您好，您的验证码是" + code + "，" + time + "分钟内有效。 【爆团科技】";
        String re = SendSmsUtil.sendSms(accName, accPwd, phone, context);
        System.out.println(re);
        String[] b = re.split(";");
        int surplus = Integer.valueOf(b[re.split(";").length - 1]);
        if (surplus < 7) SendSmsUtil.sendSms(accName, accPwd, userPhone, "余额不足，请及时充值");
        int c = Integer.valueOf(b[0]);
        if (c == 1) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("code", code);
            map.put("time", Integer.valueOf(time));
            result.setCode(true);
            result.setData(map);
            result.setMsg("短信发送成功");
        } else {
            result.setCode(false);
            result.setData(null);
            result.setMsg("短信发送失败");
        }
        return result;
    }
}
