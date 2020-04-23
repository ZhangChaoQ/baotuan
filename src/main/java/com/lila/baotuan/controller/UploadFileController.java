package com.lila.baotuan.controller;


import com.lila.baotuan.entity.Result;
import com.lila.baotuan.entity.UploadFile;
import com.lila.baotuan.service.impl.UploadFileServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
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
    @Value("${realPath}")
    private String realPath;

    @Resource
    private UploadFileServiceImpl uploadFileService;

    @RequestMapping("/upload")
    @ResponseBody
    public Result uploadFile(@RequestParam("file") MultipartFile uploadFile) {
        String fileName = uploadFile.getOriginalFilename();
        String name = fileName.substring(0, fileName.indexOf("."));
        double size = uploadFile.getSize();
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //重新生成文件名
        fileName = UUID.randomUUID() + suffixName;
        //添加日期目录
        //指定本地文件夹存储图片
        String refilePath = filePath + "/";
        File file = new File(refilePath, fileName);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        Result result=new Result();
        try {
            //将图片保存到static文件夹里
            file.createNewFile();
            uploadFile.transferTo(new File(filePath + fileName));
            String url = realPath + fileName;
            result.setData(this.uploadFile(url, name, size));
            result.setCode(true);
            result.setMsg("上传成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setData(null);
            result.setCode(false);
            result.setMsg("上传失败");
        }
        return result;
    }

    public UploadFile uploadFile(String url, String name, double size) {
        return uploadFileService.insertUploadFile(url, name, size);
    }

}

