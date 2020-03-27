package com.lila.baotuan.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lila.baotuan.entity.UserTask;
import com.lila.baotuan.entity.ViewUserTask;
import com.lila.baotuan.service.impl.UserTaskServiceImpl;
import com.lila.baotuan.service.impl.ViewUserTaskServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * <p>
 * 用户任务记录 前端控制器
 * </p>
 *
 * @author Zhang
 * @since 2020-03-26
 */
@Controller
@RequestMapping("/baotuan/userTask")
public class UserTaskController {

    @Resource
    private UserTaskServiceImpl userTaskService;
    @Resource
    private ViewUserTaskServiceImpl viewUserTaskService;
    @Resource
    private UserController userController;
    @Resource
    private BrokeragesController brokeragesController;

    /*
     * 完成任务
     * */
    public boolean updateUserTask(@Param("id") int id, @Param("taskStatusId") int taskStatusId) {
        QueryWrapper<ViewUserTask> qw = new QueryWrapper<>();
        qw.eq("id", id);
        ViewUserTask viewUserTask = viewUserTaskService.getOne(qw);
        UpdateWrapper<UserTask> uw = new UpdateWrapper<>();
        uw.set("task_status_id", taskStatusId);
        uw.eq("id", id);
        boolean result = userTaskService.update(uw);
        if (result) {
            userController.updateMoney(viewUserTask.getTaskMoney()*0.98, viewUserTask.getUserId());
            brokeragesController.addTask(viewUserTask.getUserId(),viewUserTask.getTaskMoney()*0.98);
            userController.updateMoney(viewUserTask.getTaskMoney()*0.02, viewUserTask.getInviteId());
            brokeragesController.addTask(viewUserTask.getInviteId(),viewUserTask.getTaskMoney()*0.02);
        }
        return result;
    }

    /*
     * 添加任务
     * */
    public boolean addUserTask(@Param("userId") int userId, @Param("taskId") int taskId) {
        UserTask userTask = new UserTask();
        userTask.setTaskId(taskId);
        userTask.setUserId(userId);
        boolean result = userTaskService.save(userTask);
        return result;
    }
}

