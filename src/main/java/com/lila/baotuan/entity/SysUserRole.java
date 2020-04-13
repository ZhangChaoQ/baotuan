package com.lila.baotuan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 用户角色
 * </p>
 *
 * @author Zhang
 * @since 2020-04-13
 */
public class SysUserRole extends Model<SysUserRole> {

    private static final long serialVersionUID=1L;

    /**
     * 用户角色id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 系统用户id
     */
    private Integer systemUserId;

    /**
     * 角色id
     */
    private Integer roleId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSystemUserId() {
        return systemUserId;
    }

    public void setSystemUserId(Integer systemUserId) {
        this.systemUserId = systemUserId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SysUserRole{" +
        "id=" + id +
        ", systemUserId=" + systemUserId +
        ", roleId=" + roleId +
        "}";
    }
}
