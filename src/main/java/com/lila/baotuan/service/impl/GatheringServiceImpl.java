package com.lila.baotuan.service.impl;

import com.lila.baotuan.entity.Gathering;
import com.lila.baotuan.mapper.GatheringMapper;
import com.lila.baotuan.service.IGatheringService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 收款记录 服务实现类
 * </p>
 *
 * @author Zhang
 * @since 2020-03-28
 */
@Service
public class GatheringServiceImpl extends ServiceImpl<GatheringMapper, Gathering> implements IGatheringService {


    /*
     * 添加记录
     * */
    public int insertGathering(int userId, double money) {
        Gathering gathering = new Gathering();
        gathering.setUserId(userId);
        gathering.setMoney(money);
        gathering.setCreatetime(LocalDateTime.now());
        gathering.setOvertime(LocalDateTime.now());
        baseMapper.insert(gathering);
        return gathering.getId();
    }
}
