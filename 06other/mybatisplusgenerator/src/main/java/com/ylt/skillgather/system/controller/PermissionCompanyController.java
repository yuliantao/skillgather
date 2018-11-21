package com.ylt.skillgather.system.controller;

import org.springframework.stereotype.Controller;
import com.ylt.skillgather.system.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.ylt.skillgather.system.service.IPermissionCompanyService;
import com.ylt.skillgather.system.entity.PermissionCompany;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author yuliantao
 * @since 2018-11-21
 */
@Controller
@RequestMapping("/system/permissionCompany")
public class PermissionCompanyController extends BaseController<PermissionCompany> {
private final Logger logger = LoggerFactory.getLogger(PermissionCompanyController.class);

    @Autowired
    private IPermissionCompanyService permissionCompanyService;;

    @Override
    protected IPermissionCompanyService getService() {
        return permissionCompanyService;
    }

}