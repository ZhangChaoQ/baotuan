package com.lila.baotuan.controller;


import com.lila.baotuan.entity.Result;
import com.lila.baotuan.service.impl.TaskTypeServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 任务类型 前端控制器
 * </p>
 *
 * @author Zhang
 * @since 2020-03-28
 */
@RestController
@RequestMapping("/baotuan/taskType")
public class TaskTypeController {

    @Resource
    private TaskTypeServiceImpl taskTypeService;

    @RequestMapping("/getTaskTypeList")
    public Result getTaskTypeList(HttpServletRequest request) {
        Result result = new Result();
        result.setData(taskTypeService.getTaskTypeList());
        result.setCode(true);
        result.setMsg("数据获取成功");
        return result;
    }
}

