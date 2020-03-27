package com.lila.baotuan.service.impl;

import com.lila.baotuan.entity.Permission;
import com.lila.baotuan.mapper.PermissionMapper;
import com.lila.baotuan.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author Zhang
 * @since 2020-03-27
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
