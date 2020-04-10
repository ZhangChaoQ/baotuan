package com.lila.baotuan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 上传文件表
 * </p>
 *
 * @author Zhang
 * @since 2020-04-10
 */
public class UploadFile extends Model<UploadFile> {

    private static final long serialVersionUID=1L;

    /**
     * 上传文件id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 上传文件名称
     */
    private String name;

    /**
     * 上传路径
     */
    private String url;

    /**
     * 上传文件大小
     */
    private Double size;

    /**
     * 上传时间
     */
    private LocalDateTime createtime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public void setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "UploadFile{" +
        "id=" + id +
        ", name=" + name +
        ", url=" + url +
        ", size=" + size +
        ", createtime=" + createtime +
        "}";
    }
}
