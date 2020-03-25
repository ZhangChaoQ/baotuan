package com.lila.baotuan.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户任务
 * </p>
 *
 * @author Zhang
 * @since 2020-03-25
 */
@TableName("user_task")
public class UserTask extends Model<UserTask> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户任务id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 用户id
     */
	@TableField("user_id")
	private Integer userId;
    /**
     * 任务id
     */
	@TableField("task_id")
	private Integer taskId;
    /**
     * 任务状态id
     */
	@TableField("task_status_id")
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
			", id=" + id +
			", userId=" + userId +
			", taskId=" + taskId +
			", taskStatusId=" + taskStatusId +
			"}";
	}
}
