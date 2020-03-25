package com.lila.baotuan.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.lila.baotuan.entity.User;
import com.lila.baotuan.service.impl.UserServiceImpl;
import com.lila.baotuan.tools.MD5Util;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author Zhang
 * @since 2020-03-25
 */
@Controller
@RequestMapping("/baotuan/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    /*
     * 检验用户重复
     * */
    @RequestMapping("/check")
    @ResponseBody
    public boolean check(@Param("loginName") String loginName) {
        EntityWrapper<User> ew = new EntityWrapper<User>();
        ew.eq("login_name", loginName);
        int count = userService.selectCount(ew);
        return count > 0;
    }

    /*
     * 检验用户邀请码
     * */
    @RequestMapping("/checkInviteCode")
    @ResponseBody
    public boolean checkInviteCode(@Param("inviteCode") String inviteCode) {
        EntityWrapper<User> ew = new EntityWrapper<User>();
        ew.eq("invite_code", inviteCode);
        int count = userService.selectCount(ew);
        return count > 0;
    }

    /*
     * 后台注册
     * */
    @RequestMapping("/register")
    public String register(@Param("loginName") String loginName, @Param("password") String password, @Param("inviteCode") String inviteCode) {
        if (check(loginName)) return "error";
        User user = new User();
        user.setEnabled(1);
        user.setInviteCode(inviteCode);
        user.setPassword(MD5Util.getMD5(password));
        user.setPhone(loginName);
        //user.setUserId();
        boolean result = userService.insert(user);
        if (result) {
            return "index";
        } else {
            return "error";
        }
    }

    /*
     * 前台登录
     * */
    @RequestMapping("/login")
    public String login(@Param("loginName") String loginName, @Param("password") String password) {
        Wrapper<User> em = new EntityWrapper<User>().eq("login_name", loginName);
        User User = userService.selectOne(em);
        if (User.getPassword().equals(MD5Util.getMD5(password))) {
            return "index";
        } else {
            return "error";
        }
    }

}
