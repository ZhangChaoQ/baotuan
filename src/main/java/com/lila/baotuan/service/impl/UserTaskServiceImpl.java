package com.lila.baotuan.service.impl;

import com.lila.baotuan.entity.UserTask;
import com.lila.baotuan.mapper.UserTaskMapper;
import com.lila.baotuan.service.IUserTaskService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户任务 服务实现类
 * </p>
 *
 * @author Zhang
 * @since 2020-03-24
 */
@Service
public class UserTaskServiceImpl extends ServiceImpl<UserTaskMapper, UserTask> implements IUserTaskService {
	
}
