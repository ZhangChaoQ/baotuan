package com.lila.baotuan.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lila.baotuan.entity.SysUser;
import com.lila.baotuan.service.impl.SysUserServiceImpl;
import com.lila.baotuan.tools.MD5Util;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * <p>
 * 后台用户 前端控制器
 * </p>
 *
 * @author Zhang
 * @since 2020-03-26
 */
@Controller
@RequestMapping("/baotuan/sysUser")
public class SysUserController {

    @Resource
    private  SysUserServiceImpl sysUserService;

    /*
     * 检验用户重复
     * */
    @RequestMapping("/check")
    @ResponseBody
    public boolean check(@Param("loginName") String loginName) {
        QueryWrapper<SysUser> qw = new QueryWrapper<>();
        qw.eq("login_name", loginName);
        int count = sysUserService.count(qw);
        return count > 0;
    }


    /*
     * 后台注册
     * */
    @RequestMapping("/register")
    public String register(@Param("loginName") String loginName, @Param("password") String password) {
        if(check(loginName))return "error";
        SysUser systemUser = new SysUser();
        systemUser.setLoginName(loginName);
        systemUser.setName(loginName);
        systemUser.setPassword(MD5Util.getMD5(password));
        boolean result = sysUserService.save(systemUser);
        if (result) {
            return "index";
        } else {
            return "error";
        }
    }

    /*
     * 后台登录
     * */
    @RequestMapping("/login")
    public String login(@Param("loginName") String loginName, @Param("password") String password) {
        QueryWrapper<SysUser> qw = new QueryWrapper<SysUser>();
        qw.eq("login_name", loginName);
        SysUser systemUser = sysUserService.getOne(qw);
        if (systemUser.getPassword().equals(MD5Util.getMD5(password))) {
            return "index";
        } else {
            return "error";
        }
    }
}

