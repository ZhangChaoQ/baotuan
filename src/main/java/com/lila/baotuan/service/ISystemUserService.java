package com.lila.baotuan.service;

import com.lila.baotuan.entity.SystemUser;
import com.baomidou.mybatisplus.service.IService;
import com.lila.baotuan.service.impl.SystemUserServiceImpl;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户 服务类
 * </p>
 *
 * @author Zhang
 * @since 2020-03-25
 */
public interface ISystemUserService extends IService<SystemUser> {

}
