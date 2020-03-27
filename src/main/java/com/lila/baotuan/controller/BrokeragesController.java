package com.lila.baotuan.controller;


import com.lila.baotuan.entity.Brokerages;
import com.lila.baotuan.service.impl.BrokeragesServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <p>
 * 金额记录 前端控制器
 * </p>
 *
 * @author Zhang
 * @since 2020-03-27
 */
@Controller
@RequestMapping("/baotuan/brokerages")
public class BrokeragesController {

    @Resource
    private BrokeragesServiceImpl brokeragesService;
    @Resource
    private UserController userController;


    /*
     * 添加提款记录
     * id:用戶id
     * money:提现金额
     * */
    public boolean addWithdraw(@Param("id") int id, @Param("money") double money) {
        Brokerages brokerages = new Brokerages();
        brokerages.setUserId(id);
        brokerages.setMoney(money);
        brokerages.setCreatetime(LocalDateTime.now());
        brokerages.setBrokeragesTypeId(0);
        boolean result = brokeragesService.save(brokerages);
        return result;

    }

    /*
     * 添加分佣奖励记录
     * */
    public boolean addBrokerage(@Param("id") int id, @Param("money") double money) {
        Brokerages brokerages = new Brokerages();
        brokerages.setUserId(id);
        brokerages.setMoney(money);
        brokerages.setCreatetime(LocalDateTime.now());
        brokerages.setBrokeragesTypeId(2);
        boolean result = brokeragesService.save(brokerages);
        return result;
    }

    /*
     * 添加邀请奖励记录
     * */
    public boolean addInvite(@Param("id") int id, @Param("money") double money) {
        Brokerages brokerages = new Brokerages();
        brokerages.setUserId(id);
        brokerages.setMoney(money);
        brokerages.setCreatetime(LocalDateTime.now());
        brokerages.setBrokeragesTypeId(2);
        boolean result = brokeragesService.save(brokerages);
        return result;
    }

    /*
     * 添加任务奖励记录
     * */
    public boolean addTask(@Param("id") int id, @Param("money") double money) {
        Brokerages brokerages = new Brokerages();
        brokerages.setUserId(id);
        brokerages.setMoney(money);
        brokerages.setCreatetime(LocalDateTime.now());
        brokerages.setBrokeragesTypeId(1);
        boolean result = brokeragesService.save(brokerages);
        return result;
    }
}

