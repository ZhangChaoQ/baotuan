package com.lila.baotuan.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author Zhang
 * @since 2020-04-04
 */
public class ViewUser extends Model<ViewUser> {

    private static final long serialVersionUID=1L;

    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户编码
     */
    private String userCode;

    /**
     * 电话/登录账号
     */
    private String phone;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 个人邀请码
     */
    private String inviteCode;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 支付宝账号
     */
    private String zfbAccount;

    /**
     * 支付宝二维码
     */
    private Integer zfbUrl;

    /**
     * 余额
     */
    private Double money;

    /**
     * 会员id
     */
    private Integer memberId;

    /**
     * 是否启用(1:启用 0:禁用)
     */
    private Boolean enabled;

    /**
     * 会员等级编码
     */
    private String code;

    /**
     * 会员名称
     */
    private String name;

    /**
     * 用户编码
     */
    private String inviterCode;

    /**
     * 个人邀请码
     */
    private String inviterInviteCode;

    /**
     * 会员等级编码
     */
    private String inviterMemberCode;

    /**
     * 会员名称
     */
    private String inviterMemberName;

    /**
     * 会员价格
     */
    private Double userMemberMoney;

    /**
     * 会员价格
     */
    private Double inviterMemberMoney;

    /**
     * 没日任务数量
     */
    private Integer taskNumber;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getZfbAccount() {
        return zfbAccount;
    }

    public void setZfbAccount(String zfbAccount) {
        this.zfbAccount = zfbAccount;
    }

    public Integer getZfbUrl() {
        return zfbUrl;
    }

    public void setZfbUrl(Integer zfbUrl) {
        this.zfbUrl = zfbUrl;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInviterCode() {
        return inviterCode;
    }

    public void setInviterCode(String inviterCode) {
        this.inviterCode = inviterCode;
    }

    public String getInviterInviteCode() {
        return inviterInviteCode;
    }

    public void setInviterInviteCode(String inviterInviteCode) {
        this.inviterInviteCode = inviterInviteCode;
    }

    public String getInviterMemberCode() {
        return inviterMemberCode;
    }

    public void setInviterMemberCode(String inviterMemberCode) {
        this.inviterMemberCode = inviterMemberCode;
    }

    public String getInviterMemberName() {
        return inviterMemberName;
    }

    public void setInviterMemberName(String inviterMemberName) {
        this.inviterMemberName = inviterMemberName;
    }

    public Double getUserMemberMoney() {
        return userMemberMoney;
    }

    public void setUserMemberMoney(Double userMemberMoney) {
        this.userMemberMoney = userMemberMoney;
    }

    public Double getInviterMemberMoney() {
        return inviterMemberMoney;
    }

    public void setInviterMemberMoney(Double inviterMemberMoney) {
        this.inviterMemberMoney = inviterMemberMoney;
    }

    public Integer getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(Integer taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "ViewUser{" +
        "id=" + id +
        ", userCode=" + userCode +
        ", phone=" + phone +
        ", password=" + password +
        ", inviteCode=" + inviteCode +
        ", userId=" + userId +
        ", zfbAccount=" + zfbAccount +
        ", zfbUrl=" + zfbUrl +
        ", money=" + money +
        ", memberId=" + memberId +
        ", enabled=" + enabled +
        ", code=" + code +
        ", name=" + name +
        ", inviterCode=" + inviterCode +
        ", inviterInviteCode=" + inviterInviteCode +
        ", inviterMemberCode=" + inviterMemberCode +
        ", inviterMemberName=" + inviterMemberName +
        ", userMemberMoney=" + userMemberMoney +
        ", inviterMemberMoney=" + inviterMemberMoney +
        ", taskNumber=" + taskNumber +
        "}";
    }
}
