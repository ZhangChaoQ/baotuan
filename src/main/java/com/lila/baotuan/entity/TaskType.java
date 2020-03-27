package com.lila.baotuan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 任务类型
 * </p>
 *
 * @author Zhang
 * @since 2020-03-27
 */
public class TaskType extends Model<TaskType> {

    private static final long serialVersionUID=1L;

    /**
     * 任务类型id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
        return this.id;
    }

    @Override
    public String toString() {
        return "TaskType{" +
        "id=" + id +
        ", code=" + code +
        ", name=" + name +
        ", description=" + description +
        "}";
    }
}
