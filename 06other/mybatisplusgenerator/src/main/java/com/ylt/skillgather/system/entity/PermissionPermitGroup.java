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
public class PermissionPermitGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("GroupCode")
    private String GroupCode;

    @TableField("GroupName")
    private String GroupName;

    @TableField("PermitCodes")
    private String PermitCodes;

    @TableField("IsDelete")
    private Boolean IsDelete;


    public String getGroupCode() {
        return GroupCode;
    }

    public void setGroupCode(String GroupCode) {
        this.GroupCode = GroupCode;
    }

    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String GroupName) {
        this.GroupName = GroupName;
    }

    public String getPermitCodes() {
        return PermitCodes;
    }

    public void setPermitCodes(String PermitCodes) {
        this.PermitCodes = PermitCodes;
    }

    public Boolean getIsDelete() {
        return IsDelete;
    }

    public void setIsDelete(Boolean IsDelete) {
        this.IsDelete = IsDelete;
    }

    @Override
    public String toString() {
        return "PermissionPermitGroup{" +
        "GroupCode=" + GroupCode +
        ", GroupName=" + GroupName +
        ", PermitCodes=" + PermitCodes +
        ", IsDelete=" + IsDelete +
        "}";
    }
}
