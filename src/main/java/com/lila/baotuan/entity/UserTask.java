package com.lila.baotuan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 用户任务记录
 * </p>
 *
 * @author Zhang
 * @since 2020-03-27
 */
public class UserTask extends Model<UserTask> {

    private static final long serialVersionUID=1L;

    /**
     * 用户任务id
     */
    @TableId(value = "id", type = IdType.AUTO)
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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "UserTask{" +
        "id=" + id +
        ", userId=" + userId +
        ", taskId=" + taskId +
        ", taskStatusId=" + taskStatusId +
        "}";
    }
}
