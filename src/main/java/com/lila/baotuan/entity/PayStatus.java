package com.lila.baotuan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 支付状态
 * </p>
 *
 * @author Zhang
 * @since 2020-04-20
 */
public class PayStatus extends Model<PayStatus> {

    private static final long serialVersionUID=1L;

    /**
     * 支付状态id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 支付状态编码
     */
    private String code;

    /**
     * 支付状态名称
     */
    private String name;

    /**
     * 支付状态说明
     */
    private String description;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "PayStatus{" +
        "id=" + id +
        ", code=" + code +
        ", name=" + name +
        ", description=" + description +
        "}";
    }
}
