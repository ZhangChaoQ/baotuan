package com.lila.baotuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lila.baotuan.entity.PayInfo;
import com.lila.baotuan.mapper.PayInfoMapper;
import com.lila.baotuan.service.IPayInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Zhang
 * @since 2020-04-23
 */
@Service
public class PayInfoServiceImpl extends ServiceImpl<PayInfoMapper, PayInfo> implements IPayInfoService {

    public int insertPayInfo(int userId, int payMoney, String payCode) {
        PayInfo payinfo = new PayInfo();
        payinfo.setCreatetime(LocalDateTime.now());
        payinfo.setPayCode(payCode);
        payinfo.setPayStatusId(1);
        payinfo.setUserId(userId);
        payinfo.setPayMoney(Double.valueOf(payMoney));
        baseMapper.insert(payinfo);
        return payinfo.getId();
    }

    public PayInfo getPayInfoById(int id) {
        return baseMapper.selectById(id);
    }

    public int updatePayInfoStatusFail(int id, String reason) {
        PayInfo payinfo = getPayInfoById(id);
        return baseMapper.update(payinfo, new UpdateWrapper<PayInfo>().set("pay_status_id", 3).set("reason", reason).eq("id", id));
    }

    public int updatePayInfoStatusSuccess(PayInfo payinfo) {
        return baseMapper.update(payinfo, new UpdateWrapper<PayInfo>().set("pay_status_id", 2).set("reason", "审核通过").eq("id", payinfo.getId()));
    }

    public Page<PayInfo> getPayInfoList(int page, int limit) {
        return baseMapper.selectPage(new Page<PayInfo>(page, limit), new QueryWrapper<PayInfo>().eq("pay_status_id", 1));
    }

    public List<PayInfo> getPayInfoListByUserId(int userId) {
        return baseMapper.selectList(new QueryWrapper<PayInfo>().eq("user_id", userId).orderByDesc("createtime"));
    }
}
