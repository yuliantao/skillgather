package com.ylt.skillgather.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;


public class CoreUrlMapingEx extends CoreUrlMaping {


    @JsonProperty("lists")
    List<CoreUrlMaping> lists;

    public void setLists(List<CoreUrlMaping> lists) {
        this.lists = lists;
    }
    @JsonIgnore
    public List<CoreUrlMaping> getLists() {
        return lists;
    }


}
