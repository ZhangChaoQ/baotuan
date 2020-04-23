package com.lila.baotuan.controller;


import com.lila.baotuan.entity.Result;
import com.lila.baotuan.service.impl.ViewPayInfoServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * VIEW 前端控制器
 * </p>
 *
 * @author Zhang
 * @since 2020-04-23
 */
@RestController
@RequestMapping("/baotuan/viewPayInfo")
public class ViewPayInfoController {
    @Resource
    private ViewPayInfoServiceImpl viewPayInfoService;
    @RequestMapping("/getViewPayInfoList")
    public Result payInfoList(HttpServletRequest request){
        int page = Integer.valueOf(request.getParameter("page"));
        int limit = Integer.valueOf(request.getParameter("limit"));
        Result result=new Result();
        result.setCode(true);
        result.setMsg("审核已驳回");
        result.setData(viewPayInfoService.getViewPayInfoList(page,limit));
        return result;
    }
}

