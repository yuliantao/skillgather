package com.ylt.skillgather.system.domain;

public class PermissionRole {
    private String rolecode;

    private String rolename;

    private String roledescription;

    private String groupcodes;

    private String permitcodes;

    private String parentrole;

    private Boolean isdelete;

    public String getRolecode() {
        return rolecode;
    }

    public void setRolecode(String rolecode) {
        this.rolecode = rolecode == null ? null : rolecode.trim();
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public String getRoledescription() {
        return roledescription;
    }

    public void setRoledescription(String roledescription) {
        this.roledescription = roledescription == null ? null : roledescription.trim();
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

    public String getParentrole() {
        return parentrole;
    }

    public void setParentrole(String parentrole) {
        this.parentrole = parentrole == null ? null : parentrole.trim();
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}