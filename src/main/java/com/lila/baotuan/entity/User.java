package com.lila.baotuan.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author Zhang
 * @since 2020-03-24
 */
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

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
	@TableField("invite_code")
	private String inviteCode;
    /**
     * 推广人(用户编码)
     */
	@TableField("user_code")
	private String userCode;
    /**
     * 支付宝账号
     */
	@TableField("zfb_account")
	private String zfbAccount;
    /**
     * 支付宝二维码
     */
	@TableField("zfb_url")
	private Integer zfbUrl;
    /**
     * 余额
     */
	private Double money;
    /**
     * 会员等级
     */
	@TableField("member_code")
	private String memberCode;


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

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
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

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	@Override
	protected Serializable pkVal() {
		return this.code;
	}

	@Override
	public String toString() {
		return "User{" +
			", code=" + code +
			", phone=" + phone +
			", password=" + password +
			", inviteCode=" + inviteCode +
			", userCode=" + userCode +
			", zfbAccount=" + zfbAccount +
			", zfbUrl=" + zfbUrl +
			", money=" + money +
			", memberCode=" + memberCode +
			"}";
	}
}
