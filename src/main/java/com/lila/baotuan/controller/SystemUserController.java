package com.lila.baotuan.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.lila.baotuan.entity.SystemUser;
import com.lila.baotuan.service.impl.SystemUserServiceImpl;
import com.lila.baotuan.tools.MD5Util;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 后台用户 前端控制器
 * </p>
 *
 * @author Zhang
 * @since 2020-03-25
 */
@Controller
@RequestMapping("/baotuan/systemUser")
public class SystemUserController {

    @Autowired
    private SystemUserServiceImpl systemUserService;

    /*
     * 检验用户重复
     * */
    @RequestMapping("/check")
    @ResponseBody
    public boolean check(@Param("loginName") String loginName) {
        EntityWrapper<SystemUser> ew = new EntityWrapper<SystemUser>();
        ew.eq("login_name", loginName);
        int count = systemUserService.selectCount(ew);
        return count > 0;
    }


    /*
     * 后台注册
     * */
    @RequestMapping("/register")
    public String register(@Param("loginName") String loginName, @Param("password") String password) {
        if(check(loginName))return "error";
        SystemUser systemUser = new SystemUser();
        systemUser.setLoginName(loginName);
        systemUser.setName(loginName);
        systemUser.setPassword(MD5Util.getMD5(password));
        boolean result = systemUserService.insert(systemUser);
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
        Wrapper<SystemUser> ew = new EntityWrapper<SystemUser>();
        ew.eq("login_name", loginName);
        SystemUser systemUser = systemUserService.selectOne(ew);
        if (systemUser.getPassword().equals(MD5Util.getMD5(password))) {
            return "index";
        } else {
            return "error";
        }
    }
}
