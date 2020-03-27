package com.lila.baotuan.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lila.baotuan.entity.Member;
import com.lila.baotuan.entity.SysWithdrawals;
import com.lila.baotuan.service.impl.MemberServiceImpl;
import com.lila.baotuan.service.impl.SysWithdrawalsServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <p>
 * 转款记录  前端控制器
 * </p>
 *
 * @author Zhang
 * @since 2020-03-27
 */
@Controller
@RequestMapping("/baotuan/sysWithdrawals")
public class SysWithdrawalsController {

    @Resource
    private SysWithdrawalsServiceImpl sysWithdrawalsService;
    @Resource
    private BrokeragesController brokeragesController;
    @Resource
    private UserController userController;

    /*
     *修改状态
     */
    public boolean updateSysWithdrawalsStatus(@Param("id") int id) {
        QueryWrapper<SysWithdrawals> qw = new QueryWrapper<>();
        qw.eq("id", id);
        SysWithdrawals sysWithdrawals = sysWithdrawalsService.getOne(qw);
        UpdateWrapper<SysWithdrawals> uw = new UpdateWrapper<>();
        uw.set("pay_status_id", 1);
        uw.eq("id", id);
        boolean result = sysWithdrawalsService.update(sysWithdrawals, uw);
        if (result) {
            userController.updateMoney(-sysWithdrawals.getMoney(), sysWithdrawals.getUserId());//修改金额
            brokeragesController.addBrokerage(sysWithdrawals.getUserId(),sysWithdrawals.getMoney());//增加记录
        }
        return result;
    }

    /*
     * 用户提款
     * */
    public boolean brokerage(@Param("userId") int userId, @Param("money") double money) {
        SysWithdrawals sysWithdrawals = new SysWithdrawals();
        sysWithdrawals.setCreatetime(LocalDateTime.now());
        sysWithdrawals.setMoney(money);
        sysWithdrawals.setPayStatusId(0);
        sysWithdrawals.setUserId(userId);
        sysWithdrawals.setPayMoney(money * 0.7);
        boolean result = sysWithdrawalsService.save(sysWithdrawals);
        return result;
    }
}

