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
public class PermissionPermitGroup implements Serializable {

    private static final long serialVersionUID = 1L;


    @JsonProperty("ID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;


    @JsonProperty("GroupCode")
    @TableField("GroupCode")
    private String GroupCode;


    @JsonProperty("GroupName")
    @TableField("GroupName")
    private String GroupName;


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
    public String getGroupCode() {
        return GroupCode;
    }

    public void setGroupCode(String GroupCode) {
        this.GroupCode = GroupCode;
    }

    @JsonIgnore
    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String GroupName) {
        this.GroupName = GroupName;
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
        return "PermissionPermitGroup{" +
        "id=" + id +
        ", GroupCode=" + GroupCode +
        ", GroupName=" + GroupName +
        ", PermitCodes=" + PermitCodes +
        ", IsDelete=" + IsDelete +
        "}";
    }
}
