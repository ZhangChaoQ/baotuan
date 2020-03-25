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
 * 上传文件表
 * </p>
 *
 * @author Zhang
 * @since 2020-03-25
 */
@TableName("upload_file")
public class UploadFile extends Model<UploadFile> {

    private static final long serialVersionUID = 1L;

    /**
     * 上传文件id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 上传文件名称
     */
	private String name;
    /**
     * 上传人编码
     */
	@TableField("user_code")
	private String userCode;
    /**
     * 上传路径
     */
	private String url;
    /**
     * 上传文件大小
     */
	private Double size;
    /**
     * 上传时间
     */
	private Date createtime;


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

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
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
		return "UploadFile{" +
			", id=" + id +
			", name=" + name +
			", userCode=" + userCode +
			", url=" + url +
			", size=" + size +
			", createtime=" + createtime +
			"}";
	}
}
