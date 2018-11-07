package com.ylt.skillgather.system.service.impl;

import com.ylt.skillgather.system.entity.PermissionModule;
import com.ylt.skillgather.system.mapper.PermissionModuleMapper;
import com.ylt.skillgather.system.service.IPermissionModuleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 此表兼容了简单的菜单栏控制权限和按钮级别权限控制。针对菜单栏权限可以直接使用此表作为权限表，用户登录后直接获取有权限的菜单在显示。 服务实现类
 * </p>
 *
 * @author yuliantao
 * @since 2018-11-07
 */
@Service
public class PermissionModuleServiceImpl extends ServiceImpl<PermissionModuleMapper, PermissionModule> implements IPermissionModuleService {

}
