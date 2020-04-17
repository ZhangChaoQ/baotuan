package com.lila.baotuan.controller;

import com.lila.baotuan.entity.GLpayApi;
import com.lila.baotuan.entity.Result;
import com.lila.baotuan.utils.PayUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/qpay")
public class PayController {
    private static Logger logger = LogManager.getLogger();
    @Value("${payUrl}")
    private String payUrl = "http://pay.wsdy.com.cn";

    @RequestMapping("/pay")
    @ResponseBody
    public Map<String, Object> pay(HttpServletRequest request) throws IOException {
        String name = request.getParameter("name");
        String userId = request.getParameter("userId");
        int price = Integer.valueOf(request.getParameter("price"));
        Map<String, Object> remoteMap = new HashMap<String, Object>();
        String orderid = new SimpleDateFormat("YYYYMMddhhmmssSSS").format(new Date());
        remoteMap.put("price", price);
        remoteMap.put("istype", 1);
        remoteMap.put("orderid", orderid);
        remoteMap.put("orderuid", userId);
        remoteMap.put("goodsname", name);
        return new PayUtil().payOrder(remoteMap);
    }

    @RequestMapping("/notifyPay")
    @ResponseBody
    public String notifyPay(HttpServletRequest request, HttpServletResponse response, GLpayApi payAPI) {
        logger.info(payAPI.toString());
        // 保证密钥一致性
       /* if (PayUtil.checkPayKey(payAPI)) {
            return "OK";
        } else {
            return "fail";
        }*/
        return "OK";
    }

    @RequestMapping("/returnPay")
    public Result returnPay(HttpServletRequest request, HttpServletResponse response, String orderid) {
        logger.info(orderid);
        boolean isTrue = false;
        ModelAndView view = null;
        // 根据订单号查找相应的记录:根据结果跳转到不同的页面
        if (isTrue) {
            view = new ModelAndView("/正确的跳转地址");
        } else {
            view = new ModelAndView("/没有支付成功的地址");
        }
        return null;
    }

    public static boolean deleteHtml() {
        File file = new File("E:\\20200415084926466.html");
        if (file.exists() && file.isFile()) {
            return file.delete();
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(deleteHtml());
    }
}
