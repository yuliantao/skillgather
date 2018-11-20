package com.ylt.skillgather.system.controller;

import org.springframework.stereotype.Controller;
import com.ylt.skillgather.system.controller.BaseController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.ylt.skillgather.system.service.IPermissionUserService;
import com.ylt.skillgather.system.entity.PermissionUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author yuliantao
 * @since 2018-11-09
 */
@Controller
@RequestMapping("/system/permissionUser")
public class PermissionUserController extends BaseController<PermissionUser> {
private final Logger logger = LoggerFactory.getLogger(PermissionUserController.class);

    @Autowired
    private IPermissionUserService permissionUserService;;

    @Override
    protected IPermissionUserService getService() {
        return permissionUserService;
    }

}