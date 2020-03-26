package com.lila.baotuan.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lila.baotuan.entity.Task;
import com.lila.baotuan.service.impl.TaskServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

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

    @Resource
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
        return taskService.save(task);
    }

    /*
     * 修改任务数量
     * */
    public boolean updateTask(@Param("id") int id) {
        boolean result = false;
        QueryWrapper<Task> qw = new QueryWrapper<>();
        qw.eq("id", id);
        Task task = taskService.getOne(qw);
        UpdateWrapper<Task> uw = new UpdateWrapper<>();
        if (task.getNumber() != 0) {
            uw.set("number", task.getNumber() - 1);
            result = taskService.update(task, uw);
            return result;
        }
        return result;
    }

    /*
     * 删除任务
     * */
    public boolean deleteTask(@Param("id") int id) {
        QueryWrapper<Task> qw = new QueryWrapper<>();
        qw.eq("id", id);
        boolean result = taskService.remove(qw);
        return result;
    }

}
