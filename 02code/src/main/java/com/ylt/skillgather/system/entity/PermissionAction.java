package com.ylt.skillgather.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * <p>
 * 操作
 * </p>
 *
 * @author yuliantao
 * @since 2018-11-20
 */
public class PermissionAction implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * ID
     */
    @JsonProperty("ID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;


    /**
     * 操作码
     */
    @JsonProperty("ActionCode")
    @TableField("ActionCode")
    private String ActionCode;


    /**
     * 操作名
     */
    @JsonProperty("ActionName")
    @TableField("ActionName")
    private String ActionName;


    /**
     * 操作值
     */
    @JsonProperty("ActionValue")
    @TableField("ActionValue")
    private String ActionValue;


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
    public String getActionCode() {
        return ActionCode;
    }

    public void setActionCode(String ActionCode) {
        this.ActionCode = ActionCode;
    }

    @JsonIgnore
    public String getActionName() {
        return ActionName;
    }

    public void setActionName(String ActionName) {
        this.ActionName = ActionName;
    }

    @JsonIgnore
    public String getActionValue() {
        return ActionValue;
    }

    public void setActionValue(String ActionValue) {
        this.ActionValue = ActionValue;
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
        return "PermissionAction{" +
        "id=" + id +
        ", ActionCode=" + ActionCode +
        ", ActionName=" + ActionName +
        ", ActionValue=" + ActionValue +
        ", IsDelete=" + IsDelete +
        "}";
    }
}
