package com.ylt.skillgather.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuliantao
 * @since 2018-11-08
 */
public class PermissionCompany implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("CompanyCode")
    private String CompanyCode;

    @TableField("CompanyName")
    private String CompanyName;

    @TableField("IsDelete")
    private Boolean IsDelete;


    public String getCompanyCode() {
        return CompanyCode;
    }

    public void setCompanyCode(String CompanyCode) {
        this.CompanyCode = CompanyCode;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public Boolean getIsDelete() {
        return IsDelete;
    }

    public void setIsDelete(Boolean IsDelete) {
        this.IsDelete = IsDelete;
    }

    @Override
    public String toString() {
        return "PermissionCompany{" +
        "CompanyCode=" + CompanyCode +
        ", CompanyName=" + CompanyName +
        ", IsDelete=" + IsDelete +
        "}";
    }
}
