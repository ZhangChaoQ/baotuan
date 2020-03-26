package com.lila.baotuan.service.impl;

import com.lila.baotuan.entity.TaskStatus;
import com.lila.baotuan.mapper.TaskStatusMapper;
import com.lila.baotuan.service.ITaskStatusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 任务状态 服务实现类
 * </p>
 *
 * @author Zhang
 * @since 2020-03-26
 */
@Service
public class TaskStatusServiceImpl extends ServiceImpl<TaskStatusMapper, TaskStatus> implements ITaskStatusService {

}
