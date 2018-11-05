package com.ylt.skillgather.system.domain;

public class PermissionPermitGroup {
    private String groupcode;

    private String groupname;

    private String permitcodes;

    private Boolean isdelete;

    public String getGroupcode() {
        return groupcode;
    }

    public void setGroupcode(String groupcode) {
        this.groupcode = groupcode == null ? null : groupcode.trim();
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname == null ? null : groupname.trim();
    }

    public String getPermitcodes() {
        return permitcodes;
    }

    public void setPermitcodes(String permitcodes) {
        this.permitcodes = permitcodes == null ? null : permitcodes.trim();
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}