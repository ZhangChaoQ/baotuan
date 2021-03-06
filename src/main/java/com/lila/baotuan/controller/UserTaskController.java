package com.lila.baotuan.controller;


import com.lila.baotuan.entity.Result;
import com.lila.baotuan.service.impl.TaskServiceImpl;
import com.lila.baotuan.service.impl.UserTaskServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * <p>
 * 用户任务记录 前端控制器
 * </p>
 *
 * @author Zhang
 * @since 2020-03-28
 */
@Controller
@RequestMapping("/baotuan/userTask")
public class UserTaskController {

    @Resource
    private UserTaskServiceImpl userTaskService;
    @Resource
    private TaskServiceImpl taskService;

    /*
     * 接取任务
     * */
    public Result addUserTask(int userId,int taskId) {
        Result result = new Result();
        int count = taskService.updateSurplus(taskId);
        if (count == 0) {
            result.setCode(false);
            result.setData(-1);
            result.setMsg("该任务已结束，请刷新页面");
            return result;
        } else {
            int id = userTaskService.insertUserTask(userId, taskId);
            if (id == -1) {
                result.setCode(false);
                result.setData(id);
                result.setMsg("已接受过该任务，请勿重复接取");
                taskService.addSurplus(taskId);
            } else if (id == -2) {
                result.setCode(false);
                result.setData(id);
                result.setMsg("今日可接任务数量已接完，想继续接取任务请升级会员");
                taskService.addSurplus(taskId);
            } else {
                result.setCode(true);
                result.setData(id);
                result.setMsg("任务接受成功");
            }
        }
        return result;
    }

    /*
     * 完成任务
     * */
    public Result updateTaskStatus(int id, int url) {
        Result result = new Result();
        result.setCode(true);
        result.setMsg("任务已完成");
        result.setData(userTaskService.updateTaskStatus(id, url));
        return result;
    }
}

