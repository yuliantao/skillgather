package com.ylt.skillgather.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuliantao
 * @since 2018-11-23
 */
public class SystemUrltoview implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * ID
     */
    @JsonProperty("ID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;


    /**
     * 访问链接
     */
    @JsonProperty("ShowUrl")
    @TableField("ShowUrl")
    private String ShowUrl;


    /**
     * 映射链接
     */
    @JsonProperty("MapingUrl")
    @TableField("MapingUrl")
    private String MapingUrl;


    @JsonIgnore
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonIgnore
    public String getShowUrl() {
        return ShowUrl;
    }

    public void setShowUrl(String ShowUrl) {
        this.ShowUrl = ShowUrl;
    }

    @JsonIgnore
    public String getMapingUrl() {
        return MapingUrl;
    }

    public void setMapingUrl(String MapingUrl) {
        this.MapingUrl = MapingUrl;
    }

    @Override
    public String toString() {
        return "SystemUrltoview{" +
        "id=" + id +
        ", ShowUrl=" + ShowUrl +
        ", MapingUrl=" + MapingUrl +
        "}";
    }
}
