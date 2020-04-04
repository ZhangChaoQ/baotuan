package com.lila.baotuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lila.baotuan.entity.WithdrawalsRecords;
import com.lila.baotuan.mapper.WithdrawalsRecordsMapper;
import com.lila.baotuan.service.IWithdrawalsRecordsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 提现记录 服务实现类
 * </p>
 *
 * @author Zhang
 * @since 2020-03-26
 */
@Service
public class WithdrawalsRecordsServiceImpl extends ServiceImpl<WithdrawalsRecordsMapper, WithdrawalsRecords> implements IWithdrawalsRecordsService {

    public WithdrawalsRecords getWithdrawalsById(int id) {
        return baseMapper.selectOne(new QueryWrapper<WithdrawalsRecords>().eq("id", id));
    }

    public int addWithdrawals(int userId, double money) {
        WithdrawalsRecords withdrawalsRecords = new WithdrawalsRecords();
        withdrawalsRecords.setCreatetime(LocalDateTime.now());
        withdrawalsRecords.setMoney(money);
        withdrawalsRecords.setPayMoney(money * 0.7);
        withdrawalsRecords.setUserId(userId);
        baseMapper.insert(withdrawalsRecords);
        return withdrawalsRecords.getId();
    }

    public int updateWithdrawals(int payStatusId, int id) {
        WithdrawalsRecords withdrawalsRecords = getWithdrawalsById(id);
        UpdateWrapper<WithdrawalsRecords> uw = new UpdateWrapper<>();
        uw.set("pay_status_id", payStatusId);
        uw.eq("id", id);
        return baseMapper.update(withdrawalsRecords, uw);
    }
}
