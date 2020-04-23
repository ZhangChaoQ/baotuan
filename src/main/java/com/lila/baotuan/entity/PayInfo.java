package com.lila.baotuan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 购买核对
 * </p>
 *
 * @author Zhang
 * @since 2020-04-23
 */
public class PayInfo extends Model<PayInfo> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 购买内容
     */
    private String content;

    /**
     * 应付金额
     */
    private Double payMoney;

    /**
     * 支付单号
     */
    private String payCode;

    /**
     * 审核状态
     */
    private Integer payStatusId;

    /**
     * 失败理由
     */
    private String reason;

    /**
     * 提交时间
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Double getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Double payMoney) {
        this.payMoney = payMoney;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    public Integer getPayStatusId() {
        return payStatusId;
    }

    public void setPayStatusId(Integer payStatusId) {
        this.payStatusId = payStatusId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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
        return "PayInfo{" +
        "id=" + id +
        ", userId=" + userId +
        ", content=" + content +
        ", payMoney=" + payMoney +
        ", payCode=" + payCode +
        ", payStatusId=" + payStatusId +
        ", reason=" + reason +
        ", createtime=" + createtime +
        "}";
    }
}
