package com.lila.baotuan.controller;


import com.lila.baotuan.service.impl.MemberServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * <p>
 * 会员 前端控制器
 * </p>
 *
 * @author Zhang
 * @since 2020-03-26
 */
@Controller
@RequestMapping("/baotuan/member")
public class MemberController {
    @Resource
    private MemberServiceImpl memberService;
    
}

