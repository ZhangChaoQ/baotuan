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
 * @since 2020-04-10
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
     * 实付金额
     */
    private Double payMoney;

    /**
     * 创建时间
     */
    private LocalDateTime createtime;

    /**
     * 分佣类型
     */
    private Integer sysBrokeragesTypeId;

    /**
     * 类型编码
     */
    private String sysBrokeragesTypeCode;

    /**
     * 类型名称
     */
    private String sysBrokeragesTypeName;

    /**
     * 用户编码
     */
    private String code;

    /**
     * 电话/登录账号
     */
    private String phone;


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

    public Integer getSysBrokeragesTypeId() {
        return sysBrokeragesTypeId;
    }

    public void setSysBrokeragesTypeId(Integer sysBrokeragesTypeId) {
        this.sysBrokeragesTypeId = sysBrokeragesTypeId;
    }

    public String getSysBrokeragesTypeCode() {
        return sysBrokeragesTypeCode;
    }

    public void setSysBrokeragesTypeCode(String sysBrokeragesTypeCode) {
        this.sysBrokeragesTypeCode = sysBrokeragesTypeCode;
    }

    public String getSysBrokeragesTypeName() {
        return sysBrokeragesTypeName;
    }

    public void setSysBrokeragesTypeName(String sysBrokeragesTypeName) {
        this.sysBrokeragesTypeName = sysBrokeragesTypeName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        ", payMoney=" + payMoney +
        ", createtime=" + createtime +
        ", sysBrokeragesTypeId=" + sysBrokeragesTypeId +
        ", sysBrokeragesTypeCode=" + sysBrokeragesTypeCode +
        ", sysBrokeragesTypeName=" + sysBrokeragesTypeName +
        ", code=" + code +
        ", phone=" + phone +
        "}";
    }
}
