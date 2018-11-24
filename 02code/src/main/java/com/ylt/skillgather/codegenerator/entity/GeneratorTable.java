package com.ylt.skillgather.codegenerator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <p>
 * 扫描到需要生产系统的表
 * </p>
 *
 * @author yuliantao
 * @since 2018-11-24
 */
public class GeneratorTable implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * ID
     */
    @JsonProperty("ID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;


    /**
     * 表名
     */
    @JsonProperty("TableName")
    @TableField("TableName")
    private String TableName;


    /**
     * 菜单名
     */
    @JsonProperty("MenuName")
    @TableField("MenuName")
    private String MenuName;


    /**
     * 已生成
     */
    @JsonProperty("IsCreat")
    @TableField("IsCreat")
    private Boolean IsCreat;


    @JsonIgnore
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonIgnore
    public String getTableName() {
        return TableName;
    }

    public void setTableName(String TableName) {
        this.TableName = TableName;
    }

    @JsonIgnore
    public String getMenuName() {
        return MenuName;
    }

    public void setMenuName(String MenuName) {
        this.MenuName = MenuName;
    }

    @JsonIgnore
    public Boolean getIsCreat() {
        return IsCreat;
    }

    public void setIsCreat(Boolean IsCreat) {
        this.IsCreat = IsCreat;
    }

    @Override
    public String toString() {
        return "GeneratorTable{" +
        "id=" + id +
        ", TableName=" + TableName +
        ", MenuName=" + MenuName +
        ", IsCreat=" + IsCreat +
        "}";
    }
}
