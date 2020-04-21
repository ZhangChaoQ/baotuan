package com.lila.baotuan.controller;


import com.lila.baotuan.entity.Result;
import com.lila.baotuan.service.impl.TaskServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Random;

/**
 * <p>
 * 任务 前端控制器
 * </p>
 *
 * @author Zhang
 * @since 2020-03-28
 */
@Controller
@RequestMapping("/baotuan/task")
public class TaskController {

    @Resource
    private TaskServiceImpl taskService;


    @RequestMapping("/updateTask")
    @ResponseBody
    public Result updateTask(HttpServletRequest request) {
        int id=Integer.valueOf(request.getParameter("id"));
        int number = Integer.valueOf(request.getParameter("number"));
        String title = request.getParameter("title");
        String context = request.getParameter("context");
        String url = request.getParameter("url");
        double money = Double.parseDouble(request.getParameter("money"));
        Result result = new Result();
        result.setMsg("修改成功");
        result.setData(taskService.updateTask(id,number,title,context,url,money));
        result.setCode(true);
        return result;
    }
    @RequestMapping("/deleteTask")
    @ResponseBody
    public Result deleteTask(HttpServletRequest request) {
        int id=Integer.valueOf(request.getParameter("id"));
        Result result = new Result();
        result.setMsg("删除成功");
        result.setData(taskService.deleteTask(id));
        result.setCode(true);
        return result;
    }

    @RequestMapping("/updateEnabled")
    @ResponseBody
    public Result updateEnabled(HttpServletRequest request) {
        int id=Integer.valueOf(request.getParameter("id"));
        Result result = new Result();
        result.setMsg("发布成功");
        result.setData(taskService.updateEnabled(id));
        result.setCode(true);
        return result;
    }

    @RequestMapping("/taskList")
    @ResponseBody
    public Result getTaskList(HttpServletRequest request) {
        int page=Integer.valueOf(request.getParameter("page"));
        int limit=Integer.valueOf(request.getParameter("limit"));
        Result result = new Result();
        result.setMsg("获取成功");
        result.setData(taskService.getTaskList(page,limit));
        result.setCode(true);
        return result;
    }

    @RequestMapping("addTask")
    @ResponseBody
    public Result addTask(HttpServletRequest request) {
        int number = Integer.valueOf(request.getParameter("number"));
        String title = request.getParameter("title");
        String context = request.getParameter("context");
        String url = request.getParameter("url");
        double money = Double.parseDouble(request.getParameter("money"));
        int id = taskService.insertTask(number, title, context, url, money);
        Result result = new Result();
        if (id != 0) {
            result.setMsg("添加成功");
            result.setData(null);
            result.setCode(true);
        } else {
            result.setMsg("添加失败");
            result.setData(null);
            result.setCode(false);

        }
        return result;
    }

    @RequestMapping("addTaskList")
    @ResponseBody
    public Result addTaskList(HttpServletRequest request) {
        int count = Integer.valueOf(request.getParameter("count"));
        int number = Integer.valueOf(request.getParameter("number"));
        String title = request.getParameter("title");
        String context = request.getParameter("context");
        double money = Double.parseDouble(request.getParameter("money"));
        for (int i = 0; i < count; i++) {
            taskService.insertTask(number, title, context, getUrl(), money);
        }
        Result result = new Result();
        return result;
    }

    public String getUrl() {
        String url = "https://v.douyin.com/";
        return url + getInviteCode();
    }

    public String getInviteCode() {
        String a = "0123456789";
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
        StringBuffer sb = new StringBuffer(6);
        for (int i = 0; i < 1; i++) {
            char ch2 = a.charAt(new Random().nextInt(a.length()));
            sb.append(ch2);
        }
        for (int i = 1; i < 6; i++) {
            char ch2 = str.charAt(new Random().nextInt(str.length()));
            sb.append(ch2);
        }
        return sb.toString() + "/";
    }

    public static void main(String[] args) {
        TaskController t = new TaskController();
        String url = t.getUrl();
        System.out.println(url);
    }
}

