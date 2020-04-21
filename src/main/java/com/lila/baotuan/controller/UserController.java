package com.lila.baotuan.controller;

import com.lila.baotuan.entity.Result;
import com.lila.baotuan.entity.User;
import com.lila.baotuan.entity.ViewUser;
import com.lila.baotuan.entity.ViewUserTask;
import com.lila.baotuan.service.impl.*;
import com.lila.baotuan.utils.MD5Util;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Random;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author Zhang
 * @since 2020-03-28
 */
@RestController
@RequestMapping("/baotuan/user")
public class UserController {

    @Resource
    private UserServiceImpl userService;
    @Resource
    private ViewUserServiceImpl viewUserService;
    @Resource
    private ViewUserTaskServiceImpl viewUserTaskService;
    @Resource
    private BrokerageServiceImpl brokerageService;
    @Resource
    private UserTaskController userTaskController;
    @Resource
    private SysBrokeragesServiceImpl sysBrokeragesService;

    @RequestMapping("/isEnabled")
    public Result isenabled(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id"));
        Result result = new Result();
        result.setMsg("");
        result.setCode(true);
        result.setData(userService.getUserEnabled(id));
        return result;
    }


    /*
     * 禁用账号
     * */
    @RequestMapping("/enabled")
    public int enabledUser(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id"));
        return userService.enabledUser(id);
    }

    /*
     * 启用账号
     * */
    @RequestMapping("/enable")
    public int enableUser(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id"));
        return userService.enableUser(id);
    }

    /*
     * 获取下级
     * */
    @RequestMapping("/getSonList")
    public Result getSonList(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id"));
        Result result = new Result();
        result.setCode(true);
        result.setData(viewUserService.getSonList(id));
        result.setMsg("获取成功");
        return result;
    }

    /*
     * 获取子级
     * */
    @RequestMapping("/getGradSonList")
    public Result getGradSonList(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id"));
        Result result = new Result();
        result.setCode(true);
        result.setData(viewUserService.getGrandSonList(id));
        result.setMsg("获取成功");
        return result;
    }

    /*
     * 用户提现
     * */
    @RequestMapping("/withdrawals")
    public Result userWithdrawals(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id"));
        int money = Integer.valueOf(request.getParameter("money"));
        Result result = new Result();
        if (userService.checkAlipay(id)) {
            result.setCode(true);
            userService.updateMoney(id, -money);
            int brokerageId = brokerageService.insertWithdraw(id, money);
            result.setData(sysBrokeragesService.insertSysBrokerages(id, money, brokerageId));
            result.setMsg("提现申请已提交，转账将于24小时内到账，请注意查收");
        } else {
            result.setData(null);
            result.setMsg("请先绑定支付宝账号");
            result.setCode(false);
        }
        return result;
    }

    /*
     * 接受任务
     * */
    @RequestMapping("/addUserTask")
    public Result addUserTask(HttpServletRequest request) {
        int userId = Integer.valueOf(request.getParameter("userId"));
        int taskId = Integer.valueOf(request.getParameter("taskId"));
        return userTaskController.addUserTask(userId, taskId);
    }

    /*
     * 获取用户信息
     * */
    @RequestMapping("/getUserInfo")
    public Result getUserInfo(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id"));
        Result result = new Result();
        result.setData(viewUserService.getViewUserById(id));
        result.setCode(true);
        result.setMsg("获取成功");
        return result;
    }

    /*
     * 完成任务
     * */
    @RequestMapping("/commitTask")
    public Result commitTask(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id"));
        String urlId = request.getParameter("url");
        int url = -1;
        if (!urlId.equals("")) url = Integer.valueOf(urlId);
        ViewUserTask viewUserTask = viewUserTaskService.getViewUserTaskById(id);
        ViewUser viewUser = viewUserService.getViewUserById(viewUserTask.getUserId());

        userService.updateMoney(viewUser.getId(), viewUserTask.getTaskMoney() * 0.98);
        brokerageService.insertTask(viewUser.getId(), viewUserTask.getTaskMoney() * 0.98);

        if (-1 != viewUser.getUserId()) {
            ViewUser inviter = viewUserService.getViewUserById(viewUser.getUserId());
            userService.updateMoney(inviter.getId(), viewUserTask.getTaskMoney() * 0.02);
            brokerageService.insertBrokerage(inviter.getId(), viewUserTask.getTaskMoney() * 0.02);
        }

        return userTaskController.updateTaskStatus(id, url);
    }

    /*
     * 用戶注冊
     * */
    @RequestMapping("/addUser")
    public Result addUser(HttpServletRequest request) {
        Result result = new Result();
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String inviteCode = request.getParameter("inviteCode");
        if (userService.getCountByPhone(phone) > 0) {
            result.setCode(false);
            result.setData(null);
            result.setMsg("手机号已注册，请更换手机号");
            return result;
        } else if (userService.getCountByInviteCode(inviteCode) == 0) {
            result.setCode(false);
            result.setData(null);
            result.setMsg("邀请码不存在，请检测输入");
            return result;
        }
        User inviter = userService.getUserByInviteCode(inviteCode);
        int id = userService.insertUser(password, getCode(inviter), getInviteCode(), phone, inviter.getId());
        ViewUser user = viewUserService.getViewUserById(id);
        result.setCode(true);
        result.setData(user);
        result.setMsg("登录成功");
        return result;
    }

    /*
     * 用戶登录
     * */
    @RequestMapping("/login")
    public Result login(HttpServletRequest request) {
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        ViewUser user = viewUserService.userLogin(phone, password);
        Result result = new Result();
        if (null != user) {
            if (!user.getEnabled()) {
                result.setCode(false);
                result.setData(null);
                result.setMsg("登录失败，该账号已禁用，请联系管理员");
            } else {
                result.setCode(true);
                result.setData(user);
                result.setMsg("登录成功");
            }
        } else {
            result.setCode(false);
            result.setData(null);
            result.setMsg("登录失败，请检查账号和密码是否正确");
        }
        return result;
    }

    /*
     * 用戶登录
     * */
    @RequestMapping("/loginByPhone")
    public Result loginByPhone(HttpServletRequest request) {
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        int userId = userService.uploadPasswordByPhone(phone, password);
        ViewUser user = viewUserService.getViewUserById(userId);
        Result result = new Result();
        if (null != user) {
            if (!user.getEnabled()) {
                result.setCode(false);
                result.setData(null);
                result.setMsg("登录失败，该账号已禁用，请联系管理员");
            } else {
                result.setCode(true);
                result.setData(user);
                result.setMsg("登录成功");
            }
        } else {
            result.setCode(false);
            result.setData(null);
            result.setMsg("登录失败，请检查手机号");
        }
        return result;
    }

    /*
     * 綁定支付宝
     * */
    @RequestMapping("/bindAlipay")
    public Result bindAlipay(HttpServletRequest request) {
        Result result = new Result();
        String alipayAccount = request.getParameter("alipayAccount");
        String alipayName = request.getParameter("alipayName");
        int alipayUrl = Integer.valueOf(request.getParameter("alipayUrl"));
        int id = Integer.valueOf(request.getParameter("id"));
        if (userService.getAliPayCount(alipayAccount, alipayName)) {
            result.setData(userService.updateAlipay(id, alipayAccount, alipayUrl, alipayName));
            result.setMsg("支付宝绑定成功");
            result.setCode(true);
        } else {
            result.setData(null);
            result.setMsg("该支付宝账号已绑定，请更换账号");
            result.setCode(true);
        }
        return result;
    }

    /*
     * 修改昵称
     * */
    @RequestMapping("/reName")
    public String reName(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        userService.updateName(id, name);
        return "index";
    }

    /*
     * 个人邀请码
     * */
    public String getInviteCode() {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
        char ch = str.charAt(str.length() - 1);
        StringBuffer sb = new StringBuffer(6);
        for (int i = 0; i < 6; i++) {
            char ch2 = str.charAt(new Random().nextInt(str.length()));
            sb.append(ch2);
        }
        if (checkInviteCode(sb.toString())) getInviteCode();
        return sb.toString();
    }


    public boolean checkInviteCode(String inviteCode) {
        return userService.getCountByInviteCode(inviteCode) > 0;
    }


    /*
     * 获取用户编码
     * */
    public String getCode(User user) {
        String userCode = user.getCode();
        String[] code = userCode.split("-");
        String sup = code[1] + Integer.valueOf(code[2]);//上级
        char letter = code[1].substring(code[1].length() - 1).charAt(0);
        int number = Integer.valueOf(code[1].substring(0, code[1].length() - 1));
        if (letter + 1 > 90) {
            number += 1;
            letter = 65;
        } else {
            letter += 1;
        }
        String count = userService.getCountByCode((number + "" + letter)) + 1 + "";
        for (int i = count.length(); i < 5; i++) {
            count = "0" + count;
        }
        return sup + "-" + number + "" + letter + "-" + count;
    }

    public static void main(String[] args) {
        System.out.println(MD5Util.MD5Encode("123456", "UTF-8"));
    }
}

