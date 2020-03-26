package com.lila.baotuan.mapper;

import com.lila.baotuan.entity.Member;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 会员 Mapper 接口
 * </p>
 *
 * @author Zhang
 * @since 2020-03-26
 */
@Mapper
public interface MemberMapper extends BaseMapper<Member> {

}
