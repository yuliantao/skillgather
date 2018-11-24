package com.ylt.skillgather.coreframe.entity.Ex;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ylt.skillgather.coreframe.entity.CoreframeMenu;

import java.util.List;


public class CoreframeMenuEx extends CoreframeMenu {


    @JsonProperty("lists")
    List<CoreframeMenuEx> lists;

    public void setLists(List<CoreframeMenuEx> lists) {
        this.lists = lists;
    }
    @JsonIgnore
    public List<CoreframeMenuEx> getLists() {
        return lists;
    }

}
