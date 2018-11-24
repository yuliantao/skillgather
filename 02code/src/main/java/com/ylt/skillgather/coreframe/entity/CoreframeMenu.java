package com.ylt.skillgather.coreframe.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * <p>
 * 菜单的动态管理
 * </p>
 *
 * @author yuliantao
 * @since 2018-11-24
 */
public class CoreframeMenu implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * ID
     */
    @JsonProperty("ID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;


    /**
     * 菜单名
     */
    @JsonProperty("Name")
    @TableField("Name")
    private String Name;


    /**
     * 父ID
     */
    @JsonProperty("Parentid")
    @TableField("Parentid")
    private Integer Parentid;


    /**
     * 请求链接
     */
    @JsonProperty("Url")
    @TableField("Url")
    private String Url;


    /**
     * 菜单图标
     */
    @JsonProperty("Ico")
    @TableField("Ico")
    private String Ico;


    /**
     * 徽章
     */
    @JsonProperty("BadgeIco")
    @TableField("BadgeIco")
    private String BadgeIco;


    @JsonIgnore
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonIgnore
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    @JsonIgnore
    public Integer getParentid() {
        return Parentid;
    }

    public void setParentid(Integer Parentid) {
        this.Parentid = Parentid;
    }

    @JsonIgnore
    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    @JsonIgnore
    public String getIco() {
        return Ico;
    }

    public void setIco(String Ico) {
        this.Ico = Ico;
    }

    @JsonIgnore
    public String getBadgeIco() {
        return BadgeIco;
    }

    public void setBadgeIco(String BadgeIco) {
        this.BadgeIco = BadgeIco;
    }

    @Override
    public String toString() {
        return "CoreframeMenu{" +
        "id=" + id +
        ", Name=" + Name +
        ", Parentid=" + Parentid +
        ", Url=" + Url +
        ", Ico=" + Ico +
        ", BadgeIco=" + BadgeIco +
        "}";
    }
}
