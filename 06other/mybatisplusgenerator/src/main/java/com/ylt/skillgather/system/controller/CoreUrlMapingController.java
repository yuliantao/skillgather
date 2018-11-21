package com.ylt.skillgather.system.controller;

import org.springframework.stereotype.Controller;
import com.ylt.skillgather.system.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.ylt.skillgather.system.service.ICoreUrlMapingService;
import com.ylt.skillgather.system.entity.CoreUrlMaping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author yuliantao
 * @since 2018-11-21
 */
@Controller
@RequestMapping("/system/coreUrlMaping")
public class CoreUrlMapingController extends BaseController<CoreUrlMaping> {
private final Logger logger = LoggerFactory.getLogger(CoreUrlMapingController.class);

    @Autowired
    private ICoreUrlMapingService coreUrlMapingService;;

    @Override
    protected ICoreUrlMapingService getService() {
        return coreUrlMapingService;
    }

}