package com.ylt.skillgather.system.controller;

import org.springframework.stereotype.Controller;
import com.ylt.skillgather.system.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.ylt.skillgather.system.service.ISystemMenuService;
import com.ylt.skillgather.system.entity.SystemMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author yuliantao
 * @since 2018-11-23
 */
@Controller
@RequestMapping("/system/systemMenu")
public class SystemMenuController extends BaseController<SystemMenu> {
private final Logger logger = LoggerFactory.getLogger(SystemMenuController.class);

    @Autowired
    private ISystemMenuService systemMenuService;;

    @Override
    protected ISystemMenuService getService() {
        return systemMenuService;
    }

}