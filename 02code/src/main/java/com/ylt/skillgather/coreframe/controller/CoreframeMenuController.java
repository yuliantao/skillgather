package com.ylt.skillgather.coreframe.controller;

import com.ylt.skillgather.coreframe.entity.CoreframeMenu;
import com.ylt.skillgather.coreframe.service.ICoreframeMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author yuliantao
 * @since 2018-11-24
 */
@Controller
@RequestMapping("/system/coreframeMenu")
public class CoreframeMenuController extends BaseController<CoreframeMenu> {
private final Logger logger = LoggerFactory.getLogger(CoreframeMenuController.class);

    @Autowired
    private ICoreframeMenuService coreframeMenuService;;

    @Override
    protected ICoreframeMenuService getService() {
        return coreframeMenuService;
    }

}