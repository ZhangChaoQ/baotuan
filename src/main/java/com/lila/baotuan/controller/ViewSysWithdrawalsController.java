package com.lila.baotuan.controller;


import com.lila.baotuan.entity.Result;
import com.lila.baotuan.service.impl.ViewSysWithdrawalsServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * VIEW 前端控制器
 * </p>
 *
 * @author Zhang
 * @since 2020-04-14
 */
@Controller
@RequestMapping("/baotuan/viewSysWithdrawals")
public class ViewSysWithdrawalsController {

    @Resource
    private ViewSysWithdrawalsServiceImpl viewSysWithdrawalsService;

    @RequestMapping("/getViewSysWithdrawalsByOut")
    @ResponseBody
    public Result getViewSysWithdrawalsByOut(HttpServletRequest request) {
        int page = Integer.valueOf(request.getParameter("page"));
        int limit = Integer.valueOf(request.getParameter("limit"));
        Result result = new Result();
        result.setMsg("获取成功");
        result.setData(viewSysWithdrawalsService.getViewSysWithdrawalsList(page, limit, true));
        result.setCode(true);
        return result;
    }

    @RequestMapping("/getViewSysWithdrawalsByIn")
    @ResponseBody
    public Result getViewSysWithdrawalsByIn(HttpServletRequest request) {
        int page = Integer.valueOf(request.getParameter("page"));
        int limit = Integer.valueOf(request.getParameter("limit"));
        Result result = new Result();
        result.setMsg("获取成功");
        result.setData(viewSysWithdrawalsService.getViewSysWithdrawalsList(page, limit, false));
        result.setCode(true);
        return result;
    }
}

