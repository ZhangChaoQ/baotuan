package com.lila.baotuan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 会员
 * </p>
 *
 * @author Zhang
 * @since 2020-04-21
 */
public class Member extends Model<Member> {

    private static final long serialVersionUID=1L;

    /**
     * 会员等级id
     */
    @TableId(value = "id", type = IdType.AUTO)
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
     * 升级费用
     */
    private Double upMoney;

    /**
     * 没日任务数量
     */
    private Integer taskNumber;

    /**
     * 支付宝二维码
     */
    private Integer url;

    /**
     * 升级二维码
     */
    private Integer upUrl;


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

    public Double getUpMoney() {
        return upMoney;
    }

    public void setUpMoney(Double upMoney) {
        this.upMoney = upMoney;
    }

    public Integer getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(Integer taskNumber) {
        this.taskNumber = taskNumber;
    }

    public Integer getUrl() {
        return url;
    }

    public void setUrl(Integer url) {
        this.url = url;
    }

    public Integer getUpUrl() {
        return upUrl;
    }

    public void setUpUrl(Integer upUrl) {
        this.upUrl = upUrl;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Member{" +
        "id=" + id +
        ", code=" + code +
        ", name=" + name +
        ", context=" + context +
        ", money=" + money +
        ", upMoney=" + upMoney +
        ", taskNumber=" + taskNumber +
        ", url=" + url +
        ", upUrl=" + upUrl +
        "}";
    }
}
