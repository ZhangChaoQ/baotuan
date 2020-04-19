package com.lila.baotuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lila.baotuan.entity.SysWithdrawals;
import com.lila.baotuan.mapper.SysWithdrawalsMapper;
import com.lila.baotuan.service.ISysWithdrawalsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
     * 完成转款
     * */
    public int updatePayStatus(int id) {
        SysWithdrawals sysWithdrawals = getSysWithdrawalsById(id);
        return baseMapper.update(sysWithdrawals, new UpdateWrapper<SysWithdrawals>().set("pay_status_id", 1).eq("id",sysWithdrawals.getId()));
    }

    /*
     * 根据id 获取转款信息
     * */
    public SysWithdrawals getSysWithdrawalsById(int id) {
        return baseMapper.selectOne(new QueryWrapper<SysWithdrawals>().eq("id", id));
    }

    /*
     * 添加转款信息
     * */
    public int insertSysWithdrawals(int userId, double money,boolean flag) {
        SysWithdrawals sysWithdrawals = new SysWithdrawals();
        sysWithdrawals.setUserId(userId);
        sysWithdrawals.setPayStatusId(0);
        sysWithdrawals.setMoney(money);
        sysWithdrawals.setPayMoney(money * 0.7);
        sysWithdrawals.setCreatetime(LocalDateTime.now());
        sysWithdrawals.setPayType(flag);
        baseMapper.insert(sysWithdrawals);
        return sysWithdrawals.getId();
    }
}
