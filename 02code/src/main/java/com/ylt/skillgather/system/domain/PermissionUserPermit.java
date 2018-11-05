package com.ylt.skillgather.system.domain;

public class PermissionUserPermit {
    private Integer userid;

    private String rolecodes;

    private String groupcodes;

    private String permitcodes;

    private Boolean isdelete;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getRolecodes() {
        return rolecodes;
    }

    public void setRolecodes(String rolecodes) {
        this.rolecodes = rolecodes == null ? null : rolecodes.trim();
    }

    public String getGroupcodes() {
        return groupcodes;
    }

    public void setGroupcodes(String groupcodes) {
        this.groupcodes = groupcodes == null ? null : groupcodes.trim();
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