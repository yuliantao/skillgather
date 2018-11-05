package com.ylt.skillgather.system.domain;

public class PermissionAction {
    private String actioncode;

    private String actionname;

    private String actionvalue;

    private Boolean isdelete;

    public String getActioncode() {
        return actioncode;
    }

    public void setActioncode(String actioncode) {
        this.actioncode = actioncode == null ? null : actioncode.trim();
    }

    public String getActionname() {
        return actionname;
    }

    public void setActionname(String actionname) {
        this.actionname = actionname == null ? null : actionname.trim();
    }

    public String getActionvalue() {
        return actionvalue;
    }

    public void setActionvalue(String actionvalue) {
        this.actionvalue = actionvalue == null ? null : actionvalue.trim();
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}