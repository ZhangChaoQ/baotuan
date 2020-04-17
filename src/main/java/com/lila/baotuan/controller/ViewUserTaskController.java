package com.lila.baotuan.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lila.baotuan.entity.Result;
import com.lila.baotuan.entity.ViewUserTask;
import com.lila.baotuan.service.impl.ViewUserTaskServiceImpl;
import com.lila.baotuan.utils.ServiceUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/baotuan/viewUserTask")
public class ViewUserTaskController {

    @Resource
    private ViewUserTaskServiceImpl viewUserTaskService;

    @RequestMapping("/userTaskList")
    @ResponseBody
    public Result getUserTaskList(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id"));
        int page = Integer.valueOf(request.getParameter("page"));
        int limit = Integer.valueOf(request.getParameter("limit"));
        Page<ViewUserTask> list = viewUserTaskService.getViewUserTaskListByUserId(page,limit,id);
        Result result = new Result();
        result.setCode(true);
        result.setMsg("获取数据成功");
        result.setData(list);
        return result;
    }

    @RequestMapping("/userTask")
    @ResponseBody
    public Result getUserTask(HttpServletRequest request) {
        JSONObject jData = ServiceUtil.getJsonData(request);
        int id = jData.getInteger("id");
        ViewUserTask viewUserTask = viewUserTaskService.getViewUserTaskById(id);
        Result result = new Result();
        result.setCode(true);
        result.setMsg("获取数据成功");
        result.setData(viewUserTask);
        return result;
    }
}

