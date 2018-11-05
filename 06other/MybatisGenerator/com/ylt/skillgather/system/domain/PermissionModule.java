package com.ylt.skillgather.system.domain;

public class PermissionModule {
    private String modulecode;

    private String modulename;

    private String modulevalue;

    private String linkurl;

    private String parentmodule;

    private String moduledescription;

    private Boolean isdelete;

    public String getModulecode() {
        return modulecode;
    }

    public void setModulecode(String modulecode) {
        this.modulecode = modulecode == null ? null : modulecode.trim();
    }

    public String getModulename() {
        return modulename;
    }

    public void setModulename(String modulename) {
        this.modulename = modulename == null ? null : modulename.trim();
    }

    public String getModulevalue() {
        return modulevalue;
    }

    public void setModulevalue(String modulevalue) {
        this.modulevalue = modulevalue == null ? null : modulevalue.trim();
    }

    public String getLinkurl() {
        return linkurl;
    }

    public void setLinkurl(String linkurl) {
        this.linkurl = linkurl == null ? null : linkurl.trim();
    }

    public String getParentmodule() {
        return parentmodule;
    }

    public void setParentmodule(String parentmodule) {
        this.parentmodule = parentmodule == null ? null : parentmodule.trim();
    }

    public String getModuledescription() {
        return moduledescription;
    }

    public void setModuledescription(String moduledescription) {
        this.moduledescription = moduledescription == null ? null : moduledescription.trim();
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}