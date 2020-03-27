package com.lila.baotuan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 任务
 * </p>
 *
 * @author Zhang
 * @since 2020-03-27
 */
public class Task extends Model<Task> {

    private static final long serialVersionUID=1L;

    /**
     * 任务id
     */
    @TableId(value = "id", type = IdType.AUTO)
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
     * 任务类型id
     */
    private Integer taskTypeId;


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

    public Integer getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(Integer taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Task{" +
        "id=" + id +
        ", title=" + title +
        ", context=" + context +
        ", number=" + number +
        ", money=" + money +
        ", url=" + url +
        ", taskTypeId=" + taskTypeId +
        "}";
    }
}
