package com.lila.baotuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lila.baotuan.entity.Task;
import com.lila.baotuan.mapper.TaskMapper;
import com.lila.baotuan.service.ITaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 任务 服务实现类
 * </p>
 *
 * @author Zhang
 * @since 2020-04-14
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements ITaskService {

    /*
     * 修改剩余数量
     * */
    public int updateSurplus(int id) {
        Task task = getTaskById(id);
        return baseMapper.update(task, new UpdateWrapper<Task>().set("surplus", task.getSurplus() - 1 < 0 ? 0 : task.getSurplus() - 1).eq("id", id));
    }

    /*
     * 修改剩余数量
     * */
    public int addSurplus(int id) {
        Task task = getTaskById(id);
        return baseMapper.update(task, new UpdateWrapper<Task>().set("surplus", task.getSurplus() + 1).eq("id", id));
    }

    /*
     * 根据id获取任务信息
     * */
    public Task getTaskById(int id) {
        return baseMapper.selectOne(new QueryWrapper<Task>().eq("id", id));
    }


    /*
     * 添加任务
     * */
    public int insertTask(int number, String title, String context, String url, double money) {
        Task task = new Task();
        task.setTaskTypeId(1);
        task.setTitle(title);
        task.setUrl(url);
        task.setMoney(money);
        task.setContext(context);
        task.setCreatetime(LocalDateTime.now());
        task.setSurplus(number);
        task.setNumber(number);
        baseMapper.insert(task);
        return task.getId();
    }

    /*
     * 获取所有任务
     * */
    public Page<Task> getTaskList(int page, int limit) {
        return baseMapper.selectPage(new Page<>(page, limit), new QueryWrapper<Task>().ne("surplus", 0));
    }
}
