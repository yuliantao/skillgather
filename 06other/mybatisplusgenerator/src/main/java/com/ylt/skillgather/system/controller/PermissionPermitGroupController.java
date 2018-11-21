package com.ylt.skillgather.system.controller;

import org.springframework.stereotype.Controller;
import com.ylt.skillgather.system.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.ylt.skillgather.system.service.IPermissionPermitGroupService;
import com.ylt.skillgather.system.entity.PermissionPermitGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author yuliantao
 * @since 2018-11-21
 */
@Controller
@RequestMapping("/system/permissionPermitGroup")
public class PermissionPermitGroupController extends BaseController<PermissionPermitGroup> {
private final Logger logger = LoggerFactory.getLogger(PermissionPermitGroupController.class);

    @Autowired
    private IPermissionPermitGroupService permissionPermitGroupService;;

    @Override
    protected IPermissionPermitGroupService getService() {
        return permissionPermitGroupService;
    }

}