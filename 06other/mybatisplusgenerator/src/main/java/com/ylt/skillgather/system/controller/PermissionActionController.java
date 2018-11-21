package com.ylt.skillgather.system.controller;

import org.springframework.stereotype.Controller;
import com.ylt.skillgather.system.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.ylt.skillgather.system.service.IPermissionActionService;
import com.ylt.skillgather.system.entity.PermissionAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author yuliantao
 * @since 2018-11-21
 */
@Controller
@RequestMapping("/system/permissionAction")
public class PermissionActionController extends BaseController<PermissionAction> {
private final Logger logger = LoggerFactory.getLogger(PermissionActionController.class);

    @Autowired
    private IPermissionActionService permissionActionService;;

    @Override
    protected IPermissionActionService getService() {
        return permissionActionService;
    }

}