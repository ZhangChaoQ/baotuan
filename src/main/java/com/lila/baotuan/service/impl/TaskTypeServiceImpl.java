package com.lila.baotuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lila.baotuan.entity.TaskType;
import com.lila.baotuan.mapper.TaskTypeMapper;
import com.lila.baotuan.service.ITaskTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 任务类型 服务实现类
 * </p>
 *
 * @author Zhang
 * @since 2020-04-14
 */
@Service
public class TaskTypeServiceImpl extends ServiceImpl<TaskTypeMapper, TaskType> implements ITaskTypeService {
    public List<TaskType> getTaskTypeList() {
        return baseMapper.selectList(new QueryWrapper<TaskType>());
    }
}
