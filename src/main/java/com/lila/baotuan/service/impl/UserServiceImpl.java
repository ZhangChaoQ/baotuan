package com.lila.baotuan.service.impl;

import com.lila.baotuan.entity.User;
import com.lila.baotuan.mapper.UserMapper;
import com.lila.baotuan.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author Zhang
 * @since 2020-03-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
