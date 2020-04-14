package com.lila.baotuan.service.impl;

import com.lila.baotuan.entity.UploadFile;
import com.lila.baotuan.mapper.UploadFileMapper;
import com.lila.baotuan.service.IUploadFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 上传文件表 服务实现类
 * </p>
 *
 * @author Zhang
 * @since 2020-04-14
 */
@Service
public class UploadFileServiceImpl extends ServiceImpl<UploadFileMapper, UploadFile> implements IUploadFileService {

    /*
     * 添加上传
     * */
    public int insertUploadFile(String url, String name, double size) {
        UploadFile uploadFile = new UploadFile();
        uploadFile.setCreatetime(LocalDateTime.now());
        uploadFile.setName(name);
        uploadFile.setSize(size);
        uploadFile.setUrl(url);
        baseMapper.insert(uploadFile);
        return uploadFile.getId();
    }
}
