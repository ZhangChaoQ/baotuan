package com.lila.baotuan.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author Zhang
 * @since 2020-03-27
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
        "}";
    }
}
