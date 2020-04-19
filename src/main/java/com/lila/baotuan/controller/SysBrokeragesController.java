package com.lila.baotuan.controller;


import com.lila.baotuan.entity.Result;
import com.lila.baotuan.entity.SysBrokerages;
import com.lila.baotuan.service.impl.BrokerageServiceImpl;
import com.lila.baotuan.service.impl.SysBrokeragesServiceImpl;
import com.lila.baotuan.service.impl.SysWithdrawalsServiceImpl;
import com.lila.baotuan.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 金额记录 前端控制器
 * </p>
 *
 * @author Zhang
 * @since 2020-04-20
 */
@Controller
@RequestMapping("/baotuan/sysBrokerages")
public class SysBrokeragesController {

    @Resource
    private SysBrokeragesServiceImpl sysBrokeragesService;
    @Resource
    private BrokerageServiceImpl brokerageService;
    @Resource
    private UserServiceImpl userService;
    @Resource
    private SysWithdrawalsServiceImpl sysWithdrawalsService;

    @RequestMapping("/paid")
    @ResponseBody
    public Result paied(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id"));
        Result result = new Result();
        SysBrokerages sysBrokerages = sysBrokeragesService.paidById(id);
        int brokerageId = sysBrokerages.getBrokerageId();
        sysWithdrawalsService.insertSysWithdrawals(sysBrokerages.getUserId(), sysBrokerages.getPayMoney(), true);
        int count = brokerageService.paidById(brokerageId);
        result.setCode(true);
        result.setMsg("支付已成功");
        result.setData(count);
        return result;
    }

    @RequestMapping("/failed")
    @ResponseBody
    public Result failed(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id"));
        Result result = new Result();
        SysBrokerages sysBrokerages = sysBrokeragesService.failedById(id);
        userService.updateMoney(sysBrokerages.getUserId(), sysBrokerages.getMoney());
        int brokerageId = sysBrokerages.getBrokerageId();
        int count = brokerageService.failedById(brokerageId);
        result.setCode(true);
        result.setMsg("申请已驳回");
        result.setData(count);
        return result;
    }
}

