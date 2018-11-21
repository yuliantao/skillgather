package com.ylt.skillgather.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <p>
 * 实现用户动态的新增、修改、删除、查看、查询等基本功能！
 * </p>
 *
 * @author yuliantao
 * @since 2018-11-21
 */
public class PermissionUser implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * ID
     */
    @JsonProperty("ID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;


    /**
     * 用户名
     */
    @JsonProperty("UserName")
    @TableField("UserName")
    private String UserName;


    /**
     * 密码
     */
    @JsonProperty("Password")
    @TableField("Password")
    private String Password;


    /**
     * 真实姓名
     */
    @JsonProperty("TrueName")
    @TableField("TrueName")
    private String TrueName;


    /**
     * 是否删除
     */
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
    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    @JsonIgnore
    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    @JsonIgnore
    public String getTrueName() {
        return TrueName;
    }

    public void setTrueName(String TrueName) {
        this.TrueName = TrueName;
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
        return "PermissionUser{" +
        "id=" + id +
        ", UserName=" + UserName +
        ", Password=" + Password +
        ", TrueName=" + TrueName +
        ", IsDelete=" + IsDelete +
        "}";
    }
}
