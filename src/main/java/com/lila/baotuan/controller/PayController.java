package com.lila.baotuan.controller;

import com.alibaba.fastjson.JSONObject;
import com.lila.baotuan.entity.GLpayApi;
import com.lila.baotuan.entity.Result;
import com.lila.baotuan.utils.HTTPUtil;
import com.lila.baotuan.utils.HtmlUtil;
import com.lila.baotuan.utils.PayUtil;
import com.lila.baotuan.utils.ServiceUtil;
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
    private String payUrl="http://pay.wsdy.com.cn";

    @RequestMapping("/pay")
    @ResponseBody
    public String pay(HttpServletRequest request) throws IOException {
        JSONObject jData = ServiceUtil.getJsonData(request);
        String name = jData.getString("name");
        String userId = jData.getString("userId");
        String price = jData.getString("price");
        Map<String, Object> remoteMap = new HashMap<String, Object>();
        String orderid=new SimpleDateFormat("YYYYMMddhhmmssSSS").format(new Date());
        remoteMap.put("price", price);
        remoteMap.put("istype", 1 + "");
        remoteMap.put("orderid", orderid);
        remoteMap.put("orderuid", userId);
        remoteMap.put("goodsname", name);
        String html = HTTPUtil.post(payUrl, new PayUtil().payOrder(remoteMap));
        logger.info(html);
       html.replace("charset=","charset=UTF-8");
        logger.info(html);
        String htmlName = HtmlUtil.write(html,orderid);
        return htmlName;
    }

    @RequestMapping("/notifyPay")
    @ResponseBody
    public String notifyPay(HttpServletRequest request, HttpServletResponse response, GLpayApi payAPI) {
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
