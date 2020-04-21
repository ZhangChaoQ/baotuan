package com.lila.baotuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lila.baotuan.entity.ViewUser;
import com.lila.baotuan.mapper.ViewUserMapper;
import com.lila.baotuan.service.IViewUserService;
import com.lila.baotuan.utils.MD5Util;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author Zhang
 * @since 2020-04-14
 */
@Service
public class ViewUserServiceImpl extends ServiceImpl<ViewUserMapper, ViewUser> implements IViewUserService {
    /*
     * 返回下级列表
     * */
    public Page<ViewUser> getSonList(int id, int page, int limit) {
        return baseMapper.selectPage(new Page<>(page, limit), new QueryWrapper<ViewUser>().eq("user_id", id));
    }

    /*
     * 返回子级列表
     * */
    public Page<ViewUser> getGrandSonList(int id, int page, int limit) {
        List<Integer> userList = new ArrayList<>();
        List<ViewUser> users = baseMapper.selectList(new QueryWrapper<ViewUser>().eq("user_id", id));
        for (ViewUser user : users) {
            userList.add(user.getUserId());
        }

        return baseMapper.selectPage(new Page<ViewUser>(page, limit), new QueryWrapper<ViewUser>().in("user_id", userList));
    }

    /*
     * 根据id返回用户信息
     * */
    public ViewUser getViewUserById(int id) {
        return baseMapper.selectOne(new QueryWrapper<ViewUser>().eq("id", id));
    }

    public ViewUser userLogin(String phone, String password) {
        return baseMapper.selectOne(new QueryWrapper<ViewUser>().eq("phone", phone).eq("password", MD5Util.MD5Encode(password, "UTF-8")));
    }

    public Page<ViewUser> getViewUserList(int page, int pageSize) {
        return baseMapper.selectPage(new Page<>(page, pageSize), new QueryWrapper<ViewUser>().orderByDesc("createtime").orderByDesc("createtime"));
    }

    public List<ViewUser> getViewUserCountByDay() {
        return baseMapper.selectList(new QueryWrapper<ViewUser>().select("count(*) as number", "date_format(createtime,'%Y-%m-%d') as createtime").groupBy("date_format(createtime,'%Y-%m-%d')").eq("date_format(createtime,'%m')", LocalDateTime.now().getMonth()));
    }

    public ViewUser userLoginByPhone(String phone) {
        return baseMapper.selectOne(new QueryWrapper<ViewUser>().eq("phone", phone));
    }
}
