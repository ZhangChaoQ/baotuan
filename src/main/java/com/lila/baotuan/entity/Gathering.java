package com.lila.baotuan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 收款记录
 * </p>
 *
 * @author Zhang
 * @since 2020-04-05
 */
public class Gathering extends Model<Gathering> {

    private static final long serialVersionUID=1L;

    /**
     * 收款id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 付款用户id
     */
    private Integer userId;

    /**
     * 付款金额
     */
    private Double money;

    /**
     * 付款时间
     */
    private LocalDateTime createtime;

    /**
     * 到款时间
     */
    private LocalDateTime overtime;


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

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public void setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
    }

    public LocalDateTime getOvertime() {
        return overtime;
    }

    public void setOvertime(LocalDateTime overtime) {
        this.overtime = overtime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Gathering{" +
        "id=" + id +
        ", userId=" + userId +
        ", money=" + money +
        ", createtime=" + createtime +
        ", overtime=" + overtime +
        "}";
    }
}
