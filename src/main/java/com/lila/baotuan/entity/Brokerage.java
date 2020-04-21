package com.lila.baotuan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 余额记录
 * </p>
 *
 * @author Zhang
 * @since 2020-04-21
 */
public class Brokerage extends Model<Brokerage> {

    private static final long serialVersionUID=1L;

    /**
     * 金额记录id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 金额
     */
    private Double money;

    /**
     * 余额类型
     */
    private Integer brokerageTypeId;

    /**
     * 创建时间
     */
    private LocalDateTime createtime;

    /**
     * 到款状态
     */
    private Integer brokerageStatusId;


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

    public Integer getBrokerageTypeId() {
        return brokerageTypeId;
    }

    public void setBrokerageTypeId(Integer brokerageTypeId) {
        this.brokerageTypeId = brokerageTypeId;
    }

    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public void setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
    }

    public Integer getBrokerageStatusId() {
        return brokerageStatusId;
    }

    public void setBrokerageStatusId(Integer brokerageStatusId) {
        this.brokerageStatusId = brokerageStatusId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Brokerage{" +
        "id=" + id +
        ", userId=" + userId +
        ", money=" + money +
        ", brokerageTypeId=" + brokerageTypeId +
        ", createtime=" + createtime +
        ", brokerageStatusId=" + brokerageStatusId +
        "}";
    }
}
