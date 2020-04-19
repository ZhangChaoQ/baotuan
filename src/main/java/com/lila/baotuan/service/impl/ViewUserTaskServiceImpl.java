package com.lila.baotuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lila.baotuan.entity.ViewUserTask;
import com.lila.baotuan.mapper.ViewUserTaskMapper;
import com.lila.baotuan.service.IViewUserTaskService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author Zhang
 * @since 2020-04-14
 */
@Service
public class ViewUserTaskServiceImpl extends ServiceImpl<ViewUserTaskMapper, ViewUserTask> implements IViewUserTaskService {
    /*
     * 根据id返回任务信息
     * */
    public ViewUserTask getViewUserTaskById(int id) {
        return baseMapper.selectOne(new QueryWrapper<ViewUserTask>().eq("id", id));
    }

    /*
     * 根据用户id获取任务列表
     * */
    public Page<ViewUserTask> getViewUserTaskListByUserId(int page, int limit, int userId) {
        return baseMapper.selectPage(new Page<>(page, limit), new QueryWrapper<ViewUserTask>().eq("task_status_id", 1).eq("user_id",userId));
    }
}
