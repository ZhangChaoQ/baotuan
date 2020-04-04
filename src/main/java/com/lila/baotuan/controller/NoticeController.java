package com.lila.baotuan.controller;


import com.alibaba.fastjson.JSONObject;
import com.lila.baotuan.entity.Result;
import com.lila.baotuan.service.impl.NoticeServiceImpl;
import com.lila.baotuan.utils.ServiceUtil;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
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
        result.setData(noticeService.getNoticList());
        return result;
    }

    @RequestMapping("/getNotice")
    @ResponseBody
    public Result getNotice(HttpServletRequest request) {
        JSONObject jData = ServiceUtil.getJsonData(request);
        int id = jData.getInteger("id");
        Result result = new Result();
        result.setCode(true);
        result.setMsg("获取成功");
        result.setData(noticeService.getNoticeById(id));
        return result;
    }
}

