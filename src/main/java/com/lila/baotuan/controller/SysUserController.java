package com.lila.baotuan.controller;


import com.lila.baotuan.entity.SysUser;
import com.lila.baotuan.service.impl.SysUserServiceImpl;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * <p>
 * 后台用户 前端控制器
 * </p>
 *
 * @author Zhang
 * @since 2020-03-28
 */
@Controller
@RequestMapping("/baotuan/sysUser")
public class SysUserController {

    @Resource
    private SysUserServiceImpl sysUserService;

    /*
     * 注册
     * */
    public String InsertSysUser(Model model, String phone, String password) {
        SysUser sysUser = sysUserService.userInsert(phone, password);
        model.addAttribute("sysUser", sysUser);
        return "index";
    }
    /*
     * 登录
     * */
}

