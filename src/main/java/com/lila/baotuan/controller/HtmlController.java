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

    @RequestMapping("/user-list")
    public String userList() {
        return "user-list";
    }

    @RequestMapping("/user-withdrawals")
    public String userWithdrawals() {
        return "user-withdrawals";
    }

    @RequestMapping("/sysUser")
    public String sysUser() {
        return "sysUser";
    }

    @RequestMapping("/main-user")
    public String main() {
        return "main-user";
    }


    @RequestMapping("/main-in")
    public String mainIn() {
        return "main-in";
    }

    @RequestMapping("/main-out")
    public String mainOut() {
        return "main-out";
    }

}
