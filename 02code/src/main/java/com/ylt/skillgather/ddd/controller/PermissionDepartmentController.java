package com.ylt.skillgather.ddd.controller;

import org.springframework.stereotype.Controller;
import com.ylt.skillgather.coreframe.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.ylt.skillgather.ddd.service.IPermissionDepartmentService;
import com.ylt.skillgather.ddd.entity.PermissionDepartment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author yuliantao
 * @since 2018-11-28
 */
@Controller
@RequestMapping("/ddd/permissionDepartment")
public class PermissionDepartmentController extends BaseController<PermissionDepartment> {
private final Logger logger = LoggerFactory.getLogger(PermissionDepartmentController.class);

    @Autowired
    private IPermissionDepartmentService permissionDepartmentService;

    @Override
    protected IPermissionDepartmentService getService() {
        return permissionDepartmentService;
    }

}