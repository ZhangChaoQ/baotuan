package com.lila.baotuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lila.baotuan.entity.ViewPayInfo;
import com.lila.baotuan.mapper.ViewPayInfoMapper;
import com.lila.baotuan.service.IViewPayInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author Zhang
 * @since 2020-04-23
 */
@Service
public class ViewPayInfoServiceImpl extends ServiceImpl<ViewPayInfoMapper, ViewPayInfo> implements IViewPayInfoService {

    public Page<ViewPayInfo> getViewPayInfoList(int page, int limit) {
        return baseMapper.selectPage(new Page<ViewPayInfo>(page, limit), new QueryWrapper<ViewPayInfo>().eq("pay_status_id", 1));
    }
}
