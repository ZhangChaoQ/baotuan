package com.lila.baotuan.config;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Upload {
    @RequestMapping("upload.do")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file,
                         HttpServletRequest request)
            throws IllegalStateException, IOException {
        System.out.println("UploadController.upload()");

        // 判断上传的文件是否为空
        boolean isEmpty = file.isEmpty();
        System.out.println("\tisEmpty=" + isEmpty);
        if (isEmpty) {
            throw new RuntimeException("上传失败！上传的文件为空！");
        }

        // 检查文件大小
        long fileSize = file.getSize();
        System.out.println("\tsize=" + fileSize);
        if (fileSize > 1 * 1024 * 1024) {
            throw new RuntimeException("上传失败！上传的文件大小超出了限制！");
        }

        // 检查文件MIME类型
        String contentType = file.getContentType();
        System.out.println("\tcontentType=" + contentType);
        List<String> types = new ArrayList<String>();
        types.add("image/jpeg");
        types.add("image/png");
        types.add("image/gif");
        if (!types.contains(contentType)) {
            throw new RuntimeException("上传失败！不允许上传此类型的文件！");
        }

        // 准备文件夹,获取项目中upload文件夹的路径
        String parentDir = request.getServletContext().getRealPath("upload");
        // request.getSession().getServletContext().getRealPath("");
        // request.getRealPath("");
        System.out.println("\tpath=" + parentDir);
        File parent = new File(parentDir);
        if (!parent.exists()) {
            parent.mkdirs();
        }

        // 获取原始文件名
        String originalFilename = file.getOriginalFilename();
        System.out.println("\toriginalFilename=" + originalFilename);

        // 确定最终保存时使用的文件
        String filename = UUID.randomUUID().toString();
        String suffix = "";
        int beginIndex = originalFilename.lastIndexOf(".");
        if (beginIndex != -1) {
            suffix = originalFilename.substring(beginIndex);
        }

        // 执行保存文件
        File dest = new File(parent, filename + suffix);
        file.transferTo(dest);

        return "OK";
    }

}
