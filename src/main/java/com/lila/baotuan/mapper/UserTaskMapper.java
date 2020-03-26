package com.lila.baotuan.mapper;

import com.lila.baotuan.entity.UserTask;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户任务记录 Mapper 接口
 * </p>
 *
 * @author Zhang
 * @since 2020-03-26
 */
@Mapper
public interface UserTaskMapper extends BaseMapper<UserTask> {

}
