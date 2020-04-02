package com.lila.baotuan.controller;


import com.lila.baotuan.entity.Member;
import com.lila.baotuan.entity.Result;
import com.lila.baotuan.service.impl.MemberServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 会员 前端控制器
 * </p>
 *
 * @author Zhang
 * @since 2020-03-28
 */
@Controller
@RequestMapping("/baotuan/member")
public class MemberController {

    @Resource
    private MemberServiceImpl memberService;

    @RequestMapping("/memberList")
    @ResponseBody
    public Result getMemberList() {
        Result result = new Result();
        List<Member> list = memberService.getMemberList();
        result.setData(list);
        result.setMsg("获取成功");
        result.setCode(true);
        return result;
    }

}

