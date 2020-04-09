package com.lila.baotuan.controller;


import com.alibaba.fastjson.JSONObject;
import com.lila.baotuan.entity.Result;
import com.lila.baotuan.entity.SysUser;
import com.lila.baotuan.service.impl.SysUserServiceImpl;
import com.lila.baotuan.utils.ServiceUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 后台用户 前端控制器
 * </p>
 *
 * @author Zhang
 * @since 2020-03-28
 */
@RestController
@RequestMapping("/baotuan/sysUser")
public class SysUserController {

    @Resource
    private SysUserServiceImpl sysUserService;

    /*
     * 注册
     * */
    @RequestMapping("/addUser")
    public String InsertSysUser(Model model, String phone, String password) {
        SysUser sysUser = sysUserService.userInsert(phone, password);
        model.addAttribute("sysUser", sysUser);
        return "index";
    }

    /*
     * 登录
     * */
    @RequestMapping("/login")
    @ResponseBody
    public Result login(HttpServletRequest request) {
        JSONObject jData = ServiceUtil.getJsonData(request);
        String phone = jData.getString("phone");
        String password = jData.getString("password");
        SysUser sysUser = sysUserService.login(phone, password);
        Result result = new Result();
        if (null != sysUser) {
            result.setCode(true);
            result.setData(sysUser);
            result.setMsg("登陆成功");
        } else {
            result.setCode(false);
            result.setData(null);
            result.setMsg("登录失败，请检查账号或密码是否正确");
        }
        return result;
    }
}

