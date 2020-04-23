package com.lila.baotuan.controller;


import com.lila.baotuan.entity.Result;
import com.lila.baotuan.service.impl.PayImgServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 支付图片 前端控制器
 * </p>
 *
 * @author Zhang
 * @since 2020-04-23
 */
@RestController
@RequestMapping("/baotuan/payImg")
public class PayImgController {

    @Resource
    private PayImgServiceImpl payImgService;

    @RequestMapping("/addPayImg")
    public Result addPayImg(HttpServletRequest request) {
        String url = request.getParameter("url");
        String description = request.getParameter("description");
        Result result = new Result();
        result.setData(payImgService.addPayImg(url, description));
        result.setMsg("添加成功");
        result.setCode(true);
        return result;
    }

    @RequestMapping("/delPayImg")
    public Result delPayImg(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id"));
        Result result = new Result();
        result.setData(payImgService.delPayImgById(id));
        result.setMsg("删除成功");
        result.setCode(true);
        return result;
    }

    @RequestMapping("/enabled")
    public Result enabled(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id"));
        Result result = new Result();
        result.setData(payImgService.enabled(id));
        result.setMsg("已启用");
        result.setCode(true);
        return result;
    }

    @RequestMapping("/getPayImgList")
    public Result getPayImgList(HttpServletRequest request) {
        int page = Integer.valueOf(request.getParameter("page"));
        int limit = Integer.valueOf(request.getParameter("limit"));
        Result result = new Result();
        result.setData(payImgService.getPayImgList(page, limit));
        result.setMsg("已启用");
        result.setCode(true);
        return result;
    }

    @RequestMapping("/getPayImgByEnabled")
    public Result getPayImgByEnabled(HttpServletRequest request) {
        Result result = new Result();
        result.setData(payImgService.getPayImgByEnabled());
        result.setMsg("获取成功");
        result.setCode(true);
        return result;
    }

}

