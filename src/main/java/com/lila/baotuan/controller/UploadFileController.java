package com.lila.baotuan.controller;


import com.alibaba.fastjson.JSONObject;
import com.lila.baotuan.entity.Result;
import com.lila.baotuan.entity.UploadFile;
import com.lila.baotuan.service.impl.UploadFileServiceImpl;
import com.lila.baotuan.utils.ServiceUtil;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * <p>
 * 上传文件表 前端控制器
 * </p>
 *
 * @author Zhang
 * @since 2020-03-28
 */
@Controller
@RequestMapping("/baotuan/uploadFile")
public class UploadFileController {


    @Value("${filePath}")
    private String filePath;

    @Resource
    private UploadFileServiceImpl uploadFileService;

    @RequestMapping("/upload")
    @ResponseBody
    public int uploadFile(@RequestParam("file") MultipartFile uploadFile) {
        String fileName = uploadFile.getOriginalFilename();
        String name = fileName.substring(0, fileName.indexOf("."));
        double size = uploadFile.getSize();
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //重新生成文件名
        fileName = UUID.randomUUID() + suffixName;
        //添加日期目录
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        //指定本地文件夹存储图片
        filePath = filePath + format + "/";
        File file = new File(filePath, fileName);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        int result = -1;
        try {
            //将图片保存到static文件夹里
            file.createNewFile();
            uploadFile.transferTo(new File(filePath + fileName));
            String url = "/upload/" + format + "/" + fileName;
            result = this.uploadFile(url, name, size);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int uploadFile(String url, String name, double size) {
        return uploadFileService.insertUploadFile(url, name, size);
    }
}

