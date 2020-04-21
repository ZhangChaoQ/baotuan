package com.lila.baotuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lila.baotuan.entity.ViewSysBrokerages;
import com.lila.baotuan.mapper.ViewSysBrokeragesMapper;
import com.lila.baotuan.service.IViewSysBrokeragesService;
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
public class ViewSysBrokeragesServiceImpl extends ServiceImpl<ViewSysBrokeragesMapper, ViewSysBrokerages> implements IViewSysBrokeragesService {
    public Page<ViewSysBrokerages> getViewSysBrokeragesList(int page, int pageSize) {
        return baseMapper.selectPage(new Page<>(page, pageSize), new QueryWrapper<ViewSysBrokerages>().eq("sys_brokerages_status_id", 3));
    }

}
