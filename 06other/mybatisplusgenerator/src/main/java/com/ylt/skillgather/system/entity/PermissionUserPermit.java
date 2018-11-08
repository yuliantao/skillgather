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
public class PermissionUserPermit implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("UserId")
    private Integer UserId;

    @TableField("RoleCodes")
    private String RoleCodes;

    @TableField("GroupCodes")
    private String GroupCodes;

    @TableField("PermitCodes")
    private String PermitCodes;

    @TableField("IsDelete")
    private Boolean IsDelete;


    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer UserId) {
        this.UserId = UserId;
    }

    public String getRoleCodes() {
        return RoleCodes;
    }

    public void setRoleCodes(String RoleCodes) {
        this.RoleCodes = RoleCodes;
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

    public Boolean getIsDelete() {
        return IsDelete;
    }

    public void setIsDelete(Boolean IsDelete) {
        this.IsDelete = IsDelete;
    }

    @Override
    public String toString() {
        return "PermissionUserPermit{" +
        "UserId=" + UserId +
        ", RoleCodes=" + RoleCodes +
        ", GroupCodes=" + GroupCodes +
        ", PermitCodes=" + PermitCodes +
        ", IsDelete=" + IsDelete +
        "}";
    }
}
