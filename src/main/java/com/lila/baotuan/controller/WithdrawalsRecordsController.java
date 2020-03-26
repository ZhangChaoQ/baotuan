package com.lila.baotuan.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lila.baotuan.entity.WithdrawalsRecords;
import com.lila.baotuan.service.impl.WithdrawalsRecordsServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <p>
 * 提现记录 前端控制器
 * </p>
 *
 * @author Zhang
 * @since 2020-03-26
 */
@Controller
@RequestMapping("/baotuan/withdrawalsRecords")
public class WithdrawalsRecordsController {

    @Resource
    private WithdrawalsRecordsServiceImpl withdrawalsRecordsService;

    /*
     * 修改提现记录
     * */
    public boolean updateWithdrawalsRecords(@Param("payStatusId") int payStatusId, @Param("id") int id) {
        UpdateWrapper<WithdrawalsRecords> uw = new UpdateWrapper<>();
        uw.set("pay_status_id", payStatusId);
        uw.eq("id", id);
        boolean result = withdrawalsRecordsService.update(uw);
        return result;
    }

    /*
     * 添加提现记录
     * */
    public boolean addWithdrawalsRecords(@Param("userId") int userId, @Param("money") double money) {
        WithdrawalsRecords withdrawalsRecords = new WithdrawalsRecords();
        withdrawalsRecords.setCreatetime(LocalDateTime.now());
        withdrawalsRecords.setMoney(money);
        withdrawalsRecords.setPayMoney(money * 0.7);
        withdrawalsRecords.setUserId(userId);
        boolean result = withdrawalsRecordsService.save(withdrawalsRecords);
        return result;
    }
}

