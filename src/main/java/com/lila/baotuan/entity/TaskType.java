package com.lila.baotuan.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 任务类型
 * </p>
 *
 * @author Zhang
 * @since 2020-03-24
 */
@TableName("task_type")
public class TaskType extends Model<TaskType> {

    private static final long serialVersionUID = 1L;

    /**
     * 任务类型编码
     */
	private String code;
    /**
     * 任务类型名称
     */
	private String name;
    /**
     * 任务类型简介
     */
	private String description;


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	protected Serializable pkVal() {
		return this.code;
	}

	@Override
	public String toString() {
		return "TaskType{" +
			", code=" + code +
			", name=" + name +
			", description=" + description +
			"}";
	}
}
