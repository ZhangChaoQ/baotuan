package com.lila.baotuan.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author Zhang
 * @since 2020-04-07
 */
public class ViewBrokerages extends Model<ViewBrokerages> {

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
     * 金额
     */
    private Double money;

    /**
     * 创建时间
     */
    private LocalDateTime createtime;

    /**
     * 分佣类型
     */
    private Integer brokeragesTypeId;

    /**
     * 类型编码
     */
    private String brokeragesTypeCode;

    /**
     * 类型名称
     */
    private String brokeragesTypeName;


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

    public Integer getBrokeragesTypeId() {
        return brokeragesTypeId;
    }

    public void setBrokeragesTypeId(Integer brokeragesTypeId) {
        this.brokeragesTypeId = brokeragesTypeId;
    }

    public String getBrokeragesTypeCode() {
        return brokeragesTypeCode;
    }

    public void setBrokeragesTypeCode(String brokeragesTypeCode) {
        this.brokeragesTypeCode = brokeragesTypeCode;
    }

    public String getBrokeragesTypeName() {
        return brokeragesTypeName;
    }

    public void setBrokeragesTypeName(String brokeragesTypeName) {
        this.brokeragesTypeName = brokeragesTypeName;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "ViewBrokerages{" +
        "id=" + id +
        ", userId=" + userId +
        ", money=" + money +
        ", createtime=" + createtime +
        ", brokeragesTypeId=" + brokeragesTypeId +
        ", brokeragesTypeCode=" + brokeragesTypeCode +
        ", brokeragesTypeName=" + brokeragesTypeName +
        "}";
    }
}
