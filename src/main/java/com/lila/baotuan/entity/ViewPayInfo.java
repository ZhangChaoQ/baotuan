package com.lila.baotuan.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author Zhang
 * @since 2020-04-24
 */
public class ViewPayInfo extends Model<ViewPayInfo> {

    private static final long serialVersionUID=1L;

    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

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
     * 提交时间
     */
    private LocalDateTime createtime;

    /**
     * 购买内容
     */
    private String content;

    /**
     * 失败理由
     */
    private String reason;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户编码
     */
    private String code;

    /**
     * 电话/登录账号
     */
    private String phone;

    /**
     * 支付宝用户名
     */
    @TableField("Alipay_name")
    private String alipayName;

    /**
     * 支付宝账号
     */
    @TableField("Alipay_account")
    private String alipayAccount;

    /**
     * 支付状态编码
     */
    private String payStatusCode;

    /**
     * 支付状态名称
     */
    private String payStatusName;


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

    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public void setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAlipayName() {
        return alipayName;
    }

    public void setAlipayName(String alipayName) {
        this.alipayName = alipayName;
    }

    public String getAlipayAccount() {
        return alipayAccount;
    }

    public void setAlipayAccount(String alipayAccount) {
        this.alipayAccount = alipayAccount;
    }

    public String getPayStatusCode() {
        return payStatusCode;
    }

    public void setPayStatusCode(String payStatusCode) {
        this.payStatusCode = payStatusCode;
    }

    public String getPayStatusName() {
        return payStatusName;
    }

    public void setPayStatusName(String payStatusName) {
        this.payStatusName = payStatusName;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "ViewPayInfo{" +
        "id=" + id +
        ", userId=" + userId +
        ", payMoney=" + payMoney +
        ", payCode=" + payCode +
        ", payStatusId=" + payStatusId +
        ", createtime=" + createtime +
        ", content=" + content +
        ", reason=" + reason +
        ", name=" + name +
        ", code=" + code +
        ", phone=" + phone +
        ", alipayName=" + alipayName +
        ", alipayAccount=" + alipayAccount +
        ", payStatusCode=" + payStatusCode +
        ", payStatusName=" + payStatusName +
        "}";
    }
}
