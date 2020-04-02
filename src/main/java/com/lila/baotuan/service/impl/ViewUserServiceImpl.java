package com.lila.baotuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lila.baotuan.entity.ViewUser;
import com.lila.baotuan.mapper.ViewUserMapper;
import com.lila.baotuan.service.IViewUserService;
import org.springframework.stereotype.Service;

import javax.swing.text.View;
import java.util.Collection;
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

}
