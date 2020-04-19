package com.lila.baotuan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 金额记录
 * </p>
 *
 * @author Zhang
 * @since 2020-04-20
 */
public class SysBrokerages extends Model<SysBrokerages> {

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
     * 实付金额
     */
    private Double payMoney;

    /**
     * 创建时间
     */
    private LocalDateTime createtime;

    /**
     * 申请提现id
     */
    private Integer brokerageId;

    /**
     * 到款状态
     */
    private Integer sysBrokeragesStatusId;


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

    public Double getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Double payMoney) {
        this.payMoney = payMoney;
    }

    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public void setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
    }

    public Integer getBrokerageId() {
        return brokerageId;
    }

    public void setBrokerageId(Integer brokerageId) {
        this.brokerageId = brokerageId;
    }

    public Integer getSysBrokeragesStatusId() {
        return sysBrokeragesStatusId;
    }

    public void setSysBrokeragesStatusId(Integer sysBrokeragesStatusId) {
        this.sysBrokeragesStatusId = sysBrokeragesStatusId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SysBrokerages{" +
        "id=" + id +
        ", userId=" + userId +
        ", money=" + money +
        ", payMoney=" + payMoney +
        ", createtime=" + createtime +
        ", brokerageId=" + brokerageId +
        ", sysBrokeragesStatusId=" + sysBrokeragesStatusId +
        "}";
    }
}
