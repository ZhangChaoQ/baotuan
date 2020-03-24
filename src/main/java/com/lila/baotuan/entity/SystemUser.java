package com.lila.baotuan.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 后台用户
 * </p>
 *
 * @author Zhang
 * @since 2020-03-24
 */
@TableName("system_user")
public class SystemUser extends Model<SystemUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 后台用户id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 后台用户姓名
     */
	private String name;
    /**
     * 登录账号
     */
	@TableField("login_name")
	private String loginName;
    /**
     * 密码
     */
	private String password;


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

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "SystemUser{" +
			", id=" + id +
			", name=" + name +
			", loginName=" + loginName +
			", password=" + password +
			"}";
	}
}
