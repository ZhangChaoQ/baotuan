package com.lila.baotuan.controller;


import com.lila.baotuan.entity.Result;
import com.lila.baotuan.service.impl.ViewBrokeragesServiceImpl;
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
 * @since 2020-04-07
 */
@Controller
@RequestMapping("/baotuan/viewBrokerages")
public class ViewBrokeragesController {

    @Resource
    private ViewBrokeragesServiceImpl viewBrokeragesService;

    @ResponseBody
    @RequestMapping("/getViewBrokeragesByIn")
    public Result getViewBrokeragesByIn(HttpServletRequest request){
        int page = Integer.valueOf(request.getParameter("page"));
        int pageSize =  Integer.valueOf( request.getParameter("limit"));
        Result result = new Result();
        result.setData(viewBrokeragesService.getViewBrokeragesByIn(page, pageSize));
        result.setMsg("数据获取成功");
        result.setCode(true);
        return result;
    }
    @ResponseBody
    @RequestMapping("/getViewBrokeragesByOut")
    public Result getViewBrokeragesByOut(HttpServletRequest request){
        int page = Integer.valueOf(request.getParameter("page"));
        int pageSize =  Integer.valueOf( request.getParameter("limit"));
        Result result = new Result();
        result.setData(viewBrokeragesService.getViewBrokeragesByOut(page, pageSize));
        result.setMsg("数据获取成功");
        result.setCode(true);
        return result;
    }

}

