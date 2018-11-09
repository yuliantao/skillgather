package com.ylt.skillgather.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuliantao
 * @since 2018-11-09
 */
public class PermissionAction implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    @TableField("ActionCode")
    private String ActionCode;

    @TableField("ActionName")
    private String ActionName;

    @TableField("ActionValue")
    private String ActionValue;

    @TableField("IsDelete")
    private Boolean IsDelete;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActionCode() {
        return ActionCode;
    }

    public void setActionCode(String ActionCode) {
        this.ActionCode = ActionCode;
    }

    public String getActionName() {
        return ActionName;
    }

    public void setActionName(String ActionName) {
        this.ActionName = ActionName;
    }

    public String getActionValue() {
        return ActionValue;
    }

    public void setActionValue(String ActionValue) {
        this.ActionValue = ActionValue;
    }

    public Boolean getIsDelete() {
        return IsDelete;
    }

    public void setIsDelete(Boolean IsDelete) {
        this.IsDelete = IsDelete;
    }

    @Override
    public String toString() {
        return "PermissionAction{" +
        "id=" + id +
        ", ActionCode=" + ActionCode +
        ", ActionName=" + ActionName +
        ", ActionValue=" + ActionValue +
        ", IsDelete=" + IsDelete +
        "}";
    }
}
