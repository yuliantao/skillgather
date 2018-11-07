package com.ylt.skillgather.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuliantao
 * @since 2018-11-07
 */
public class PermissionAction implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ActionCode")
    private String ActionCode;

    @TableField("ActionName")
    private String ActionName;

    @TableField("ActionValue")
    private String ActionValue;

    @TableField("IsDelete")
    private Boolean IsDelete;


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
        "ActionCode=" + ActionCode +
        ", ActionName=" + ActionName +
        ", ActionValue=" + ActionValue +
        ", IsDelete=" + IsDelete +
        "}";
    }
}
