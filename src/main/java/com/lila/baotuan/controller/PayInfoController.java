package com.lila.baotuan.controller;


import com.lila.baotuan.entity.*;
import com.lila.baotuan.service.impl.*;
import com.lila.baotuan.utils.DoubleUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Zhang
 * @since 2020-04-23
 */
@RestController
@RequestMapping("/baotuan/payInfo")
public class PayInfoController {

    @Resource
    private PayInfoServiceImpl payInfoService;
    @Resource
    private MemberServiceImpl memberService;
    @Resource
    private UserServiceImpl userService;
    @Resource
    private ViewUserServiceImpl viewUserService;
    @Resource
    private SysWithdrawalsServiceImpl sysWithdrawalsService;
    @Resource
    private BrokerageServiceImpl brokerageService;
    @RequestMapping("/addPay")
    public Result addPay(HttpServletRequest request) {
        int userId = Integer.valueOf(request.getParameter("userId"));
        int payMoney = Integer.valueOf(request.getParameter("payMoney"));
        int memberId = Integer.valueOf(request.getParameter("memberId"));
        String payCode = request.getParameter("payCode");
        Result result=new Result();
        result.setCode(true);
        result.setMsg("正交由人工审核中，订单将于2小时内生效");
        result.setData(payInfoService.insertPayInfo(userId,payMoney,payCode,memberId));
        return result;
    }
    @RequestMapping("/success")
    public Result payInfoSuccess(HttpServletRequest request){
        int id = Integer.valueOf(request.getParameter("id"));
        PayInfo payInfo=payInfoService.getPayInfoById(id);

        int userId = payInfo.getUserId();
        Member member =memberService.getMemberById(payInfo.getMemberId());
        /*修改会员等级*/
        userService.updateMember(userId, member.getId());
        /*上级获取分佣*/
        ViewUser viewUser = viewUserService.getViewUserById(userId);
        if (-1 != viewUser.getUserId()) {
            userService.updateMoney(viewUser.getUserId(), DoubleUtil.mul(viewUser.getInviterMemberMoney(), 0.2));
            brokerageService.insertInvite(viewUser.getId(), DoubleUtil.mul(viewUser.getInviterMemberMoney(), 0.2));
            ViewUser inviter = viewUserService.getViewUserById(viewUser.getUserId());
            if (-1 != inviter.getUserId()) {
                userService.updateMoney(inviter.getUserId(), DoubleUtil.mul(inviter.getInviterMemberMoney(), 0.05));
                brokerageService.insertInvite(viewUser.getId(), DoubleUtil.mul(inviter.getInviterMemberMoney(), 0.05));
            }
        }
        /*添加进账*/
        sysWithdrawalsService.insertSysWithdrawals(userId, payInfo.getPayMoney(), false);

        Result result=new Result();
        result.setCode(true);
        result.setMsg("审核通过");
        result.setData(payInfoService.updatePayInfoStatusSuccess(payInfo));
        return result;
    }
    @RequestMapping("/fail")
    public Result payInfoFail(HttpServletRequest request){
        int id = Integer.valueOf(request.getParameter("id"));
        String reason=request.getParameter("reason");
        Result result=new Result();
        result.setCode(true);
        result.setMsg("审核已驳回");
        result.setData(payInfoService.updatePayInfoStatusFail(id,reason));
        return result;
    }
    @RequestMapping("/getPayInfoList")
    public Result payInfoList(HttpServletRequest request){
        int page = Integer.valueOf(request.getParameter("page"));
        int limit = Integer.valueOf(request.getParameter("limit"));
        Result result=new Result();
        result.setCode(true);
        result.setMsg("获取成功");
        result.setData(payInfoService.getPayInfoList(page,limit));
        return result;
    }
    @RequestMapping("/getPayInfoListByUserId")
    public Result payInfoListByUserId(HttpServletRequest request){
        int userId = Integer.valueOf(request.getParameter("userId"));
        Result result=new Result();
        result.setCode(true);
        result.setMsg("获取成功");
        result.setData(payInfoService.getPayInfoListByUserId(userId));
        return result;
    }
}

