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
public class PermissionPermit implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    @TableField("PermitCode")
    private String PermitCode;

    @TableField("ModuleCode")
    private String ModuleCode;

    @TableField("ActionCode")
    private String ActionCode;

    @TableField("PermitValue")
    private String PermitValue;

    @TableField("IsDelete")
    private Boolean IsDelete;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermitCode() {
        return PermitCode;
    }

    public void setPermitCode(String PermitCode) {
        this.PermitCode = PermitCode;
    }

    public String getModuleCode() {
        return ModuleCode;
    }

    public void setModuleCode(String ModuleCode) {
        this.ModuleCode = ModuleCode;
    }

    public String getActionCode() {
        return ActionCode;
    }

    public void setActionCode(String ActionCode) {
        this.ActionCode = ActionCode;
    }

    public String getPermitValue() {
        return PermitValue;
    }

    public void setPermitValue(String PermitValue) {
        this.PermitValue = PermitValue;
    }

    public Boolean getIsDelete() {
        return IsDelete;
    }

    public void setIsDelete(Boolean IsDelete) {
        this.IsDelete = IsDelete;
    }

    @Override
    public String toString() {
        return "PermissionPermit{" +
        "id=" + id +
        ", PermitCode=" + PermitCode +
        ", ModuleCode=" + ModuleCode +
        ", ActionCode=" + ActionCode +
        ", PermitValue=" + PermitValue +
        ", IsDelete=" + IsDelete +
        "}";
    }
}
