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
 * @since 2020-04-14
 */
public class ViewSysWithdrawals extends Model<ViewSysWithdrawals> {

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

    /**
     * 0转入 1支出
     */
    private Boolean payType;

    /**
     * 支付状态编码
     */
    private String payStatusCode;

    /**
     * 支付状态名称
     */
    private String payStatusName;

    /**
     * 用户编码
     */
    private String code;

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

    public Boolean getPayType() {
        return payType;
    }

    public void setPayType(Boolean payType) {
        this.payType = payType;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "ViewSysWithdrawals{" +
        "id=" + id +
        ", userId=" + userId +
        ", money=" + money +
        ", payMoney=" + payMoney +
        ", payStatusId=" + payStatusId +
        ", createtime=" + createtime +
        ", payType=" + payType +
        ", payStatusCode=" + payStatusCode +
        ", payStatusName=" + payStatusName +
        ", code=" + code +
        ", alipayName=" + alipayName +
        ", alipayAccount=" + alipayAccount +
        ", alipayUrl=" + alipayUrl +
        "}";
    }
}
