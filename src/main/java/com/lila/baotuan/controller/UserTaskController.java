package com.lila.baotuan.controller;


import com.alibaba.fastjson.JSONObject;
import com.lila.baotuan.entity.Result;
import com.lila.baotuan.service.impl.TaskServiceImpl;
import com.lila.baotuan.service.impl.UserTaskServiceImpl;
import com.lila.baotuan.utils.ServiceUtil;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
    @RequestMapping(value = "/insertUserTask")
    @ResponseBody
    public Result intsetUserTask(HttpServletRequest request) {
        JSONObject jData = ServiceUtil.getJsonData(request);
        int userId = jData.getInteger("userId");
        int taskId = jData.getInteger("taskId");
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
    @RequestMapping("/updateTaskStatus")
    public int updateTaskStatus(int id) {
        return userTaskService.updateTaskStatus(id);
    }
}

