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
public class PermissionUserPermit implements Serializable {

    private static final long serialVersionUID = 1L;


    @JsonProperty("ID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;


    @JsonProperty("UserId")
    @TableField("UserId")
    private Integer UserId;


    @JsonProperty("RoleCodes")
    @TableField("RoleCodes")
    private String RoleCodes;


    @JsonProperty("GroupCodes")
    @TableField("GroupCodes")
    private String GroupCodes;


    @JsonProperty("PermitCodes")
    @TableField("PermitCodes")
    private String PermitCodes;


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
    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer UserId) {
        this.UserId = UserId;
    }

    @JsonIgnore
    public String getRoleCodes() {
        return RoleCodes;
    }

    public void setRoleCodes(String RoleCodes) {
        this.RoleCodes = RoleCodes;
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
    public Boolean getIsDelete() {
        return IsDelete;
    }

    public void setIsDelete(Boolean IsDelete) {
        this.IsDelete = IsDelete;
    }

    @Override
    public String toString() {
        return "PermissionUserPermit{" +
        "id=" + id +
        ", UserId=" + UserId +
        ", RoleCodes=" + RoleCodes +
        ", GroupCodes=" + GroupCodes +
        ", PermitCodes=" + PermitCodes +
        ", IsDelete=" + IsDelete +
        "}";
    }
}
