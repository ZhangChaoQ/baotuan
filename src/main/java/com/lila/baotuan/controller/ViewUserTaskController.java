package com.lila.baotuan.controller;


import com.alibaba.fastjson.JSONObject;
import com.lila.baotuan.entity.Result;
import com.lila.baotuan.entity.ViewUser;
import com.lila.baotuan.entity.ViewUserTask;
import com.lila.baotuan.service.impl.ViewUserTaskServiceImpl;
import com.lila.baotuan.utils.ServiceUtil;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @RequestMapping("/usertaskList")
    @ResponseBody
    public Result getUserTaskList(HttpServletRequest request) {
        JSONObject jData = ServiceUtil.getJsonData(request);
        int id = jData.getInteger("id");
        List<ViewUserTask> list = viewUserTaskService.getViewUserTaskListByUserId(id);
        Result result = new Result();
        result.setCode(true);
        result.setMsg("获取数据成功");
        result.setData(list);
        return result;
    }
}

