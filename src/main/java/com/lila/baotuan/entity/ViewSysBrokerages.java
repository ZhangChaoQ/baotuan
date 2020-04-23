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
 * @since 2020-04-23
 */
public class ViewSysBrokerages extends Model<ViewSysBrokerages> {

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
     * 用户编码
     */
    private String code;

    /**
     * 电话/登录账号
     */
    private String phone;

    /**
     * 申请提现id
     */
    private Integer brokerageId;

    /**
     * 到款状态
     */
    private Integer sysBrokeragesStatusId;

    /**
     * 支付状态编码
     */
    private String sysBrokeragesStatusCode;

    /**
     * 支付状态名称
     */
    private String sysBrokeragesStatusName;

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
     * 支付宝二维码
     */
    @TableField("Alipay_url")
    private Integer alipayUrl;

    /**
     * 上传路径
     */
    private String fileUrl;


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

    public String getSysBrokeragesStatusCode() {
        return sysBrokeragesStatusCode;
    }

    public void setSysBrokeragesStatusCode(String sysBrokeragesStatusCode) {
        this.sysBrokeragesStatusCode = sysBrokeragesStatusCode;
    }

    public String getSysBrokeragesStatusName() {
        return sysBrokeragesStatusName;
    }

    public void setSysBrokeragesStatusName(String sysBrokeragesStatusName) {
        this.sysBrokeragesStatusName = sysBrokeragesStatusName;
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

    public Integer getAlipayUrl() {
        return alipayUrl;
    }

    public void setAlipayUrl(Integer alipayUrl) {
        this.alipayUrl = alipayUrl;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "ViewSysBrokerages{" +
        "id=" + id +
        ", userId=" + userId +
        ", money=" + money +
        ", payMoney=" + payMoney +
        ", createtime=" + createtime +
        ", code=" + code +
        ", phone=" + phone +
        ", brokerageId=" + brokerageId +
        ", sysBrokeragesStatusId=" + sysBrokeragesStatusId +
        ", sysBrokeragesStatusCode=" + sysBrokeragesStatusCode +
        ", sysBrokeragesStatusName=" + sysBrokeragesStatusName +
        ", alipayName=" + alipayName +
        ", alipayAccount=" + alipayAccount +
        ", alipayUrl=" + alipayUrl +
        ", fileUrl=" + fileUrl +
        "}";
    }
}
