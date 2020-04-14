package com.lila.baotuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lila.baotuan.entity.Member;
import com.lila.baotuan.mapper.MemberMapper;
import com.lila.baotuan.service.IMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 会员 服务实现类
 * </p>
 *
 * @author Zhang
 * @since 2020-04-14
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements IMemberService {
    /*
     * 根据id获取会员信息
     * */
    public Member getMemberById(int id) {
        return baseMapper.selectOne(new QueryWrapper<Member>().eq("id", id));
    }

    public List<Member> getMemberList() {
        return baseMapper.selectList(new QueryWrapper<Member>().ne("id", 1));
    }
}
