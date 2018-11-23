package com.ylt.skillgather.system.mapper;

import com.ylt.skillgather.system.entity.PermissionModule;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 此表兼容了简单的菜单栏控制权限和按钮级别权限控制。针对菜单栏权限可以直接使用此表作为权限表，用户登录后直接获取有权限的菜单在显示。 Mapper 接口
 * </p>
 *
 * @author yuliantao
 * @since 2018-11-23
 */
public interface PermissionModuleMapper extends BaseMapper<PermissionModule> {

}
