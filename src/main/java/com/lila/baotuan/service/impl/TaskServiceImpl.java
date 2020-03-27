package com.lila.baotuan.service.impl;

import com.lila.baotuan.entity.Task;
import com.lila.baotuan.mapper.TaskMapper;
import com.lila.baotuan.service.ITaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 任务 服务实现类
 * </p>
 *
 * @author Zhang
 * @since 2020-03-27
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements ITaskService {

}
