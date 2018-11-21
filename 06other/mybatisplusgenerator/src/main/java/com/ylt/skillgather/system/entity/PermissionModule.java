package com.ylt.skillgather.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <p>
 * 此表兼容了简单的菜单栏控制权限和按钮级别权限控制。针对菜单栏权限可以直接使用此表作为权限表，用户登录后直接获取有权限的菜单在显示。
 * </p>
 *
 * @author yuliantao
 * @since 2018-11-21
 */
public class PermissionModule implements Serializable {

    private static final long serialVersionUID = 1L;


    @JsonProperty("ID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;


    @JsonProperty("ModuleCode")
    @TableField("ModuleCode")
    private String ModuleCode;


    @JsonProperty("ModuleName")
    @TableField("ModuleName")
    private String ModuleName;


    @JsonProperty("ModuleValue")
    @TableField("ModuleValue")
    private String ModuleValue;


    @JsonProperty("LinkUrl")
    @TableField("LinkUrl")
    private String LinkUrl;


    @JsonProperty("ParentModule")
    @TableField("ParentModule")
    private String ParentModule;


    @JsonProperty("ModuleDescription")
    @TableField("ModuleDescription")
    private String ModuleDescription;


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
    public String getModuleCode() {
        return ModuleCode;
    }

    public void setModuleCode(String ModuleCode) {
        this.ModuleCode = ModuleCode;
    }

    @JsonIgnore
    public String getModuleName() {
        return ModuleName;
    }

    public void setModuleName(String ModuleName) {
        this.ModuleName = ModuleName;
    }

    @JsonIgnore
    public String getModuleValue() {
        return ModuleValue;
    }

    public void setModuleValue(String ModuleValue) {
        this.ModuleValue = ModuleValue;
    }

    @JsonIgnore
    public String getLinkUrl() {
        return LinkUrl;
    }

    public void setLinkUrl(String LinkUrl) {
        this.LinkUrl = LinkUrl;
    }

    @JsonIgnore
    public String getParentModule() {
        return ParentModule;
    }

    public void setParentModule(String ParentModule) {
        this.ParentModule = ParentModule;
    }

    @JsonIgnore
    public String getModuleDescription() {
        return ModuleDescription;
    }

    public void setModuleDescription(String ModuleDescription) {
        this.ModuleDescription = ModuleDescription;
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
        return "PermissionModule{" +
        "id=" + id +
        ", ModuleCode=" + ModuleCode +
        ", ModuleName=" + ModuleName +
        ", ModuleValue=" + ModuleValue +
        ", LinkUrl=" + LinkUrl +
        ", ParentModule=" + ParentModule +
        ", ModuleDescription=" + ModuleDescription +
        ", IsDelete=" + IsDelete +
        "}";
    }
}
