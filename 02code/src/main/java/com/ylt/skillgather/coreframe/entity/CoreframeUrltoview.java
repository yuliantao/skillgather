package com.ylt.skillgather.coreframe.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * <p>
 * 请求映射视图
 * </p>
 *
 * @author yuliantao
 * @since 2018-11-24
 */
public class CoreframeUrltoview implements Serializable {

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
        return "CoreframeUrltoview{" +
        "id=" + id +
        ", ShowUrl=" + ShowUrl +
        ", MapingUrl=" + MapingUrl +
        "}";
    }
}
