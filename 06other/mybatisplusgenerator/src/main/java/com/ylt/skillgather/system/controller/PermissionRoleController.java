package com.ylt.skillgather.system.controller;

import org.springframework.stereotype.Controller;
import com.ylt.skillgather.system.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.ylt.skillgather.system.service.IPermissionRoleService;
import com.ylt.skillgather.system.entity.PermissionRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author yuliantao
 * @since 2018-11-21
 */
@Controller
@RequestMapping("/system/permissionRole")
public class PermissionRoleController extends BaseController<PermissionRole> {
private final Logger logger = LoggerFactory.getLogger(PermissionRoleController.class);

    @Autowired
    private IPermissionRoleService permissionRoleService;;

    @Override
    protected IPermissionRoleService getService() {
        return permissionRoleService;
    }

}