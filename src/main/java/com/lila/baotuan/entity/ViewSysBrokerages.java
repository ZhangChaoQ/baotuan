package com.lila.baotuan.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * View 'baotuan.view_sys_brokerages' references invalid table(s) or column(s) or function(s) or definer/invoker of view lack rights to use them
 * </p>
 *
 * @author Zhang
 * @since 2020-04-20
 */
public class ViewSysBrokerages extends Model<ViewSysBrokerages> {

    private static final long serialVersionUID=1L;


    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "ViewSysBrokerages{" +
        "}";
    }
}
