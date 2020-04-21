package com.lila.baotuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lila.baotuan.entity.SysWithdrawals;
import com.lila.baotuan.mapper.SysWithdrawalsMapper;
import com.lila.baotuan.service.ISysWithdrawalsService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 转款记录   会员、转款 服务实现类
 * </p>
 *
 * @author Zhang
 * @since 2020-04-14
 */
@Service
public class SysWithdrawalsServiceImpl extends ServiceImpl<SysWithdrawalsMapper, SysWithdrawals> implements ISysWithdrawalsService {

    /*
     * 根据id 获取转款信息
     * */
    public SysWithdrawals getSysWithdrawalsById(int id) {
        return baseMapper.selectOne(new QueryWrapper<SysWithdrawals>().eq("id", id));
    }

    /*
     * 添加转款信息
     * */
    public int insertSysWithdrawals(int userId, double money, boolean flag) {
        SysWithdrawals sysWithdrawals = new SysWithdrawals();
        sysWithdrawals.setUserId(userId);
        sysWithdrawals.setPayStatusId(2);
        sysWithdrawals.setMoney(money);
        sysWithdrawals.setPayMoney(money);
        sysWithdrawals.setCreatetime(LocalDateTime.now());
        sysWithdrawals.setPayType(flag);
        baseMapper.insert(sysWithdrawals);
        return sysWithdrawals.getId();
    }
}
