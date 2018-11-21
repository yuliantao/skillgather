package com.ylt.skillgather.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuliantao
 * @since 2018-11-21
 */
public class PermissionPermit implements Serializable {

    private static final long serialVersionUID = 1L;


    @JsonProperty("ID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;


    @JsonProperty("PermitCode")
    @TableField("PermitCode")
    private String PermitCode;


    @JsonProperty("ModuleCode")
    @TableField("ModuleCode")
    private String ModuleCode;


    @JsonProperty("ActionCode")
    @TableField("ActionCode")
    private String ActionCode;


    @JsonProperty("PermitValue")
    @TableField("PermitValue")
    private String PermitValue;


    @JsonProperty("IsDelete")
    @TableField("IsDelete")
    private Boolean IsDelete;


    @JsonIgnore
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonIgnore
    public String getPermitCode() {
        return PermitCode;
    }

    public void setPermitCode(String PermitCode) {
        this.PermitCode = PermitCode;
    }

    @JsonIgnore
    public String getModuleCode() {
        return ModuleCode;
    }

    public void setModuleCode(String ModuleCode) {
        this.ModuleCode = ModuleCode;
    }

    @JsonIgnore
    public String getActionCode() {
        return ActionCode;
    }

    public void setActionCode(String ActionCode) {
        this.ActionCode = ActionCode;
    }

    @JsonIgnore
    public String getPermitValue() {
        return PermitValue;
    }

    public void setPermitValue(String PermitValue) {
        this.PermitValue = PermitValue;
    }

    @JsonIgnore
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
