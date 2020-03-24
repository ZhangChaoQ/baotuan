package com.lila.baotuan.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 提现记录
 * </p>
 *
 * @author Zhang
 * @since 2020-03-24
 */
@TableName("withdrawals_records")
public class WithdrawalsRecords extends Model<WithdrawalsRecords> {

    private static final long serialVersionUID = 1L;

    /**
     * 提现记录id
     */
	private Integer id;
    /**
     * 提现人
     */
	@TableField("user_code")
	private String userCode;
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

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
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
			", userCode=" + userCode +
			", createtime=" + createtime +
			", overtime=" + overtime +
			"}";
	}
}
