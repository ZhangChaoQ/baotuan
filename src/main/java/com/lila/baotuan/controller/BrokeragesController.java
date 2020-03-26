package com.lila.baotuan.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lila.baotuan.entity.Brokerages;
import com.lila.baotuan.entity.User;
import com.lila.baotuan.entity.ViewUser;
import com.lila.baotuan.service.impl.BrokeragesServiceImpl;
import com.lila.baotuan.service.impl.UserServiceImpl;
import com.lila.baotuan.service.impl.ViewUserServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <p>
 * 分佣记录 前端控制器
 * </p>
 *
 * @author Zhang
 * @since 2020-03-26
 */
@Controller
@RequestMapping("/baotuan/brokerages")
public class BrokeragesController {

    @Resource
    private BrokeragesServiceImpl brokeragesService;

    @Resource
    private ViewUserServiceImpl viewUserService;

    @Resource
    private UserController userController;

    /*
     * 获得分佣
     * 增加记录
     * 修改余额
     * */
    public boolean getBrokerage(@Param("userId") int userId) {
        boolean f = false;
        QueryWrapper<ViewUser> qw = new QueryWrapper<>();
        qw.eq("id", userId);
        ViewUser viewUser = viewUserService.getOne(qw);
        double money = viewUser.getInviterMemberMoney() * 0.2;
        f = userController.updateMoney(money, viewUser.getId());
        if (f) return f;
        f = addBrokerage(userId, viewUser.getId(), money);
        if (!f) return f;
        qw.clear();
        qw.eq("id", viewUser.getUserId());
        ViewUser inviter = viewUserService.getOne(qw);
        f = userController.updateMoney(money, inviter.getId());
        if (!f) return f;
        f = addBrokerage(userId, inviter.getId(), money);
        if (!f) return f;
        return true;
    }

    /*
     * 添加记录
     * */
    public boolean addBrokerage(@Param("userId") int userId, @Param("inviteId") int inviteId, @Param("money") double money) {
        Brokerages brokerages = new Brokerages();
        brokerages.setCreatetime(LocalDateTime.now());
        brokerages.setInviterId(inviteId);
        brokerages.setMoney(money);
        brokerages.setUserId(userId);
        boolean result = brokeragesService.save(brokerages);
        return result;
    }

}

