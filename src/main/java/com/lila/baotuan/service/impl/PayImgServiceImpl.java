package com.lila.baotuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lila.baotuan.entity.PayImg;
import com.lila.baotuan.mapper.PayImgMapper;
import com.lila.baotuan.service.IPayImgService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 支付图片 服务实现类
 * </p>
 *
 * @author Zhang
 * @since 2020-04-23
 */
@Service
public class PayImgServiceImpl extends ServiceImpl<PayImgMapper, PayImg> implements IPayImgService {

    public PayImg getPayImgByEnabled(){
        return baseMapper.selectOne(new QueryWrapper<PayImg>().eq("enabled",1));
    }
    public int addPayImg(String url, String description) {
        PayImg payImg = new PayImg();
        payImg.setDescription(description);
        payImg.setEnabled(false);
        int count = getCount();
        if (count == 0) payImg.setEnabled(true);
        else payImg.setEnabled(false);
        payImg.setUrl(url);
        baseMapper.insert(payImg);
        return payImg.getId();
    }

    public int enabled(int id) {
        PayImg payImg = getPayImgById(id);
        baseMapper.update(null, new UpdateWrapper<PayImg>().set("enabled", 0));
        return baseMapper.update(payImg, new UpdateWrapper<PayImg>().set("enabled", 1).eq("id", id));
    }

    public PayImg getPayImgById(int id) {
        return baseMapper.selectById(id);
    }

    public int delPayImgById(int id) {
        return baseMapper.deleteById(id);
    }

    public Page<PayImg> getPayImgList(int page, int limit) {
        return baseMapper.selectPage(new Page<>(page, limit), new QueryWrapper<PayImg>());
    }

    public int getCount() {
        return baseMapper.selectCount(new QueryWrapper<PayImg>().eq("enabled", 1));
    }
}
