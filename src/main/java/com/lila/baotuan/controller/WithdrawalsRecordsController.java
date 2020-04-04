package com.lila.baotuan.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lila.baotuan.entity.Result;
import com.lila.baotuan.entity.WithdrawalsRecords;
import com.lila.baotuan.service.impl.WithdrawalsRecordsServiceImpl;
import com.lila.baotuan.utils.ServiceUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private WithdrawalsRecordsServiceImpl withdrawalsRecordsService;

    /*
     * 修改提现记录
     * */
    @RequestMapping("/addWithdrawalsRecords")
    public boolean updateWithdrawalsRecords(@Param("payStatusId") int payStatusId, @Param("id") int id) {
        int result = withdrawalsRecordsService.updateWithdrawals(payStatusId, id);
        return result == 1;
    }

    /*
     * 添加提现记录
     * */
    @RequestMapping("/addWithdrawalsRecords")
    @ResponseBody
    public Result addWithdrawalsRecords(HttpServletRequest request) {
        Result result = new Result();
        JSONObject jData = ServiceUtil.getJsonData(request);
        int userId = jData.getInteger("userId");
        double money = jData.getInteger("money");

        int id = withdrawalsRecordsService.addWithdrawals(userId, money);
        result.setCode(true);
        result.setMsg("提现申请提交成功，提现金额将于24小时内到账，请注意查收");
        result.setData(id);
        return result;
    }
}

