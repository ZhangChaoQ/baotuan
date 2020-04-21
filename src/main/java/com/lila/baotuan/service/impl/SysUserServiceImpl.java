package com.lila.baotuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lila.baotuan.entity.SysUser;
import com.lila.baotuan.entity.User;
import com.lila.baotuan.mapper.SysUserMapper;
import com.lila.baotuan.service.ISysUserService;
import com.lila.baotuan.utils.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

/**
 * <p>
 * 后台用户 服务实现类
 * </p>
 *
 * @author Zhang
 * @since 2020-04-14
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Resource
    private UserServiceImpl userService;

    /*
     * 后台注册
     * 注册同时生成前台账号
     * */
    public SysUser userInsert(String phone, String password) {
        SysUser sysUser = new SysUser();
        sysUser.setLoginName(phone);
        sysUser.setName(phone);
        sysUser.setPassword(MD5Util.MD5Encode(password, "UTF-8"));
        baseMapper.insert(sysUser);
        User user = new User();
        user.setUserId(-1);
        user.setName(phone);
        user.setPassword(MD5Util.MD5Encode(password, "UTF-8"));
        String count = userService.getCountByUserId(-1)+1 + "";
        for (int i = count.length(); i < 5; i++) {
            count = "0" + count;
        }
        user.setMemberId(1);
        user.setPhone(phone);
        user.setCode("0-0A-" + count);
        user.setEnabled(true);
        user.setInviteCode(getInviteCode());
        userService.insertUser(user);
        return sysUser;
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


    public boolean checkInviteCode(String inviteCode) {
        return userService.getCountByInviteCode(inviteCode) > 0;
    }

    /*
     * 后台登录
     * */
    public SysUser login(String phone, String password) {
        return baseMapper.selectOne(new QueryWrapper<SysUser>().eq("login_name", phone).eq("password", MD5Util.MD5Encode(password, "UTF-8")));
    }

    public Page<SysUser> getSysUserList(int page, int limit) {
        return baseMapper.selectPage(new Page<>(page, limit), new QueryWrapper<SysUser>().orderByDesc("id"));
    }
}
