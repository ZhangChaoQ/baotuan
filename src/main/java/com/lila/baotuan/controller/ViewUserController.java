package com.lila.baotuan.controller;


import com.alibaba.fastjson.JSONObject;
import com.lila.baotuan.entity.Result;
import com.lila.baotuan.service.impl.ViewUserServiceImpl;
import com.lila.baotuan.utils.ServiceUtil;
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
 * @since 2020-03-28
 */
@Controller
@RequestMapping("/baotuan/viewUser")
public class ViewUserController {

    @Resource
    private ViewUserServiceImpl viewUserService;


    @RequestMapping("/getViewUserList")
    @ResponseBody
    public Result getViewUserList(HttpServletRequest request) {

        int page = Integer.valueOf(request.getParameter("page"));
        int pageSize =  Integer.valueOf( request.getParameter("limit"));
        Result result = new Result();
        result.setData(viewUserService.getViewUserList(page, pageSize));
        result.setMsg("数据获取成功");
        result.setCode(true);
        return result;
    }

    @RequestMapping("/getViewUserCountByDay")
    @ResponseBody
    public Result getViewUserCountByDay() {
        Result result = new Result();
        result.setData(viewUserService.getViewUserCountByDay());
        result.setMsg("数据获取成功");
        result.setCode(true);
        return result;
    }
}

