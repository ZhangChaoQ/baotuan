package com.lila.baotuan.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 分佣记录
 * </p>
 *
 * @author Zhang
 * @since 2020-03-26
 */
public class Brokerages extends Model<Brokerages> {

    private static final long serialVersionUID=1L;

    /**
     * 分佣id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 推荐人id
     */
    private Integer inviterId;

    /**
     * 获取分佣金额
     */
    private Double money;

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

    public Integer getInviterId() {
        return inviterId;
    }

    public void setInviterId(Integer inviterId) {
        this.inviterId = inviterId;
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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Brokerages{" +
        "id=" + id +
        ", userId=" + userId +
        ", inviterId=" + inviterId +
        ", money=" + money +
        ", createtime=" + createtime +
        "}";
    }
}
