package com.lila.baotuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lila.baotuan.entity.User;
import com.lila.baotuan.entity.ViewUser;
import com.lila.baotuan.mapper.ViewUserMapper;
import com.lila.baotuan.service.IViewUserService;
import com.lila.baotuan.utils.MD5Util;
import org.springframework.stereotype.Service;

import javax.swing.text.View;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author Zhang
 * @since 2020-03-28
 */
@Service
public class ViewUserServiceImpl extends ServiceImpl<ViewUserMapper, ViewUser> implements IViewUserService {

    /*
     * 返回下级列表
     * */
    public List<ViewUser> getSonList(int id) {
        return baseMapper.selectList(new QueryWrapper<ViewUser>().eq("user_id", id));
    }

    /*
     * 返回子级列表
     * */
    public List<ViewUser> getGrandSonList(int id) {
        List<ViewUser> userList = new ArrayList<>();
        List<ViewUser> users = baseMapper.selectList(new QueryWrapper<ViewUser>().eq("user_id", id));
        for (ViewUser user : users) {
            userList.addAll(baseMapper.selectList(new QueryWrapper<ViewUser>().eq("user_id", user.getId())));
        }
        return userList;
    }

    /*
     * 根据id返回用户信息
     * */
    public ViewUser getViewUserById(int id) {
        return baseMapper.selectOne(new QueryWrapper<ViewUser>().eq("id", id));
    }

    /*
     * 根据会员id返回用户列表
     * */
    public List<ViewUser> getViewUserByMemberId(int memberId) {
        return baseMapper.selectList(new QueryWrapper<ViewUser>().eq("member_id", memberId));
    }

    /*
     * 根据用户id返回用户子集
     * */
    public List<ViewUser> getViewUserByUserId(int userId) {
        return baseMapper.selectList(new QueryWrapper<ViewUser>().eq("user_id", userId));
    }

    /*
     * 根据用户ids返回用户子集
     * */
    public List<ViewUser> getViewUserByUserIds(Collection<Integer> userIds) {
        return baseMapper.selectList(new QueryWrapper<ViewUser>().in("user_id", userIds));
    }

    public ViewUser userLogin(String phone, String password) {
        return baseMapper.selectOne(new QueryWrapper<ViewUser>().eq("phone", phone).eq("password", MD5Util.MD5Encode(password, "UTF-8")));
    }

    public Page<ViewUser> getViewUserList(int page,int pageSize) {
        return baseMapper.selectPage(new Page<>(page,pageSize),new QueryWrapper<ViewUser>().orderByDesc("createtime").orderByDesc("createtime"));
    }

    public List<ViewUser> getViewUserCountByDay() {
        return baseMapper.selectList(new QueryWrapper<ViewUser>().select("count(*) as number", "date_format(createtime,'%Y-%m-%d') as createtime").groupBy("date_format(createtime,'%Y-%m-%d')").eq("date_format(createtime,'%m')", LocalDateTime.now().getMonth()));
    }
}
