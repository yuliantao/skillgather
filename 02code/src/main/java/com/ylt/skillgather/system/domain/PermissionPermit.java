package com.ylt.skillgather.system.domain;

public class PermissionPermit {
    private String permitcode;

    private String modulecode;

    private String actioncode;

    private String permitvalue;

    private Boolean isdelete;

    public String getPermitcode() {
        return permitcode;
    }

    public void setPermitcode(String permitcode) {
        this.permitcode = permitcode == null ? null : permitcode.trim();
    }

    public String getModulecode() {
        return modulecode;
    }

    public void setModulecode(String modulecode) {
        this.modulecode = modulecode == null ? null : modulecode.trim();
    }

    public String getActioncode() {
        return actioncode;
    }

    public void setActioncode(String actioncode) {
        this.actioncode = actioncode == null ? null : actioncode.trim();
    }

    public String getPermitvalue() {
        return permitvalue;
    }

    public void setPermitvalue(String permitvalue) {
        this.permitvalue = permitvalue == null ? null : permitvalue.trim();
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}