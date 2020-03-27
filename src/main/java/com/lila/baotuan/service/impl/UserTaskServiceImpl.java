package com.lila.baotuan.service.impl;

import com.lila.baotuan.entity.UserTask;
import com.lila.baotuan.mapper.UserTaskMapper;
import com.lila.baotuan.service.IUserTaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户任务记录 服务实现类
 * </p>
 *
 * @author Zhang
 * @since 2020-03-27
 */
@Service
public class UserTaskServiceImpl extends ServiceImpl<UserTaskMapper, UserTask> implements IUserTaskService {

}
