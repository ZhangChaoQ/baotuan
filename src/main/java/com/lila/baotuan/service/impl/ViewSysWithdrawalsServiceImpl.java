package com.lila.baotuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lila.baotuan.entity.ViewSysWithdrawals;
import com.lila.baotuan.mapper.ViewSysWithdrawalsMapper;
import com.lila.baotuan.service.IViewSysWithdrawalsService;
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
public class ViewSysWithdrawalsServiceImpl extends ServiceImpl<ViewSysWithdrawalsMapper, ViewSysWithdrawals> implements IViewSysWithdrawalsService {
    public Page<ViewSysWithdrawals> getViewSysWithdrawalsList(int page, int limit,boolean flag) {
        return baseMapper.selectPage(new Page<>(page, limit), new QueryWrapper<ViewSysWithdrawals>().eq("pay_type",flag).orderByDesc("pay_money"));
    }
}
