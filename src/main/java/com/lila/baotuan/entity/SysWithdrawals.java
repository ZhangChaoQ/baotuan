package com.lila.baotuan.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 转款记录 
 * </p>
 *
 * @author Zhang
 * @since 2020-04-02
 */
public class SysWithdrawals extends Model<SysWithdrawals> {

    private static final long serialVersionUID=1L;

    /**
     * 金额记录id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 提款金额
     */
    private Double money;

    /**
     * 支付金额
     */
    private Double payMoney;

    /**
     * 支付状态
     */
    private Integer payStatusId;

    /**
     * 创建时间
     */
    private LocalDateTime createtime;


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

    public Integer getPayStatusId() {
        return payStatusId;
    }

    public void setPayStatusId(Integer payStatusId) {
        this.payStatusId = payStatusId;
    }

    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public void setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SysWithdrawals{" +
        "id=" + id +
        ", userId=" + userId +
        ", money=" + money +
        ", payMoney=" + payMoney +
        ", payStatusId=" + payStatusId +
        ", createtime=" + createtime +
        "}";
    }
}