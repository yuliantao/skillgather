package com.ylt.skillgather.system.controller;

import org.springframework.stereotype.Controller;
import com.ylt.skillgather.system.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.ylt.skillgather.system.service.IPermissionUserPermitService;
import com.ylt.skillgather.system.entity.PermissionUserPermit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author yuliantao
 * @since 2018-11-21
 */
@Controller
@RequestMapping("/system/permissionUserPermit")
public class PermissionUserPermitController extends BaseController<PermissionUserPermit> {
private final Logger logger = LoggerFactory.getLogger(PermissionUserPermitController.class);

    @Autowired
    private IPermissionUserPermitService permissionUserPermitService;;

    @Override
    protected IPermissionUserPermitService getService() {
        return permissionUserPermitService;
    }

}