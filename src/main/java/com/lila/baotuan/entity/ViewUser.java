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
 * @since 2020-04-21
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
    private String code;

    /**
     * 用户姓名
     */
    private String name;

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
     * 创建时间
     */
    private LocalDateTime createtime;

    /**
     * 会员等级编码
     */
    private String memberCode;

    /**
     * 会员名称
     */
    private String memberName;

    /**
     * 会员价格
     */
    private Double userMemberMoney;

    /**
     * 没日任务数量
     */
    private Integer taskNumber;

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
    private Double inviterMemberMoney;

    /**
     * 上传路径
     */
    private String url;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public void setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Double getUserMemberMoney() {
        return userMemberMoney;
    }

    public void setUserMemberMoney(Double userMemberMoney) {
        this.userMemberMoney = userMemberMoney;
    }

    public Integer getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(Integer taskNumber) {
        this.taskNumber = taskNumber;
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

    public Double getInviterMemberMoney() {
        return inviterMemberMoney;
    }

    public void setInviterMemberMoney(Double inviterMemberMoney) {
        this.inviterMemberMoney = inviterMemberMoney;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "ViewUser{" +
        "id=" + id +
        ", code=" + code +
        ", name=" + name +
        ", phone=" + phone +
        ", password=" + password +
        ", inviteCode=" + inviteCode +
        ", userId=" + userId +
        ", alipayName=" + alipayName +
        ", alipayAccount=" + alipayAccount +
        ", alipayUrl=" + alipayUrl +
        ", money=" + money +
        ", memberId=" + memberId +
        ", enabled=" + enabled +
        ", createtime=" + createtime +
        ", memberCode=" + memberCode +
        ", memberName=" + memberName +
        ", userMemberMoney=" + userMemberMoney +
        ", taskNumber=" + taskNumber +
        ", inviterCode=" + inviterCode +
        ", inviterInviteCode=" + inviterInviteCode +
        ", inviterMemberCode=" + inviterMemberCode +
        ", inviterMemberName=" + inviterMemberName +
        ", inviterMemberMoney=" + inviterMemberMoney +
        ", url=" + url +
        "}";
    }
}
