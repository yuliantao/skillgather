package com.baomidou.ant.test.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.ant.common.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2018-11-05
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class PermissionAction extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId("ActionCode")
    private String ActionCode;

    @TableField("ActionName")
    private String ActionName;

    @TableField("ActionValue")
    private String ActionValue;

    @TableField("IsDelete")
    private Boolean IsDelete;


}
