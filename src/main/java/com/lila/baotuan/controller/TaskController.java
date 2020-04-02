package com.lila.baotuan.controller;


import com.lila.baotuan.entity.Result;
import com.lila.baotuan.entity.Task;
import com.lila.baotuan.service.impl.TaskServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 任务 前端控制器
 * </p>
 *
 * @author Zhang
 * @since 2020-03-28
 */
@Controller
@RequestMapping("/baotuan/task")
public class TaskController {

    @Resource
    private TaskServiceImpl taskService;

    @RequestMapping("/taskList")
    @ResponseBody
    public Result getTaskList() {
        Result result = new Result();
        List<Task> list = taskService.getTaskList();
        result.setMsg("获取成功");
        result.setData(list);
        result.setCode(true);
        return result;
    }
}

