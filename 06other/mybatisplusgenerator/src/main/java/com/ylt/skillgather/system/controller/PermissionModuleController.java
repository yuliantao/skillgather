package com.ylt.skillgather.system.controller;

import org.springframework.stereotype.Controller;
import com.ylt.skillgather.system.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.ylt.skillgather.system.service.IPermissionModuleService;
import com.ylt.skillgather.system.entity.PermissionModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author yuliantao
 * @since 2018-11-09
 */
@Controller
@RequestMapping("/system/permissionModule")
public class PermissionModuleController extends BaseController<PermissionModule> {
private final Logger logger = LoggerFactory.getLogger(PermissionModuleController.class);

    @Autowired
    private IPermissionModuleService permissionModuleService;;

    @Override
    protected IPermissionModuleService getService() {
        return permissionModuleService;
    }

}