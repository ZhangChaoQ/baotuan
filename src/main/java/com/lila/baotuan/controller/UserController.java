package com.lila.baotuan.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lila.baotuan.entity.*;
import com.lila.baotuan.service.impl.*;
import com.lila.baotuan.utils.ServiceUtil;
import com.sun.deploy.nativesandbox.comm.Response;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author Zhang
 * @since 2020-03-28
 */
@RestController
@RequestMapping("/baotuan/user")
public class UserController {

    @Resource
    private UserServiceImpl userService;
    @Resource
    private ViewUserServiceImpl viewUserService;
    @Resource
    private ViewUserTaskServiceImpl viewUserTaskService;
    @Resource
    private BrokeragesServiceImpl brokeragesService;
    @Resource
    private UserTaskController userTaskController;

    /*
     * 禁用账号
     * */
    @RequestMapping("/enabled")
    public int enabledUser(HttpServletRequest request) {
        JSONObject jData = ServiceUtil.getJsonData(request);
        int id = jData.getInteger("id");
        return userService.enabledUser(id);
    }

    /*
     * 启用账号
     * */
    @RequestMapping("/enable")
    public int enableUser(HttpServletRequest request) {
        JSONObject jData = ServiceUtil.getJsonData(request);
        int id = jData.getInteger("id");
        return userService.enabledUser(id);
    }

    /*
     * 接受任务
     * */
    @RequestMapping("/insertUserTask")
    public Result insertUserTask(HttpServletRequest request) {
        JSONObject jData = ServiceUtil.getJsonData(request);
        int userId = jData.getInteger("userId");
        int taskId = jData.getInteger("taskId");
        return userTaskController.intsetUserTask(userId, taskId);
    }


    /*
     * 完成任务
     * */
    @RequestMapping("/commitTask")
    public Result commitTask(HttpServletRequest request) {
        JSONObject jData = ServiceUtil.getJsonData(request);
        int id = jData.getInteger("id");
        int url = jData.getInteger("url");
        ViewUserTask viewUserTask = viewUserTaskService.getViewUserTaskById(id);
        ViewUser viewUser = viewUserService.getViewUserById(viewUserTask.getUserId());
        ViewUser inviter = viewUserService.getViewUserById(viewUser.getUserId());

        userService.updateMoney(viewUser.getId(), viewUserTask.getTaskMoney() * 0.98);
        brokeragesService.insertTask(viewUser.getId(), viewUserTask.getTaskMoney() * 0.98);

        userService.updateMoney(inviter.getId(), viewUserTask.getTaskMoney() * 0.02);
        brokeragesService.insertBrokerage(inviter.getId(), viewUserTask.getTaskMoney() * 0.02);

        return userTaskController.updateTaskStatus(id, url);
    }

    /*
     * 成为会员
     * */
    @RequestMapping("/toMember")
    public int toMember(HttpServletRequest request) {
        JSONObject jData = ServiceUtil.getJsonData(request);
        int id = jData.getInteger("id");
        int memberId = jData.getInteger("memberId");
        ViewUser viewUser = viewUserService.getViewUserById(id);
        ViewUser inviter = viewUserService.getViewUserById(viewUser.getUserId());
        int result = userService.updateMember(id, memberId);

        userService.updateMoney(viewUser.getUserId(), viewUser.getInviterMemberMoney() * 0.2);
        brokeragesService.insertInvite(viewUser.getId(), viewUser.getInviterMemberMoney() * 0.2);

        userService.updateMoney(inviter.getUserId(), inviter.getInviterMemberMoney() * 0.05);
        brokeragesService.insertInvite(viewUser.getId(), inviter.getInviterMemberMoney() * 0.05);
        return result;
    }

    /*
     * 用戶注冊
     * */
    @RequestMapping("/addUser")
    public int addUser(HttpServletRequest request) {
        JSONObject jData = ServiceUtil.getJsonData(request);
        String phone = jData.getString("phone");
        String password = jData.getString("password");
        String inviteCode = jData.getString("inviteCode");
        User inviter = userService.getUserByInviteCode(inviteCode);
        int id = userService.insertUser(password, getCode(inviter), getInviteCode(), phone, inviter.getId());
        return id;
    }

    /*
     * 用戶登录
     * */
    @RequestMapping(value = "/login")
    public Result login(HttpServletRequest request) {
        JSONObject jData = ServiceUtil.getJsonData(request);
        String phone = jData.getString("phone");
        String password = jData.getString("password");
        User user = userService.userLogin(phone, password);
        Result result = new Result();
        if (null != user) {
            result.setCode(true);
            result.setData(user);
            result.setMsg("登录成功");
        } else {
            result.setCode(false);
            result.setData(null);
            result.setMsg("登录失败，请检查账号和密码是否正确");
        }
        return result;
    }

    /*
     * 綁定支付宝
     * */
    @RequestMapping("/bindAlipay")
    public String bindAlipay(HttpServletRequest request) {
        JSONObject jData = ServiceUtil.getJsonData(request);
        String alipayCccount = jData.getString("alipayCccount");
        int alipayUrl = jData.getInteger("alipayUrl");
        int id = jData.getInteger("id");
        userService.updateAlipay(id, alipayCccount, alipayUrl);
        return "index";
    }

    /*
     * 修改昵称
     * */
    @RequestMapping("/reName")
    public String reName(HttpServletRequest request) {
        JSONObject jData = ServiceUtil.getJsonData(request);
        int id = jData.getInteger("id");
        String name = jData.getString("name");
        userService.updateName(id, name);
        return "index";
    }

    /*
     * 个人邀请码
     * */
    public String getInviteCode() {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
        char ch = str.charAt(str.length() - 1);
        StringBuffer sb = new StringBuffer(6);
        for (int i = 0; i < 6; i++) {
            char ch2 = str.charAt(new Random().nextInt(str.length()));
            sb.append(ch2);
        }
        if (checkInviteCode(sb.toString())) getInviteCode();
        return sb.toString();
    }

    /*
     * 检验用户邀请码
     * */
    @RequestMapping("/checkInviteCode")
    public boolean checkInviteCode(HttpServletRequest request) {
        JSONObject jData = ServiceUtil.getJsonData(request);
        String inviteCode = jData.getString("inviteCode");
        return userService.getCountByInviteCode(inviteCode) > 0;
    }

    public boolean checkInviteCode(String inviteCode) {
        return userService.getCountByInviteCode(inviteCode) > 0;
    }

    /*
     * 检验用户重复
     * */
    @RequestMapping("/checkPhone")
    public boolean check(HttpServletRequest request) {
        JSONObject jData = ServiceUtil.getJsonData(request);
        String phone = jData.getString("phone");
        return userService.getCountByPhone(phone) > 0;
    }

    /*
     * 获取用户编码
     * */
    public String getCode(User user) {
        String userCode = user.getCode();
        String[] code = userCode.split("-");
        String sup = code[1] + Integer.valueOf(code[2]);//上级
        char letter = code[1].substring(code[1].length() - 1).charAt(0);
        int number = Integer.valueOf(code[1].substring(0, code[1].length() - 1));
        if (letter + 1 > 90) {
            number += 1;
            letter = 65;
        } else {
            letter += 1;
        }
        String count = userService.getCountByUserId(user.getId()) + 1 + "";
        for (int i = count.length(); i < 5; i++) {
            count = "0" + count;
        }
        return sup + "-" + number + "" + letter + "-" + count;
    }
}

