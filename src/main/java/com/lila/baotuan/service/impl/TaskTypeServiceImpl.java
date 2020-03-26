package com.lila.baotuan.service.impl;

import com.lila.baotuan.entity.TaskType;
import com.lila.baotuan.mapper.TaskTypeMapper;
import com.lila.baotuan.service.ITaskTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 任务类型 服务实现类
 * </p>
 *
 * @author Zhang
 * @since 2020-03-26
 */
@Service
public class TaskTypeServiceImpl extends ServiceImpl<TaskTypeMapper, TaskType> implements ITaskTypeService {

}
