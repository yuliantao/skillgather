package com.ylt.skillgather.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 此表兼容了简单的菜单栏控制权限和按钮级别权限控制。针对菜单栏权限可以直接使用此表作为权限表，用户登录后直接获取有权限的菜单在显示。
 * </p>
 *
 * @author yuliantao
 * @since 2018-11-07
 */
public class PermissionModule implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ModuleCode")
    private String ModuleCode;

    @TableField("ModuleName")
    private String ModuleName;

    @TableField("ModuleValue")
    private String ModuleValue;

    @TableField("LinkUrl")
    private String LinkUrl;

    @TableField("ParentModule")
    private String ParentModule;

    @TableField("ModuleDescription")
    private String ModuleDescription;

    @TableField("IsDelete")
    private Boolean IsDelete;


    public String getModuleCode() {
        return ModuleCode;
    }

    public void setModuleCode(String ModuleCode) {
        this.ModuleCode = ModuleCode;
    }

    public String getModuleName() {
        return ModuleName;
    }

    public void setModuleName(String ModuleName) {
        this.ModuleName = ModuleName;
    }

    public String getModuleValue() {
        return ModuleValue;
    }

    public void setModuleValue(String ModuleValue) {
        this.ModuleValue = ModuleValue;
    }

    public String getLinkUrl() {
        return LinkUrl;
    }

    public void setLinkUrl(String LinkUrl) {
        this.LinkUrl = LinkUrl;
    }

    public String getParentModule() {
        return ParentModule;
    }

    public void setParentModule(String ParentModule) {
        this.ParentModule = ParentModule;
    }

    public String getModuleDescription() {
        return ModuleDescription;
    }

    public void setModuleDescription(String ModuleDescription) {
        this.ModuleDescription = ModuleDescription;
    }

    public Boolean getIsDelete() {
        return IsDelete;
    }

    public void setIsDelete(Boolean IsDelete) {
        this.IsDelete = IsDelete;
    }

    @Override
    public String toString() {
        return "PermissionModule{" +
        "ModuleCode=" + ModuleCode +
        ", ModuleName=" + ModuleName +
        ", ModuleValue=" + ModuleValue +
        ", LinkUrl=" + LinkUrl +
        ", ParentModule=" + ParentModule +
        ", ModuleDescription=" + ModuleDescription +
        ", IsDelete=" + IsDelete +
        "}";
    }
}
