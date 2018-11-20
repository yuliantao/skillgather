package com.ylt.skillgather.system.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuliantao
 * @since 2018-11-09
 */
public class PermissionAction implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("ID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    @JsonProperty("ActionCode")
    @TableField("ActionCode")
    private String ActionCode;

    @JsonProperty("ActionName")
    @TableField("ActionName")
    private String ActionName;

    @JsonProperty("ActionValue")
     @TableField("ActionValue")
    private String ActionValue;

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
