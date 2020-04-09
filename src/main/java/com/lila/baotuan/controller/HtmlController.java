package com.lila.baotuan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlController {
    @RequestMapping("/")
    public String login() {
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/reset")
    public String reset() {
        return "reset";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/task")
    public String task() {
        return "task";
    }

    @RequestMapping("/withdrawals")
    public String withdrawals() {
        return "withdrawals";
    }

    @RequestMapping("/user")
    public String user() {
        return "user";
    }

    @RequestMapping("/sysUser")
    public String sysUser() {
        return "sysUser";
    }

    @RequestMapping("/main")
    public String main() {
        return "main";
    }
}
