package com.lila.baotuan.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author Zhang
 * @since 2020-04-10
 */
public class ViewUserTask extends Model<ViewUserTask> {

    private static final long serialVersionUID=1L;

    /**
     * 用户任务id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 任务id
     */
    private Integer taskId;

    /**
     * 任务状态id
     */
    private Integer taskStatusId;

    /**
     * 余额
     */
    private Double userMoney;

    /**
     * 任务金额
     */
    private Double taskMoney;

    /**
     * 用户id
     */
    private Integer inviteId;

    /**
     * 发布时间
     */
    private LocalDateTime createtime;

    /**
     * 任务标题
     */
    private String title;

    /**
     * 任务描述
     */
    private String context;

    /**
     * 任务链接
     */
    private String url;

    /**
     * 接取时间
     */
    private LocalDateTime userTaskCreatetime;

    /**
     * 任务图片链接
     */
    private Integer uploadFileId;

    /**
     * 上传文件名称
     */
    private String name;

    /**
     * 上传路径
     */
    private String fileUrl;

    /**
     * 上传文件大小
     */
    private Double size;

    /**
     * 上传时间
     */
    private LocalDateTime uploadTime;

    /**
     * 任务状态名称
     */
    private String taskStatusName;

    /**
     * 任务状态编码
     */
    private String taskStatusCode;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getTaskStatusId() {
        return taskStatusId;
    }

    public void setTaskStatusId(Integer taskStatusId) {
        this.taskStatusId = taskStatusId;
    }

    public Double getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(Double userMoney) {
        this.userMoney = userMoney;
    }

    public Double getTaskMoney() {
        return taskMoney;
    }

    public void setTaskMoney(Double taskMoney) {
        this.taskMoney = taskMoney;
    }

    public Integer getInviteId() {
        return inviteId;
    }

    public void setInviteId(Integer inviteId) {
        this.inviteId = inviteId;
    }

    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public void setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getUserTaskCreatetime() {
        return userTaskCreatetime;
    }

    public void setUserTaskCreatetime(LocalDateTime userTaskCreatetime) {
        this.userTaskCreatetime = userTaskCreatetime;
    }

    public Integer getUploadFileId() {
        return uploadFileId;
    }

    public void setUploadFileId(Integer uploadFileId) {
        this.uploadFileId = uploadFileId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public LocalDateTime getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(LocalDateTime uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getTaskStatusName() {
        return taskStatusName;
    }

    public void setTaskStatusName(String taskStatusName) {
        this.taskStatusName = taskStatusName;
    }

    public String getTaskStatusCode() {
        return taskStatusCode;
    }

    public void setTaskStatusCode(String taskStatusCode) {
        this.taskStatusCode = taskStatusCode;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "ViewUserTask{" +
        "id=" + id +
        ", userId=" + userId +
        ", taskId=" + taskId +
        ", taskStatusId=" + taskStatusId +
        ", userMoney=" + userMoney +
        ", taskMoney=" + taskMoney +
        ", inviteId=" + inviteId +
        ", createtime=" + createtime +
        ", title=" + title +
        ", context=" + context +
        ", url=" + url +
        ", userTaskCreatetime=" + userTaskCreatetime +
        ", uploadFileId=" + uploadFileId +
        ", name=" + name +
        ", fileUrl=" + fileUrl +
        ", size=" + size +
        ", uploadTime=" + uploadTime +
        ", taskStatusName=" + taskStatusName +
        ", taskStatusCode=" + taskStatusCode +
        "}";
    }
}
