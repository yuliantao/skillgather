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
 * @since 2018-11-07
 */
public class PermissionUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自动生成用户ID号，递增模式
     */
    @TableId(value = "UserId", type = IdType.AUTO)
    private Integer UserId;

    @TableField("UserName")
    private String UserName;

    @TableField("Password")
    private String Password;

    @TableField("TrueName")
    private String TrueName;

    @TableField("IsDelete")
    private Boolean IsDelete;


    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer UserId) {
        this.UserId = UserId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getTrueName() {
        return TrueName;
    }

    public void setTrueName(String TrueName) {
        this.TrueName = TrueName;
    }

    public Boolean getIsDelete() {
        return IsDelete;
    }

    public void setIsDelete(Boolean IsDelete) {
        this.IsDelete = IsDelete;
    }

    @Override
    public String toString() {
        return "PermissionUser{" +
        "UserId=" + UserId +
        ", UserName=" + UserName +
        ", Password=" + Password +
        ", TrueName=" + TrueName +
        ", IsDelete=" + IsDelete +
        "}";
    }
}
