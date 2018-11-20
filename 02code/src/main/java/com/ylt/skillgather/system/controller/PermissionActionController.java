package com.ylt.skillgather.system.controller;

import com.ylt.skillgather.system.entity.PermissionAction;
import com.ylt.skillgather.system.service.IPermissionActionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author yuliantao
 * @since 2018-11-20
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