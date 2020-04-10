package com.lila.baotuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lila.baotuan.entity.ViewBrokerages;
import com.lila.baotuan.mapper.ViewBrokeragesMapper;
import com.lila.baotuan.service.IViewBrokeragesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author Zhang
 * @since 2020-04-07
 */
@Service
public class ViewBrokeragesServiceImpl extends ServiceImpl<ViewBrokeragesMapper, ViewBrokerages> implements IViewBrokeragesService {

    public Object getViewBrokeragesByOut(int page, int pageSize) {
        return baseMapper.selectPage(new Page<>(page, pageSize), new QueryWrapper<ViewBrokerages>().eq("sys_brokerages_type_id", 2));
    }

    public Object getViewBrokeragesByIn(int page, int pageSize) {
        return baseMapper.selectPage(new Page<>(page, pageSize), new QueryWrapper<ViewBrokerages>().eq("sys_brokerages_type_id", 1));
    }
}
