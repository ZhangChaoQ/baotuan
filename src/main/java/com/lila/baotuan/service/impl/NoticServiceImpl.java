package com.lila.baotuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lila.baotuan.entity.Notic;
import com.lila.baotuan.mapper.NoticMapper;
import com.lila.baotuan.service.INoticService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 公告 服务实现类
 * </p>
 *
 * @author Zhang
 * @since 2020-03-28
 */
@Service
public class NoticServiceImpl extends ServiceImpl<NoticMapper, Notic> implements INoticService {

    /*
     * 添加公告
     * */
    public int insertNotic(String title, String context) {
        Notic notic = new Notic();
        notic.setContext(context);
        notic.setCreatetime(LocalDateTime.now());
        notic.setTitle(title);
        baseMapper.insert(notic);
        return notic.getId();
    }

    /*
     * 获取公告列表
     * */
    public List<Notic> getNoticList() {
        return baseMapper.selectList(new QueryWrapper<>());
    }

    /*
     * 删除公告
     * */
    public void deleteNoticById(int id) {
        baseMapper.deleteById(id);
    }
}
