package com.lila.baotuan.controller;

import com.lila.baotuan.entity.GLpayApi;
import com.lila.baotuan.entity.Member;
import com.lila.baotuan.entity.ViewUser;
import com.lila.baotuan.service.impl.*;
import com.lila.baotuan.utils.PayUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
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
    @Resource
    private BrokerageServiceImpl brokerageService;
    @Resource
    private ViewUserServiceImpl viewUserService;
    @Resource
    private UserServiceImpl userService;
    @Resource
    private MemberServiceImpl memberService;
    @Resource
    private SysWithdrawalsServiceImpl sysWithdrawalsService;

    @RequestMapping("/pay")
    @ResponseBody
    public Map<String, Object> pay(HttpServletRequest request) throws IOException {
        String name = request.getParameter("name");
        String userId = request.getParameter("userId");
        DecimalFormat df = new DecimalFormat("#.00");
        String price = df.format(Integer.valueOf(request.getParameter("price")));
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
        if (PayUtil.checkPayKey(payAPI)) {
            String price = payAPI.getPrice().substring(0, payAPI.getPrice().indexOf("."));
            logger.info(price);
            price = "599";
            int userId = Integer.valueOf(payAPI.getOrderuid());
            Member member = memberService.getMemberIdByPrice(Integer.valueOf(price));
            /*修改会员等级*/
            userService.updateMember(userId, member.getId());
            /*上级获取分佣*/
            ViewUser viewUser = viewUserService.getViewUserById(userId);
            if (-1 != viewUser.getUserId()) {
                userService.updateMoney(viewUser.getUserId(), viewUser.getInviterMemberMoney() * 0.2);
                brokerageService.insertInvite(viewUser.getId(), viewUser.getInviterMemberMoney() * 0.2);
                ViewUser inviter = viewUserService.getViewUserById(viewUser.getUserId());
                if (-1 != inviter.getUserId()) {
                    userService.updateMoney(inviter.getUserId(), inviter.getInviterMemberMoney() * 0.05);
                    brokerageService.insertInvite(viewUser.getId(), inviter.getInviterMemberMoney() * 0.05);
                }
            }
            /*添加进账*/
           sysWithdrawalsService.insertSysWithdrawals(Integer.valueOf(payAPI.getOrderuid()), Integer.valueOf(price), false);
            return "OK";
        } else {
            return "fail";
        }
    }

    @RequestMapping("/returnPay")
    public String returnPay(HttpServletRequest request, HttpServletResponse response, String orderid) {
        return "BaoTuanAppTest/member";
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
