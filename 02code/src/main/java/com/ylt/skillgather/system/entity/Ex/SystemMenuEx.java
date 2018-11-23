package com.ylt.skillgather.system.entity.Ex;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ylt.skillgather.system.entity.SystemMenu;

import java.util.List;


public class SystemMenuEx extends SystemMenu {


    @JsonProperty("lists")
    List<SystemMenuEx> lists;

    public void setLists(List<SystemMenuEx> lists) {
        this.lists = lists;
    }
    @JsonIgnore
    public List<SystemMenuEx> getLists() {
        return lists;
    }

}
