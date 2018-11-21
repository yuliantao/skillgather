package com.ylt.skillgather.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <p>
 * 请求链接映射视图地址
 * </p>
 *
 * @author yuliantao
 * @since 2018-11-21
 */
public class CoreUrlMaping implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * ID
     */
    @JsonProperty("ID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;


    /**
     * 请求链接
     */
    @JsonProperty("RequestUrl")
    @TableField("RequestUrl")
    private String RequestUrl;


    /**
     * 映射Url
     */
    @JsonProperty("ViewUrl")
    @TableField("ViewUrl")
    private String ViewUrl;


    @JsonIgnore
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonIgnore
    public String getRequestUrl() {
        return RequestUrl;
    }

    public void setRequestUrl(String RequestUrl) {
        this.RequestUrl = RequestUrl;
    }

    @JsonIgnore
    public String getViewUrl() {
        return ViewUrl;
    }

    public void setViewUrl(String ViewUrl) {
        this.ViewUrl = ViewUrl;
    }

    @Override
    public String toString() {
        return "CoreUrlMaping{" +
        "id=" + id +
        ", RequestUrl=" + RequestUrl +
        ", ViewUrl=" + ViewUrl +
        "}";
    }
}
