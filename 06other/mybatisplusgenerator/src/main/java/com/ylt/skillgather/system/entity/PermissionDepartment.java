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
 * @since 2018-11-09
 */
public class PermissionDepartment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    @TableField("DepartmentCode")
    private String DepartmentCode;

    @TableField("DepartmentName")
    private String DepartmentName;

    @TableField("ParentDepartment")
    private String ParentDepartment;

    @TableField("DepartmentDescription")
    private String DepartmentDescription;

    @TableField("CompanyCode")
    private String CompanyCode;

    @TableField("IsDelete")
    private Boolean IsDelete;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentCode() {
        return DepartmentCode;
    }

    public void setDepartmentCode(String DepartmentCode) {
        this.DepartmentCode = DepartmentCode;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String DepartmentName) {
        this.DepartmentName = DepartmentName;
    }

    public String getParentDepartment() {
        return ParentDepartment;
    }

    public void setParentDepartment(String ParentDepartment) {
        this.ParentDepartment = ParentDepartment;
    }

    public String getDepartmentDescription() {
        return DepartmentDescription;
    }

    public void setDepartmentDescription(String DepartmentDescription) {
        this.DepartmentDescription = DepartmentDescription;
    }

    public String getCompanyCode() {
        return CompanyCode;
    }

    public void setCompanyCode(String CompanyCode) {
        this.CompanyCode = CompanyCode;
    }

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
