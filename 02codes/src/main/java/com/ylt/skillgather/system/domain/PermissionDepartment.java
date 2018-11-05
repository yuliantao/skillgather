package com.ylt.skillgather.system.domain;

public class PermissionDepartment {
    private String departmentcode;

    private String departmentname;

    private String parentdepartment;

    private String departmentdescription;

    private String companycode;

    private Boolean isdelete;

    public String getDepartmentcode() {
        return departmentcode;
    }

    public void setDepartmentcode(String departmentcode) {
        this.departmentcode = departmentcode == null ? null : departmentcode.trim();
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname == null ? null : departmentname.trim();
    }

    public String getParentdepartment() {
        return parentdepartment;
    }

    public void setParentdepartment(String parentdepartment) {
        this.parentdepartment = parentdepartment == null ? null : parentdepartment.trim();
    }

    public String getDepartmentdescription() {
        return departmentdescription;
    }

    public void setDepartmentdescription(String departmentdescription) {
        this.departmentdescription = departmentdescription == null ? null : departmentdescription.trim();
    }

    public String getCompanycode() {
        return companycode;
    }

    public void setCompanycode(String companycode) {
        this.companycode = companycode == null ? null : companycode.trim();
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}