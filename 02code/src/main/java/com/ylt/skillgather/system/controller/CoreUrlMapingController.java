package com.ylt.skillgather.system.controller;

import com.ylt.skillgather.system.entity.CoreUrlMaping;
import com.ylt.skillgather.system.service.ICoreUrlMapingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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