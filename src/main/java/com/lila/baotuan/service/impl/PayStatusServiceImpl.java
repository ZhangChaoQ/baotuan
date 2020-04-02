package com.lila.baotuan.service.impl;

import com.lila.baotuan.entity.PayStatus;
import com.lila.baotuan.mapper.PayStatusMapper;
import com.lila.baotuan.service.IPayStatusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 支付状态 服务实现类
 * </p>
 *
 * @author Zhang
 * @since 2020-03-28
 */
@Service
public class PayStatusServiceImpl extends ServiceImpl<PayStatusMapper, PayStatus> implements IPayStatusService {

}
