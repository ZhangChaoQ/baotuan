package com.lila.baotuan.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lila.baotuan.entity.Gathering;
import com.lila.baotuan.service.impl.GatheringServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <p>
 * 收款记录 前端控制器
 * </p>
 *
 * @author Zhang
 * @since 2020-03-26
 */
@Controller
@RequestMapping("/baotuan/gathering")
public class GatheringController {

    @Resource
    private GatheringServiceImpl gatheringService;

    @Resource
    private UserController userController;

    /*
     * 修改到款时间
     * */
    public boolean UpdateGathering(@Param("userId") int userId,@Param("memberId")int memberId,@Param("money")double money) {
        UpdateWrapper<Gathering> uw = new UpdateWrapper<>();
        uw.set("overtime", LocalDateTime.now());
        uw.eq("user_id", userId);
        uw.eq("money", money);
        boolean result = gatheringService.update(uw);
        if(result)userController.updateMember(memberId,userId);
        return result;
    }

    /*
     * 添加收款记录
     * */
    public boolean addGathering(@Param("userId") int userId, @Param("money") double money) {
        Gathering gathering = new Gathering();
        gathering.setCreatetime(LocalDateTime.now());
        gathering.setMoney(money);
        gathering.setUserId(userId);
        boolean result = gatheringService.save(gathering);
        return result;
    }

}

