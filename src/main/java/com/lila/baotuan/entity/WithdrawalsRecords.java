package com.lila.baotuan.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 提现记录
 * </p>
 *
 * @author Zhang
 * @since 2020-03-25
 */
@TableName("withdrawals_records")
public class WithdrawalsRecords extends Model<WithdrawalsRecords> {

    private static final long serialVersionUID = 1L;

    /**
     * 提现记录id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 提现人id
     */
	@TableField("user_id")
	private Integer userId;
    /**
     * 提款金额
     */
	private Double money;
    /**
     * 支付金额
     */
	@TableField("pay_money")
	private Double payMoney;
    /**
     * 提现时间
     */
	private Date createtime;
    /**
     * 到款时间
     */
	private Date overtime;


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

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getOvertime() {
		return overtime;
	}

	public void setOvertime(Date overtime) {
		this.overtime = overtime;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "WithdrawalsRecords{" +
			", id=" + id +
			", userId=" + userId +
			", money=" + money +
			", payMoney=" + payMoney +
			", createtime=" + createtime +
			", overtime=" + overtime +
			"}";
	}
}
