package com.lila.baotuan.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.lila.baotuan.entity.Task;
import com.lila.baotuan.service.impl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 任务 前端控制器
 * </p>
 *
 * @author Zhang
 * @since 2020-03-25
 */
@Controller
@RequestMapping("/baotuan/task")
public class TaskController {

    @Autowired
    private TaskServiceImpl taskService;

    /*
     * 添加任务
     * */
    @RequestMapping("/addTask")
    public boolean addTask(double money, String title, String context, int number, int taskTypeId, String url) {
        Task task = new Task();
        task.setContext(context);
        task.setMoney(money);
        task.setNumber(number);
        task.setTitle(title);
        task.setUrl(url);
        task.setTaskTypeId(taskTypeId);
        return taskService.insert(task);
    }


}
