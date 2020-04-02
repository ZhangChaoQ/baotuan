package com.lila.baotuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lila.baotuan.entity.Brokerages;
import com.lila.baotuan.mapper.BrokeragesMapper;
import com.lila.baotuan.service.IBrokeragesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 金额记录 服务实现类
 * </p>
 *
 * @author Zhang
 * @since 2020-03-28
 */
@Service
public class BrokeragesServiceImpl extends ServiceImpl<BrokeragesMapper, Brokerages> implements IBrokeragesService {

    /*
     * 根据用户id和类型查询记录
     * 视图查询
     * */
    public List<Brokerages> getListByUserIdAndBrokerageType(int userId, int brokerageTypeId) {
        return baseMapper.selectList(new QueryWrapper<Brokerages>().eq("user_id", userId).eq("brokerage_type_id", brokerageTypeId));
    }

    /*
     * 添加提款记录
     * id:用戶id
     * money:提现金额
     * */
    public int insertWithdraw(@Param("id") int id, @Param("money") double money) {
        Brokerages brokerages = new Brokerages();
        brokerages.setUserId(id);
        brokerages.setMoney(money);
        brokerages.setCreatetime(LocalDateTime.now());
        brokerages.setBrokeragesTypeId(0);
        baseMapper.insert(brokerages);
        return brokerages.getId();

    }

    /*
     * 添加分佣奖励记录
     * */
    public int insertBrokerage(@Param("id") int id, @Param("money") double money) {
        Brokerages brokerages = new Brokerages();
        brokerages.setUserId(id);
        brokerages.setMoney(money);
        brokerages.setCreatetime(LocalDateTime.now());
        brokerages.setBrokeragesTypeId(2);
        baseMapper.insert(brokerages);
        return brokerages.getId();
    }

    /*
     * 添加邀请奖励记录
     * */
    public int insertInvite(@Param("id") int id, @Param("money") double money) {
        Brokerages brokerages = new Brokerages();
        brokerages.setUserId(id);
        brokerages.setMoney(money);
        brokerages.setCreatetime(LocalDateTime.now());
        brokerages.setBrokeragesTypeId(2);
        baseMapper.insert(brokerages);
        return brokerages.getId();
    }

    /*
     * 添加任务奖励记录
     * */
    public int insertTask(@Param("id") int id, @Param("money") double money) {
        Brokerages brokerages = new Brokerages();
        brokerages.setUserId(id);
        brokerages.setMoney(money);
        brokerages.setCreatetime(LocalDateTime.now());
        brokerages.setBrokeragesTypeId(1);
        baseMapper.insert(brokerages);
        return brokerages.getId();
    }
}
