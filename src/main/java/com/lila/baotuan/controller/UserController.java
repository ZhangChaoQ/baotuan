package com.lila.baotuan.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lila.baotuan.entity.Member;
import com.lila.baotuan.entity.User;
import com.lila.baotuan.mapper.UserMapper;
import com.lila.baotuan.service.impl.MemberServiceImpl;
import com.lila.baotuan.service.impl.UserServiceImpl;
import com.lila.baotuan.tools.MD5Util;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

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
    @Resource
    private UserServiceImpl userService;
    @Resource
    private BrokeragesController brokeragesController;
    @Resource
    private MemberServiceImpl memberService;

    /*
     * 修改会员等级
     * */
    public boolean updateMember(@Param("memberId") int memberId, @Param("id") int id) {
        QueryWrapper<Member> qw = new QueryWrapper<>();
        qw.eq("id", memberId);
        Member member = memberService.getOne(qw);
        UpdateWrapper<User> uw = new UpdateWrapper<>();
        uw.set("member_id", memberId);
        uw.eq("id", id);
        boolean result = userService.update(uw);//修改会员等级
        QueryWrapper<User> qwUser = new QueryWrapper<>();
        qwUser.eq("id", id);
        User user = userService.getOne(qwUser);
        if (result) {
            updateMoney(member.getMoney() * 0.2, user.getUserId());//修改上级分佣
            brokeragesController.addInvite(user.getUserId(), member.getMoney() * 0.2);//添加分佣记录
        }
        qwUser.clear();
        qwUser.eq("id", user.getUserId());
        User inviter = userService.getOne(qwUser);//上级
        if (result) {
            updateMoney(member.getMoney() * 0.05, inviter.getUserId());//修改上级分佣
            brokeragesController.addInvite(inviter.getUserId(), member.getMoney() * 0.05);//添加分佣记录
        }

        return result;
    }

    /*
     * 修改余额
     * */
    public boolean updateMoney(@Param("money") double money, @Param("id") int id) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("id", id);
        User user = userService.getOne(qw);
        UpdateWrapper<User> uw = new UpdateWrapper<>();
        uw.set("money", user.getMoney() + money);
        uw.eq("id", id);
        boolean result = userService.update(uw);
        return result;
    }

    /*
     * 检验用户重复
     * */
    @RequestMapping("/check")
    @ResponseBody
    public boolean check(@Param("loginName") String loginName) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("login_name", loginName);
        int count = userService.count(qw);
        return count > 0;
    }

    /*
     * 检验用户邀请码
     * */
    @RequestMapping("/checkInviteCode")
    @ResponseBody
    public boolean checkInviteCode(@Param("inviteCode") String inviteCode) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("invite_code", inviteCode);
        int count = userService.count(qw);
        return count > 0;
    }

    /*
     * 注册
     * */
    @RequestMapping("/register")
    public String register(@Param("loginName") String loginName, @Param("password") String password, @Param("inviteCode") String inviteCode) {
        if (!check(loginName)) return "error";//用户名重复
        if (!checkInviteCode(inviteCode)) return "error";//邀请码不存在
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("invite_code", inviteCode);
        User inviter = userService.getOne(qw);

        User user = new User();
        user.setEnabled(true);
        user.setInviteCode(getInviteCode());
        user.setPassword(MD5Util.getMD5(password));
        user.setPhone(loginName);
        user.setCode(getUserCode(inviter));
        user.setUserId(inviter.getId());
        boolean result = userService.save(user);
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
    public String login(@Param("phone") String phone, @Param("password") String password) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("phone", phone);
        User user = userService.getOne(qw);
        if (!user.getEnabled()) return "error";
        if (user.getPassword().equals(MD5Util.getMD5(password))) {
            return "index";
        } else {
            return "error";
        }
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
     * 获取个人编码 userCode
     * 编码规则
     * 上级字母号-用户字母号-用户在当前字母号中的个数
     * 例：最初号码 ：0-0A-00001
     *       下级：0A1-0B-00001
     *           下级：0B1-0C-00001
     *       下级：0A1-0B-00002
     *           下级：0B2-0C-00001
     * 例：最初号码 ：0-0Z-00001
     *       下级：0Z1-1A-00001
     *           下级：1A1-1B-00001
     *       下级：0Z1-1A-00002
     *           下级：1A2-1B-00001
     * */

    public String getUserCode(User user) {
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
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("user_id", user.getId());
        String count = userService.count() + 1 + "";
        for (int i = count.length(); i < 5; i++) {
            count = "0" + count;
        }
        return sup + "-" + number + "" + letter + "-" + count;
    }

    /*
     * 获取上级用户
     * */
    public User getUpUser(@Param("id") int id) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("id", id);
        User user = userService.getOne(qw);
        return user;
    }

    /*
     * 修改密码
     * */
    public String updatePassword(@Param("id") int id, @Param("password") String password, @Param("newPassword") String newPassword) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("id", id);
        User user = userService.getOne(qw);
        if (user.getPassword().equals(MD5Util.getMD5(password))) {
            UpdateWrapper<User> uw = new UpdateWrapper<>();
            uw.set("password", MD5Util.getMD5(newPassword));
            uw.eq("id", id);
            boolean result = userService.update(uw);
            if (result) return "index";
            else return "error";
        } else {
            return "error";
        }

    }
}
