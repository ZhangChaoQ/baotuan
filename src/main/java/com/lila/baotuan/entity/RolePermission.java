package com.lila.baotuan.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 角色权限
 * </p>
 *
 * @author Zhang
 * @since 2020-03-25
 */
@TableName("role_permission")
public class RolePermission extends Model<RolePermission> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色权限id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 角色id
     */
	@TableField("role_id")
	private Integer roleId;
    /**
     * 权限id
     */
	@TableField("permission_id")
	private Integer permissionId;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "RolePermission{" +
			", id=" + id +
			", roleId=" + roleId +
			", permissionId=" + permissionId +
			"}";
	}
}
