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
 * @since 2018-11-23
 */
public class PermissionRole implements Serializable {

    private static final long serialVersionUID = 1L;


    @JsonProperty("ID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;


    @JsonProperty("RoleCode")
    @TableField("RoleCode")
    private String RoleCode;


    @JsonProperty("RoleName")
    @TableField("RoleName")
    private String RoleName;


    @JsonProperty("RoleDescription")
    @TableField("RoleDescription")
    private String RoleDescription;


    @JsonProperty("GroupCodes")
    @TableField("GroupCodes")
    private String GroupCodes;


    @JsonProperty("PermitCodes")
    @TableField("PermitCodes")
    private String PermitCodes;


    @JsonProperty("ParentRole")
    @TableField("ParentRole")
    private String ParentRole;


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
    public String getRoleCode() {
        return RoleCode;
    }

    public void setRoleCode(String RoleCode) {
        this.RoleCode = RoleCode;
    }

    @JsonIgnore
    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String RoleName) {
        this.RoleName = RoleName;
    }

    @JsonIgnore
    public String getRoleDescription() {
        return RoleDescription;
    }

    public void setRoleDescription(String RoleDescription) {
        this.RoleDescription = RoleDescription;
    }

    @JsonIgnore
    public String getGroupCodes() {
        return GroupCodes;
    }

    public void setGroupCodes(String GroupCodes) {
        this.GroupCodes = GroupCodes;
    }

    @JsonIgnore
    public String getPermitCodes() {
        return PermitCodes;
    }

    public void setPermitCodes(String PermitCodes) {
        this.PermitCodes = PermitCodes;
    }

    @JsonIgnore
    public String getParentRole() {
        return ParentRole;
    }

    public void setParentRole(String ParentRole) {
        this.ParentRole = ParentRole;
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
        return "PermissionRole{" +
        "id=" + id +
        ", RoleCode=" + RoleCode +
        ", RoleName=" + RoleName +
        ", RoleDescription=" + RoleDescription +
        ", GroupCodes=" + GroupCodes +
        ", PermitCodes=" + PermitCodes +
        ", ParentRole=" + ParentRole +
        ", IsDelete=" + IsDelete +
        "}";
    }
}
