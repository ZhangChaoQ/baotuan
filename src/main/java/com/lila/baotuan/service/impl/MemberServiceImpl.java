package com.lila.baotuan.service.impl;

import com.lila.baotuan.entity.Member;
import com.lila.baotuan.mapper.MemberMapper;
import com.lila.baotuan.service.IMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员 服务实现类
 * </p>
 *
 * @author Zhang
 * @since 2020-03-27
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements IMemberService {

}
