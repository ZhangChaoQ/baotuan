package com.lila.baotuan.mapper;

import com.lila.baotuan.entity.Task;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
  * 任务 Mapper 接口
 * </p>
 *
 * @author Zhang
 * @since 2020-03-25
 */
@Mapper
public interface TaskMapper extends BaseMapper<Task> {

}