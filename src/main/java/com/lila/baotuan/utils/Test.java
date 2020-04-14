package com.lila.baotuan.utils;

import com.lila.baotuan.controller.TaskController;

/**
 * 发送post/get 测试类
 */
public class Test {

    public static void main(String[] args) throws Exception {
        //String url = "https://v.douyin.com/gWJuWR/";
        String url = new TaskController().getUrl();
        /**
         * 发送get
         */
        Object result = HttpClientService.sendGet(url);
        while(!(result!=null&&result.toString().indexOf("【抖音】")!=-1)){
            url = new TaskController().getUrl();
            result=HttpClientService.sendGet(url);
        }
        System.out.println(url);
        System.out.println("GET返回信息：" + result);
    }
}