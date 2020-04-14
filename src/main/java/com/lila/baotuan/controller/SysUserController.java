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
    public Result InsertSysUser(HttpServletRequest request) {
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        SysUser sysUser = sysUserService.userInsert(phone, password);
        Result result = new Result();
        if (null != sysUser) {
            result.setCode(true);
            result.setData(sysUser);
            result.setMsg("添加成功");
        } else {
            result.setCode(false);
            result.setData(null);
            result.setMsg("添加失败");
        }
        return result;
    }

    /*
     * 登录
     * */
    @RequestMapping("/login")
    @ResponseBody
    public Result login(HttpServletRequest request) {
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
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
    @RequestMapping("/getSysUserList")
    @ResponseBody
    public Result getSysUserList(HttpServletRequest request){
        int page=Integer.valueOf(request.getParameter("page"));
        int limit=Integer.valueOf(request.getParameter("limit"));
        Result result=new Result();
        result.setMsg("获取成功");
        result.setData(sysUserService.getSysUserList(page,limit));
        result.setCode(true);
        return result;
    }
}

