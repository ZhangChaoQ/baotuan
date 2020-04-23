package com.lila.baotuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lila.baotuan.entity.User;
import com.lila.baotuan.mapper.UserMapper;
import com.lila.baotuan.service.IUserService;
import com.lila.baotuan.utils.MD5Util;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author Zhang
 * @since 2020-04-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    /*
     * 修改会员等级
     * */
    public int updateMember(int id, int memberId) {
        User user = getUserById(id);
        return baseMapper.update(user, new UpdateWrapper<User>().set("member_id", memberId).eq("id", user.getId()));
    }

    /*
     * 修改余额
     * */
    public int updateMoney(int id, double money) {
        User user = getUserById(id);
        return baseMapper.update(user, new UpdateWrapper<User>().set("money", user.getMoney() + money).eq("id", user.getId()));
    }

    /*
     * 根据id获取用户
     * */
    public User getUserById(int id) {
        return baseMapper.selectOne(new QueryWrapper<User>().eq("id", id));
    }

    /*
     * 获取邀请码数量
     * */
    public int getCountByInviteCode(String inviteCode) {
        return baseMapper.selectCount(new QueryWrapper<User>().eq("invite_code", inviteCode));
    }

    /*
     * 根据手机号获取数量
     * */
    public int getCountByPhone(String phone) {
        return baseMapper.selectCount(new QueryWrapper<User>().eq("phone", phone));
    }

    /*
     * 根据code获取数量
     * */
    public int getCountByCode(String code) {
        return baseMapper.selectCount(new QueryWrapper<User>().like("code", "%-" + code + "-%"));
    }

    /*
     * 根据user_id获取用户数量
     * */
    public int getCountByUserId(int userId) {
        return baseMapper.selectCount(new QueryWrapper<User>().eq("user_id", userId));
    }

    /*
     * 根据invite_code获取用户数量
     * */
    public User getUserByInviteCode(String inviteCode) {
        return baseMapper.selectOne(new QueryWrapper<User>().eq("invite_code", inviteCode));
    }

    /*
     * 注册
     * */
    public int insertUser(String password, String code, String inviteCode, String phone, int userId) {
        User user = new User();
        user.setPassword(MD5Util.MD5Encode(password, "UTF-8"));
        user.setCode(code);
        user.setEnabled(true);
        user.setInviteCode(inviteCode);
        user.setPhone(phone);
        user.setName(phone);
        user.setMemberId(1);
        user.setUserId(userId);
        user.setCreatetime(LocalDateTime.now());
        baseMapper.insert(user);
        return user.getId();
    }

    /*
     * 綁定支付宝
     * */
    public User updateAlipay(int id, String alipayAccount, int alipayUrl, String alipayName) {
        User user = getUserById(id);
        baseMapper.update(user, new UpdateWrapper<User>().set("Alipay_account", alipayAccount).set("Alipay_url", alipayUrl).set("Alipay_name", alipayName).eq("id", user.getId()));
        return user;
    }

    /*
     * 修改名称
     * */
    public int updateName(int id, String name) {
        User user = getUserById(id);
        return baseMapper.update(user, new UpdateWrapper<User>().set("name", name).eq("id", user.getId()));
    }

    /*
     * 添加用户
     * */
    public int insertUser(User user) {
        baseMapper.insert(user);
        return user.getId();
    }

    /*
     * 禁用
     * */
    public int enabledUser(int id) {
        User user = getUserById(id);
        return baseMapper.update(user, new UpdateWrapper<User>().set("enabled", false).eq("id", id));
    }

    /*
     * 启用
     * */
    public int enableUser(int id) {
        User user = getUserById(id);
        return baseMapper.update(user, new UpdateWrapper<User>().set("enabled", true).eq("id", id));
    }

    public boolean checkAlipay(int id) {
        int count = baseMapper.selectCount(new QueryWrapper<User>().eq("id", id).isNull("Alipay_url"));
        return count == 0;
    }

    public boolean getAliPayCount(String alipayAccount, String alipayName) {
        int count = baseMapper.selectCount(new QueryWrapper<User>().eq("Alipay_account", alipayAccount).eq("Alipay_name", alipayName));
        return count == 0;
    }

    public boolean getUserEnabled(int id) {
        return baseMapper.selectOne(new QueryWrapper<User>().eq("id", id)).getEnabled();
    }

    public int uploadPasswordByPhone(String phone, String password) {
        User user = getUserByPhone(phone);
        baseMapper.update(user, new UpdateWrapper<User>().set("password", MD5Util.MD5Encode(password, "UTF-8")).eq("id",user.getId()));
        return user.getId();
    }

    private User getUserByPhone(String phone) {
        return baseMapper.selectOne(new QueryWrapper<User>().eq("phone", phone));
    }
}
