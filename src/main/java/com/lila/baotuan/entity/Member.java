package com.lila.baotuan.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 会员
 * </p>
 *
 * @author Zhang
 * @since 2020-03-25
 */
public class Member extends Model<Member> {

    private static final long serialVersionUID = 1L;

    /**
     * 会员等级id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 会员等级编码
     */
	private String code;
    /**
     * 会员名称
     */
	private String name;
    /**
     * 会员权益
     */
	private String context;
    /**
     * 会员价格
     */
	private Double money;
    /**
     * 支付宝二维码
     */
	private Integer url;


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

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Integer getUrl() {
		return url;
	}

	public void setUrl(Integer url) {
		this.url = url;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Member{" +
			", id=" + id +
			", code=" + code +
			", name=" + name +
			", context=" + context +
			", money=" + money +
			", url=" + url +
			"}";
	}
}
