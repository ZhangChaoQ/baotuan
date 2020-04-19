package com.lila.baotuan.controller;


import com.lila.baotuan.entity.Result;
import com.lila.baotuan.service.impl.BrokerageServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 金额记录 前端控制器
 * </p>
 *
 * @author Zhang
 * @since 2020-03-28
 */
@Controller
@RequestMapping("/baotuan/brokerage")
public class BrokerageController {
    @Resource
    private BrokerageServiceImpl brokerageService;

    @RequestMapping("/getBrokerageList")
    @ResponseBody
    public Result getBrokerageList(HttpServletRequest request) {
        int page = Integer.valueOf(request.getParameter("page"));
        int limit = Integer.valueOf(request.getParameter("limit"));
        int typeId = Integer.valueOf(request.getParameter("typeId"));
        int userId = Integer.valueOf(request.getParameter("userId"));
        Result result = new Result();
        result.setCode(true);
        result.setData(brokerageService.getListByTypeAndUserId(page, limit,typeId,userId));
        result.setMsg("获取成功");
        return result;
    }
}

