package com.lila.baotuan.controller;


import com.alibaba.fastjson.JSONObject;
import com.lila.baotuan.entity.Result;
import com.lila.baotuan.service.impl.ViewTaskServiceImpl;
import com.lila.baotuan.utils.ServiceUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * VIEW 前端控制器
 * </p>
 *
 * @author Zhang
 * @since 2020-04-13
 */
@RestController
@RequestMapping("/baotuan/viewTask")
public class ViewTaskController {

    @Resource
    private ViewTaskServiceImpl viewTaskService;

    @RequestMapping("/getViewTaskList")
    public Result getViewTaskList(HttpServletRequest request) {
        int page = Integer.valueOf(request.getParameter("page"));
        int limit = Integer.valueOf(request.getParameter("limit"));
        Result result = new Result();
        result.setCode(true);
        result.setMsg("获取成功");
        result.setData(viewTaskService.getViewTaskList(page, limit));
        return result;

    }
}

