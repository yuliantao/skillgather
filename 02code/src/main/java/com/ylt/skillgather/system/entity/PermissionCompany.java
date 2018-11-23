package com.ylt.skillgather.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <p>
 * 公司
 * </p>
 *
 * @author yuliantao
 * @since 2018-11-23
 */
public class PermissionCompany implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * ID
     */
    @JsonProperty("ID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;


    /**
     * 公司编码
     */
    @JsonProperty("CompanyCode")
    @TableField("CompanyCode")
    private String CompanyCode;


    /**
     * 公司名称
     */
    @JsonProperty("CompanyName")
    @TableField("CompanyName")
    private String CompanyName;


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
    public String getCompanyCode() {
        return CompanyCode;
    }

    public void setCompanyCode(String CompanyCode) {
        this.CompanyCode = CompanyCode;
    }

    @JsonIgnore
    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
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
        return "PermissionCompany{" +
        "id=" + id +
        ", CompanyCode=" + CompanyCode +
        ", CompanyName=" + CompanyName +
        ", IsDelete=" + IsDelete +
        "}";
    }
}
