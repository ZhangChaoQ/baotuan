package com.lila.baotuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lila.baotuan.entity.ViewTask;
import com.lila.baotuan.mapper.ViewTaskMapper;
import com.lila.baotuan.service.IViewTaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class ViewTaskServiceImpl extends ServiceImpl<ViewTaskMapper, ViewTask> implements IViewTaskService {
    public Page<ViewTask> getViewTaskList(int page, int limit) {
        return baseMapper.selectPage(new Page<ViewTask>(page, limit), new QueryWrapper<ViewTask>().ne("surplus", "0"));
    }
}
