package com.lila.baotuan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlController {
    @RequestMapping("/")
    public String login() {
        return "login";
    }

    @RequestMapping("/login")
    public String login2() {
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

    @RequestMapping("/user-sysBrokerages")
    public String userWithdrawals() {
        return "user-sysBrokerages";
    }

    @RequestMapping("/sys-user")
    public String sysUser() {
        return "sys-user";
    }

    @RequestMapping("/sys-notice")
    public String sysNotice() {
        return "sys-notice";
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


    @RequestMapping("/user-pay")
    public String userPay() {
        return "user-pay";
    }

    @RequestMapping("/sys-payImg")
    public String sysPayImg() {
        return "sys-payImg";
    }

    @RequestMapping("/BaoTuanAppTest/member")
    public String member() {
        return "BaoTuanAppTest/member";
    }

    @RequestMapping("/BaoTuanAppTest/bindAlipay")
    public String bindAlipay() {
        return "BaoTuanAppTest/bindAlipay";
    }

    @RequestMapping("/BaoTuanAppTest/brokerage")
    public String brokerage() {
        return "BaoTuanAppTest/brokerage";
    }

    @RequestMapping("/BaoTuanAppTest/commitTask")
    public String commitTask() {
        return "BaoTuanAppTest/commitTask";
    }

    @RequestMapping("/BaoTuanAppTest/")
    public String applogin() {
        return "BaoTuanAppTest/index";
    }

    @RequestMapping("/BaoTuanAppTest/index")
    public String applogin2() {
        return "BaoTuanAppTest/index";
    }

    @RequestMapping("/BaoTuanAppTest/myInvite")
    public String myInvite() {
        return "BaoTuanAppTest/myInvite";
    }

    @RequestMapping("/BaoTuanAppTest/myTask")
    public String myTask() {
        return "BaoTuanAppTest/myTask";
    }

    @RequestMapping("/BaoTuanAppTest/myTeam")
    public String myTeam() {
        return "BaoTuanAppTest/myTeam";
    }

    @RequestMapping("/BaoTuanAppTest/notic")
    public String notic() {
        return "BaoTuanAppTest/notic";
    }

    @RequestMapping("/BaoTuanAppTest/noticeMassage")
    public String noticMassage() {
        return "BaoTuanAppTest/noticMassage";
    }

    @RequestMapping("/BaoTuanAppTest/pay")
    public String pay() {
        return "BaoTuanAppTest/pay";
    }

    @RequestMapping("/BaoTuanAppTest/register")
    public String appregister() {
        return "BaoTuanAppTest/register";
    }

    @RequestMapping("/BaoTuanAppTest/reset")
    public String appreset() {
        return "BaoTuanAppTest/reset";
    }

    @RequestMapping("/BaoTuanAppTest/task")
    public String apptask() {
        return "BaoTuanAppTest/task";
    }

    @RequestMapping("/BaoTuanAppTest/user")
    public String user() {
        return "BaoTuanAppTest/user";
    }

    @RequestMapping("/BaoTuanAppTest/withdrawals")
    public String withdrawals() {
        return "BaoTuanAppTest/withdrawals";
    }

    @RequestMapping("/BaoTuanAppTest/pay2")
    public String pay2() {
        return "BaoTuanAppTest/pay2";
    }


}
