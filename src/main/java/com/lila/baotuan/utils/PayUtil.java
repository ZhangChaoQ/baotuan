package com.lila.baotuan.utils;

import com.alibaba.fastjson.JSON;
import com.lila.baotuan.entity.GLpayApi;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class PayUtil {

    private static Logger logger = LogManager.getLogger();
    @Value("${UID}")
    private String UID = "16582";
    @Value("${NOTIFY_URL}")
    private String NOTIFY_URL = "http://119.8.37.167:8088/qpay/notifyPay";
    @Value("${RETURN_URL}")
    private String RETURN_URL = "http://119.8.37.167:8088/qpay/returnPay";
    @Value("${TOKEN}")
    private String TOKEN = "VZVaycFa1cuVvukwga3uqY3UGfT1pVMG";

    public Map<String, Object> payOrder(Map<String, Object> remoteMap) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("uid", UID);
        paramMap.put("notify_url", NOTIFY_URL);
        paramMap.put("return_url", RETURN_URL);
        paramMap.putAll(remoteMap);
        paramMap.put("key", getKey(paramMap));
        System.out.println(paramMap);
        logger.info(JSON.toJSON(paramMap));
        return paramMap;
    }

    public String getKey(Map<String, Object> remoteMap) {
        String key = "";
        if (null != remoteMap.get("goodsname")) {
            key += remoteMap.get("goodsname");
        }
        if (null != remoteMap.get("istype")) {
            key += remoteMap.get("istype");
        }
        if (null != remoteMap.get("notify_url")) {
            key += remoteMap.get("notify_url");
        }
        if (null != remoteMap.get("orderid")) {
            key += remoteMap.get("orderid");
        }
        if (null != remoteMap.get("orderuid")) {
            key += remoteMap.get("orderuid");
        }
        if (null != remoteMap.get("price")) {
            key += checkPrice(remoteMap.get("price").toString());
        }
        if (null != remoteMap.get("return_url")) {
            key += remoteMap.get("return_url");
        }
        key += TOKEN;
        if (null != remoteMap.get("uid")) {
            key += remoteMap.get("uid");
        }
        return MD5Util.encryption(key);
    }

    public boolean checkPayKey(GLpayApi payAPI) {
        String key = "";
        if (!StringUtils.isBlank(payAPI.getOrderid())) {
            logger.info("支付回来的订单号：" + payAPI.getOrderid());
            key += payAPI.getOrderid();
        }
        if (!StringUtils.isBlank(payAPI.getOrderuid())) {
            logger.info("支付回来的支付记录的ID：" + payAPI.getOrderuid());
            key += payAPI.getOrderuid();
        }
        if (!StringUtils.isBlank(payAPI.getTrade_no())) {
            logger.info("支付回来的平台订单号：" + payAPI.getTrade_no());
            key += payAPI.getTrade_no();
        }
        if (!StringUtils.isBlank(payAPI.getPrice())) {
            logger.info("支付回来的价格：" + payAPI.getPrice());
            key += checkPrice(payAPI.getPrice().toString());
        }
        if (!StringUtils.isBlank(payAPI.getRealprice())) {
            logger.info("支付回来的真实价格：" + payAPI.getRealprice());
            key += payAPI.getRealprice();
        }
        logger.info("支付回来的Key：" + payAPI.getKey());
        key += TOKEN;
        logger.info("我们自己拼接的Key：" + MD5Util.encryption(key));
        return payAPI.getKey().equals(MD5Util.encryption(key));
    }

    public String getOrderIdByUUId() {
        int machineId = 1;// 最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {// 有可能是负数
            hashCodeV = -hashCodeV;
        }
        // 0 代表前面补充0;d 代表参数为正数型
        return machineId + String.format("%01d", hashCodeV);
    }

    public String checkPrice(String price) {
        String fl = price.substring(price.indexOf(".") + 1);
        if (fl.length() == 1 && fl.equals("0"))
            return price.substring(0, price.indexOf("."));
        return price;
    }


}
