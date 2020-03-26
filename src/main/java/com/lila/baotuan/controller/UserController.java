package com.lila.baotuan.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lila.baotuan.entity.User;
import com.lila.baotuan.mapper.UserMapper;
import com.lila.baotuan.service.impl.UserServiceImpl;
import com.lila.baotuan.tools.MD5Util;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author Zhang
 * @since 2020-03-25
 */
@Controller
@RequestMapping("/baotuan/user")
public class UserController {
    @Resource
    private UserServiceImpl userService;

    /*
    * 修改会员等级
    * */
    public boolean updateMember(@Param("memberId")int memberId,@Param("id")int id){
        UpdateWrapper<User>uw=new UpdateWrapper<>();
        uw.set("member_id",memberId);
        uw.eq("id",id);
        boolean result=userService.update(uw);
        return result;
    }
    /*
    * 修改余额
    * */
    public boolean updateMoney(@Param("money")double money,@Param("id")int id){
        QueryWrapper<User>qw=new QueryWrapper<>();
        qw.eq("id",id);
        User user=userService.getOne(qw);
        UpdateWrapper<User>uw=new UpdateWrapper<>();
        uw.set("money",user.getMoney()+money);
        uw.eq("id",id);
        boolean result=userService.update(uw);
        return result;
    }
    /*
     * 检验用户重复
     * */
    @RequestMapping("/check")
    @ResponseBody
    public boolean check(@Param("loginName") String loginName) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("login_name", loginName);
        int count = userService.count(qw);
        return count > 0;
    }

    /*
     * 检验用户邀请码
     * */
    @RequestMapping("/checkInviteCode")
    @ResponseBody
    public boolean checkInviteCode(@Param("inviteCode") String inviteCode) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("invite_code", inviteCode);
        int count = userService.count(qw);
        return count > 0;
    }

    /*
     * 后台注册
     * */
    @RequestMapping("/register")
    public String register(@Param("loginName") String loginName, @Param("password") String password, @Param("inviteCode") String inviteCode) {
        if (check(loginName)) return "error";
        QueryWrapper<User>qw=new QueryWrapper<>();
        qw.eq("invite_code",inviteCode);
        User inviter=userService.getOne(qw);

        User user = new User();
        user.setEnabled(true);
        user.setInviteCode(getInviteCode());
        user.setPassword(MD5Util.getMD5(password));
        user.setPhone(loginName);
        user.setCode(getUserCode(inviter));

        boolean result = userService.save(user);
        if (result) {
            return "index";
        } else {
            return "error";
        }
    }

    /*
     * 前台登录
     * */
    @RequestMapping("/login")
    public String login(@Param("loginName") String loginName, @Param("password") String password) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("login_name", loginName);
        User User = userService.getOne(qw);
        if (User.getPassword().equals(MD5Util.getMD5(password))) {
            return "index";
        } else {
            return "error";
        }
    }

    /*
    * 个人邀请码
    * */
    public String getInviteCode(){
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
        char ch = str.charAt(str.length()-1);
        StringBuffer sb = new StringBuffer(6);
        for (int i = 0; i <6 ; i++) {
            char ch2 = str.charAt(new Random().nextInt(str.length()));
            sb.append(ch2);
        }
        if(checkInviteCode(sb.toString()))getInviteCode();
        return sb.toString();
    }
    /*
    * 获取个人编码 userCode
    * */

    public  String getUserCode(User user){
        String userCode=user.getCode();
        String [] code=userCode.split("-");
        String sup=code[1]+ Integer.valueOf(code[2]);//上级
        char letter=code[1].substring(code[1].length()-1).charAt(0);
        int number=Integer.valueOf(code[1].substring(0,code[1].length()-1));
        if(letter+1>90){
            number+=1;
            letter=65;
        }else{
            letter+=1;
        }
        QueryWrapper<User>qw=new QueryWrapper<>();
        qw.eq("user_id",user.getId());
        String count=userService.count()+1+"";
        System.out.println(sup+"-"+number+""+letter+"-"+count);
        return"";
    }

}
