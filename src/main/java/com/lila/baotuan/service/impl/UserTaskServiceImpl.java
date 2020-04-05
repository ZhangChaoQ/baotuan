package com.lila.baotuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lila.baotuan.entity.UserTask;
import com.lila.baotuan.entity.ViewUser;
import com.lila.baotuan.mapper.UserTaskMapper;
import com.lila.baotuan.service.IUserTaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lila.baotuan.utils.DateTimeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 用户任务记录 服务实现类
 * </p>
 *
 * @author Zhang
 * @since 2020-03-28
 */
@Service
public class UserTaskServiceImpl extends ServiceImpl<UserTaskMapper, UserTask> implements IUserTaskService {
    @Resource
    private ViewUserServiceImpl viewUserService;

    /*
     * 接取任务
     * */
    public int insertUserTask(int userId, int taskId) {
        if (checkNum(userId, taskId)) return -1;
        if (checkCount(userId, taskId)) return -2;
        UserTask userTask = new UserTask();
        userTask.setUserId(userId);
        userTask.setTaskId(taskId);
        userTask.setTaskStatusId(1);
        userTask.setCreatetime(LocalDateTime.now());
        baseMapper.insert(userTask);
        return userTask.getId();
    }

    /*
     * 今日任务数完成
     * */
    private boolean checkCount(int userId, int taskId) {
        boolean result;
        ViewUser viewUser = viewUserService.getViewUserById(userId);
        int count = baseMapper.selectCount(new QueryWrapper<UserTask>().eq("user_id", userId).between("createtime", DateTimeUtil.getNowDayBefore(), DateTimeUtil.getNowDayEnd()));
        result = viewUser.getTaskNumber() <= count;
        return result;
    }


    /*
     * 已接受过任务
     * */
    private boolean checkNum(int userId, int taskId) {
        boolean result;
        result = baseMapper.selectCount(new QueryWrapper<UserTask>().eq("user_id", userId).eq("task_id", taskId)) == 1;
        return result;
    }


    /*
     * 完成任务
     * */
    public int updateTaskStatus(int id, int url) {
        UserTask userTask = getUserTaskById(id);
        return baseMapper.update(userTask, new UpdateWrapper<UserTask>().set("task_status_id", 2).set("url", url));
    }

    /*
     * 获取任务信息
     * */
    private UserTask getUserTaskById(int id) {
        return baseMapper.selectOne(new QueryWrapper<UserTask>().eq("id", id));
    }

}
