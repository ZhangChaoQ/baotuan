package com.lila.baotuan.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 用户任务
 * </p>
 *
 * @author Zhang
 * @since 2020-03-24
 */
@TableName("user_task")
public class UserTask extends Model<UserTask> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户任务id
     */
	private Integer id;
    /**
     * 用户编码
     */
	@TableField("user_code")
	private String userCode;
    /**
     * 任务id
     */
	@TableField("task_id")
	private Integer taskId;
    /**
     * 任务状态
     */
	@TableField("task_status_code")
	private String taskStatusCode;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getTaskStatusCode() {
		return taskStatusCode;
	}

	public void setTaskStatusCode(String taskStatusCode) {
		this.taskStatusCode = taskStatusCode;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "UserTask{" +
			", id=" + id +
			", userCode=" + userCode +
			", taskId=" + taskId +
			", taskStatusCode=" + taskStatusCode +
			"}";
	}
}
