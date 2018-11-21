package com.ylt.skillgather.system.controller;

import org.springframework.stereotype.Controller;
import com.ylt.skillgather.system.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.ylt.skillgather.system.service.IPermissionPermitService;
import com.ylt.skillgather.system.entity.PermissionPermit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author yuliantao
 * @since 2018-11-21
 */
@Controller
@RequestMapping("/system/permissionPermit")
public class PermissionPermitController extends BaseController<PermissionPermit> {
private final Logger logger = LoggerFactory.getLogger(PermissionPermitController.class);

    @Autowired
    private IPermissionPermitService permissionPermitService;;

    @Override
    protected IPermissionPermitService getService() {
        return permissionPermitService;
    }

}