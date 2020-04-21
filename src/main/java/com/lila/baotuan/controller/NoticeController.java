package com.lila.baotuan.controller;


import com.lila.baotuan.entity.Result;
import com.lila.baotuan.service.impl.NoticeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 公告 前端控制器
 * </p>
 *
 * @author Zhang
 * @since 2020-03-28
 */
@Controller
@RequestMapping("/baotuan/notice")
public class NoticeController {

    @Resource
    private NoticeServiceImpl noticeService;

    @RequestMapping("/getNoticeList")
    @ResponseBody
    public Result getNoticeList() {
        Result result = new Result();
        result.setCode(true);
        result.setMsg("获取成功");
        result.setData(noticeService.getNoticeList());
        return result;
    }
    @RequestMapping("/getPageNoticeList")
    @ResponseBody
    public Result getNoticeList(HttpServletRequest request) {
        int page=Integer.valueOf(request.getParameter("page"));
        int limit=Integer.valueOf(request.getParameter("limit"));
        Result result = new Result();
        result.setCode(true);
        result.setMsg("获取成功");
        result.setData(noticeService.getPageNoticeList(page,limit));
        return result;
    }

    @RequestMapping("/getNotice")
    @ResponseBody
    public Result getNotice(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id"));
        Result result = new Result();
        result.setCode(true);
        result.setMsg("获取成功");
        result.setData(noticeService.getNoticeById(id));
        return result;
    }

    @RequestMapping("/insertNotice")
    @ResponseBody
    public Result insertNotice(HttpServletRequest request) {
        String title = request.getParameter("title");
        String context = request.getParameter("context");
        Result result = new Result();
        result.setCode(true);
        result.setMsg("添加成功");
        result.setData(noticeService.insertNotice(title, context));
        return result;
    }

    @RequestMapping("/deleteNotice")
    @ResponseBody
    public Result deleteNotice(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id"));
        Result result = new Result();
        result.setCode(true);
        result.setMsg("删除成功");
        result.setData(noticeService.deleteNoticeById(id));
        return result;
    }

    @RequestMapping("/updateEnabled")
    @ResponseBody
    public Result updateEnabled(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id"));
        Result result = new Result();
        result.setCode(true);
        result.setMsg("发布成功");
        result.setData(noticeService.updateEnabled(id));
        return result;
    }

    @RequestMapping("/updateNotice")
    @ResponseBody
    public Result updateNotice(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id"));
        String title = request.getParameter("title");
        String context = request.getParameter("context");
        Result result = new Result();
        result.setCode(true);
        result.setMsg("修改成功");
        result.setData(noticeService.updateNoticeById(id, title, context));
        return result;
    }
}

