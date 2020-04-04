package com.lila.baotuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lila.baotuan.entity.Notice;
import com.lila.baotuan.mapper.NoticeMapper;
import com.lila.baotuan.service.INoticeService;
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
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements INoticeService {

    /*
     * 添加公告
     * */
    public int insertNotice(String title, String context) {
        Notice notice = new Notice();
        notice.setContext(context);
        notice.setCreatetime(LocalDateTime.now());
        notice.setTitle(title);
        baseMapper.insert(notice);
        return notice.getId();
    }

    /*
     * 获取公告列表
     * */
    public List<Notice> getNoticList() {
        return baseMapper.selectList(new QueryWrapper<>());
    }

    /*
     * 删除公告
     * */
    public void deleteNoticeById(int id) {
        baseMapper.deleteById(id);
    }

    public Notice getNoticeById(int id) {
        return baseMapper.selectById(id);
    }
}
