package com.ylt.skillgather.ddd.entity;

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
 * @since 2018-11-28
 */
public class PermissionDepartment implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * ID
     */
    @JsonProperty("ID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;


    /**
     * 部门编号
     */
    @JsonProperty("DepartmentCode")
    @TableField("DepartmentCode")
    private String DepartmentCode;


    /**
     * 部门名称
     */
    @JsonProperty("DepartmentName")
    @TableField("DepartmentName")
    private String DepartmentName;


    /**
     * 父级部门
     */
    @JsonProperty("ParentDepartment")
    @TableField("ParentDepartment")
    private String ParentDepartment;


    /**
     * 部门描述
     */
    @JsonProperty("DepartmentDescription")
    @TableField("DepartmentDescription")
    private String DepartmentDescription;


    /**
     * 公司代码
     */
    @JsonProperty("CompanyCode")
    @TableField("CompanyCode")
    private String CompanyCode;


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
    public String getDepartmentCode() {
        return DepartmentCode;
    }

    public void setDepartmentCode(String DepartmentCode) {
        this.DepartmentCode = DepartmentCode;
    }

    @JsonIgnore
    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String DepartmentName) {
        this.DepartmentName = DepartmentName;
    }

    @JsonIgnore
    public String getParentDepartment() {
        return ParentDepartment;
    }

    public void setParentDepartment(String ParentDepartment) {
        this.ParentDepartment = ParentDepartment;
    }

    @JsonIgnore
    public String getDepartmentDescription() {
        return DepartmentDescription;
    }

    public void setDepartmentDescription(String DepartmentDescription) {
        this.DepartmentDescription = DepartmentDescription;
    }

    @JsonIgnore
    public String getCompanyCode() {
        return CompanyCode;
    }

    public void setCompanyCode(String CompanyCode) {
        this.CompanyCode = CompanyCode;
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
        return "PermissionDepartment{" +
        "id=" + id +
        ", DepartmentCode=" + DepartmentCode +
        ", DepartmentName=" + DepartmentName +
        ", ParentDepartment=" + ParentDepartment +
        ", DepartmentDescription=" + DepartmentDescription +
        ", CompanyCode=" + CompanyCode +
        ", IsDelete=" + IsDelete +
        "}";
    }
}
