package com.lila.baotuan.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;

/**
 * <p>
 * 任务
 * </p>
 *
 * @author Zhang
 * @since 2020-03-24
 */
public class Task extends Model<Task> {

    private static final long serialVersionUID = 1L;

    /**
     * 任务id
     */
	private Integer id;
    /**
     * 任务标题
     */
	private String title;
    /**
     * 任务描述
     */
	private String context;
    /**
     * 任务数量
     */
	private Integer number;
    /**
     * 任务金额
     */
	private Double money;
    /**
     * 任务链接
     */
	private String url;
    /**
     * 任务类型
     */
	@TableField("task_type_code")
	private String taskTypeCode;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTaskTypeCode() {
		return taskTypeCode;
	}

	public void setTaskTypeCode(String taskTypeCode) {
		this.taskTypeCode = taskTypeCode;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Task{" +
			", id=" + id +
			", title=" + title +
			", context=" + context +
			", number=" + number +
			", money=" + money +
			", url=" + url +
			", taskTypeCode=" + taskTypeCode +
			"}";
	}
}
