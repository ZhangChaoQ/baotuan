package com.lila.baotuan.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;

/**
 * <p>
 * 公告
 * </p>
 *
 * @author Zhang
 * @since 2020-03-24
 */
public class Notic extends Model<Notic> {

    private static final long serialVersionUID = 1L;

    /**
     * 公告id
     */
	private Integer id;
    /**
     * 标题
     */
	private String title;
    /**
     * 内容
     */
	private String context;
    /**
     * 创建时间
     */
	private Date createtime;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Notic{" +
			", id=" + id +
			", title=" + title +
			", context=" + context +
			", createtime=" + createtime +
			"}";
	}
}
