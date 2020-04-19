package com.lila.baotuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lila.baotuan.entity.SysBrokerages;
import com.lila.baotuan.mapper.SysBrokeragesMapper;
import com.lila.baotuan.service.ISysBrokeragesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 金额记录 服务实现类
 * </p>
 *
 * @author Zhang
 * @since 2020-04-14
 */
@Service
public class SysBrokeragesServiceImpl extends ServiceImpl<SysBrokeragesMapper, SysBrokerages> implements ISysBrokeragesService {

    public SysBrokerages getSysBrokeragesById(int id) {
        return baseMapper.selectOne(new QueryWrapper<SysBrokerages>().eq("id", id));
    }

    public SysBrokerages paidById(int id) {
        SysBrokerages sysBrokerages = getSysBrokeragesById(id);
        baseMapper.update(sysBrokerages, new UpdateWrapper<SysBrokerages>().set("sys_brokerages_status_id", 2).eq("id", id));
        return sysBrokerages;
    }

    public SysBrokerages failedById(int id) {
        SysBrokerages sysBrokerages = getSysBrokeragesById(id);
        baseMapper.update(sysBrokerages, new UpdateWrapper<SysBrokerages>().set("sys_brokerages_status_id", 3).eq("id", id));
        return sysBrokerages;
    }

    public int insertSysBrokerages(int id, double money, int brokerageId) {
        SysBrokerages sysBrokerages = new SysBrokerages();
        sysBrokerages.setBrokerageId(brokerageId);
        sysBrokerages.setCreatetime(LocalDateTime.now());
        sysBrokerages.setMoney(money);
        sysBrokerages.setPayMoney(money * 0.7);
        sysBrokerages.setUserId(id);
        sysBrokerages.setSysBrokeragesStatusId(1);
        baseMapper.insert(sysBrokerages);
        return sysBrokerages.getId();
    }
}
