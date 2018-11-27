package com.ylt.skillgather.common.controller;

import com.ylt.skillgather.common.service.ICommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author yuliantao
 * @since 2018-11-24
 */
@Controller
@RequestMapping("/common")
public class CommonController {
private final Logger logger = LoggerFactory.getLogger(CommonController.class);

    @Autowired
    private ICommonService icommonService;

    @RequestMapping("/excuteSql")
    @ResponseBody
    public void excuteSql(String sql)
    {
        icommonService.excuteSql(sql);
    }
}