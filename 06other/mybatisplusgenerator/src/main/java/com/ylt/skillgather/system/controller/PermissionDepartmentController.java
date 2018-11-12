package com.ylt.skillgather.system.controller;

import org.springframework.stereotype.Controller;
import com.ylt.skillgather.system.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.ylt.skillgather.system.service.IPermissionDepartmentService;
import com.ylt.skillgather.system.entity.PermissionDepartment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author yuliantao
 * @since 2018-11-09
 */
@Controller
@RequestMapping("/system/permissionDepartment")
public class PermissionDepartmentController extends BaseController<PermissionDepartment> {
private final Logger logger = LoggerFactory.getLogger(PermissionDepartmentController.class);

    @Autowired
    private IPermissionDepartmentService permissionDepartmentService;;

    @Override
    protected IPermissionDepartmentService getService() {
        return permissionDepartmentService;
    }

}