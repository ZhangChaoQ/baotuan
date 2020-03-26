package com.lila.baotuan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author Zhang
 * @since 2020-03-26
 */
public class User extends Model<User> {

    private static final long serialVersionUID=1L;

    /**
     * 用户id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "User{" +
        "id=" + id +
        ", name=" + name +
        ", code=" + code +
        ", phone=" + phone +
        ", password=" + password +
        ", inviteCode=" + inviteCode +
        ", userId=" + userId +
        ", zfbAccount=" + zfbAccount +
        ", zfbUrl=" + zfbUrl +
        ", money=" + money +
        ", memberId=" + memberId +
        ", enabled=" + enabled +
        "}";
    }
}
