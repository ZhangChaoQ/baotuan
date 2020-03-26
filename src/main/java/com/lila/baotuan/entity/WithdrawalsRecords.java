package com.lila.baotuan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 提现记录
 * </p>
 *
 * @author Zhang
 * @since 2020-03-26
 */
public class WithdrawalsRecords extends Model<WithdrawalsRecords> {

    private static final long serialVersionUID=1L;

    /**
     * 提现记录id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 提现人id
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
     * 提现时间
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
        return "WithdrawalsRecords{" +
        "id=" + id +
        ", userId=" + userId +
        ", money=" + money +
        ", payMoney=" + payMoney +
        ", payStatusId=" + payStatusId +
        ", createtime=" + createtime +
        ", overtime=" + overtime +
        "}";
    }
}
