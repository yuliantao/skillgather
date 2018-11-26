package com.ylt.skillgather.codegenerator.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ylt.skillgather.codegenerator.entity.GeneratorTable;
import com.ylt.skillgather.codegenerator.service.IGeneratorTableService;
import com.ylt.skillgather.coreframe.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 * @author yuliantao
 * @since 2018-11-24
 */
@Controller
@RequestMapping("/codegenerator/generatorTable")
public class GeneratorTableController extends BaseController<GeneratorTable> {
private final Logger logger = LoggerFactory.getLogger(GeneratorTableController.class);

    @Autowired
    private IGeneratorTableService generatorTableService;;

    @Override
    protected IGeneratorTableService getService() {
        return generatorTableService;
    }

    /**
     * 获取数据列表
     */
    @RequestMapping("/jqCondition")
    @ResponseBody
    public List<GeneratorTable> jqCondition(HttpServletRequest request) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("IsCreat",false);
        List<GeneratorTable> lits= getService().list(queryWrapper);
        return lits;
    }
}