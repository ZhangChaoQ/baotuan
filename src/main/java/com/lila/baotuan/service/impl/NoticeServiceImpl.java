package com.lila.baotuan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
 * @since 2020-04-14
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
    public List<Notice> getNoticeList() {
        return baseMapper.selectList(new QueryWrapper<>());
    }

    /*
     * 获取公告列表
     * */
    public Page<Notice> getPageNoticeList(int page, int limit) {
        return baseMapper.selectPage(new Page<Notice>(page, limit), new QueryWrapper<Notice>());
    }

    /*
     * 删除公告
     * */
    public int deleteNoticeById(int id) {
        return baseMapper.deleteById(id);
    }

    public Notice getNoticeById(int id) {
        return baseMapper.selectById(id);
    }

    public int updateNoticeById(int id, String title, String context) {
        Notice notice = getNoticeById(id);
        return baseMapper.update(notice, new UpdateWrapper<Notice>().set("title", title).set("context", context).eq("id", id));
    }

    public int updateEnabled(int id) {
        Notice notice = getNoticeById(id);
        return baseMapper.update(notice, new UpdateWrapper<Notice>().set("enabled", 1).eq("id", id));
    }
}
