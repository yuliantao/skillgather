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
 * @since 2018-11-08
 */
public class PermissionRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("RoleCode")
    private String RoleCode;

    @TableField("RoleName")
    private String RoleName;

    @TableField("RoleDescription")
    private String RoleDescription;

    @TableField("GroupCodes")
    private String GroupCodes;

    @TableField("PermitCodes")
    private String PermitCodes;

    @TableField("ParentRole")
    private String ParentRole;

    @TableField("IsDelete")
    private Boolean IsDelete;


    public String getRoleCode() {
        return RoleCode;
    }

    public void setRoleCode(String RoleCode) {
        this.RoleCode = RoleCode;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String RoleName) {
        this.RoleName = RoleName;
    }

    public String getRoleDescription() {
        return RoleDescription;
    }

    public void setRoleDescription(String RoleDescription) {
        this.RoleDescription = RoleDescription;
    }

    public String getGroupCodes() {
        return GroupCodes;
    }

    public void setGroupCodes(String GroupCodes) {
        this.GroupCodes = GroupCodes;
    }

    public String getPermitCodes() {
        return PermitCodes;
    }

    public void setPermitCodes(String PermitCodes) {
        this.PermitCodes = PermitCodes;
    }

    public String getParentRole() {
        return ParentRole;
    }

    public void setParentRole(String ParentRole) {
        this.ParentRole = ParentRole;
    }

    public Boolean getIsDelete() {
        return IsDelete;
    }

    public void setIsDelete(Boolean IsDelete) {
        this.IsDelete = IsDelete;
    }

    @Override
    public String toString() {
        return "PermissionRole{" +
        "RoleCode=" + RoleCode +
        ", RoleName=" + RoleName +
        ", RoleDescription=" + RoleDescription +
        ", GroupCodes=" + GroupCodes +
        ", PermitCodes=" + PermitCodes +
        ", ParentRole=" + ParentRole +
        ", IsDelete=" + IsDelete +
        "}";
    }
}
