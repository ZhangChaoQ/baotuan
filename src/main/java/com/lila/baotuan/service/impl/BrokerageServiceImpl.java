package com.lila.baotuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lila.baotuan.entity.Brokerage;
import com.lila.baotuan.mapper.BrokerageMapper;
import com.lila.baotuan.service.IBrokerageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 余额记录 服务实现类
 * </p>
 *
 * @author Zhang
 * @since 2020-04-14
 */
@Service
public class BrokerageServiceImpl extends ServiceImpl<BrokerageMapper, Brokerage> implements IBrokerageService {
    /*
     * 根据用户id和类型查询记录
     * 视图查询
     * */
    public List<Brokerage> getListByUserIdAndBrokerageType(int userId, int brokerageTypeId) {
        return baseMapper.selectList(new QueryWrapper<Brokerage>().eq("user_id", userId).eq("brokerage_type_id", brokerageTypeId));
    }

    /*
     * 添加提款记录
     * id:用戶id
     * money:提现金额
     * */
    public int insertWithdraw(int id,double money) {
        Brokerage Brokerage = new Brokerage();
        Brokerage.setUserId(id);
        Brokerage.setMoney(money);
        Brokerage.setCreatetime(LocalDateTime.now());
        Brokerage.setBrokerageTypeId(1);
        baseMapper.insert(Brokerage);
        return Brokerage.getId();

    }

    /*
     * 添加分佣奖励记录
     * */
    public int insertBrokerage(int id,double money) {
        Brokerage Brokerage = new Brokerage();
        Brokerage.setUserId(id);
        Brokerage.setMoney(money);
        Brokerage.setCreatetime(LocalDateTime.now());
        Brokerage.setBrokerageTypeId(2);
        baseMapper.insert(Brokerage);
        return Brokerage.getId();
    }

    /*
     * 添加邀请奖励记录
     * */
    public int insertInvite(int id,double money) {
        Brokerage Brokerage = new Brokerage();
        Brokerage.setUserId(id);
        Brokerage.setMoney(money);
        Brokerage.setCreatetime(LocalDateTime.now());
        Brokerage.setBrokerageTypeId(3);
        baseMapper.insert(Brokerage);
        return Brokerage.getId();
    }

    /*
     * 添加任务奖励记录
     * */
    public int insertTask(int id,double money) {
        Brokerage Brokerage = new Brokerage();
        Brokerage.setUserId(id);
        Brokerage.setMoney(money);
        Brokerage.setCreatetime(LocalDateTime.now());
        Brokerage.setBrokerageTypeId(4);
        baseMapper.insert(Brokerage);
        return Brokerage.getId();
    }
}
