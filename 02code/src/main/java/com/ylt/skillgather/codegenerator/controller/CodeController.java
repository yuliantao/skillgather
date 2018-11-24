package com.ylt.skillgather.codegenerator.controller;

import com.alibaba.fastjson.JSONObject;
import com.ylt.skillgather.codegenerator.entity.CodeItemEntity;
import com.ylt.skillgather.codegenerator.entity.CodeMoudlEntity;
import com.ylt.skillgather.codegenerator.utils.CodeGenerator;
import com.ylt.skillgather.common.utils.StringUtils;
import com.ylt.skillgather.coreframe.entity.CoreframeMenu;
import com.ylt.skillgather.coreframe.entity.CoreframeUrltoview;
import com.ylt.skillgather.coreframe.service.ICoreframeMenuService;
import com.ylt.skillgather.coreframe.service.ICoreframeUrltoviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yuliantao
 * @create 2018-11-24 13:53
 * @description 代码生成
 */
@Controller
@RequestMapping("/codegenerator")
public class CodeController {

    @Autowired
    ICoreframeMenuService iCoreframeMenuService;

    @Autowired
    ICoreframeUrltoviewService iCoreframeUrltoviewService;

    @RequestMapping(value = "/creat")
    @ResponseBody
    public boolean updateItem(HttpServletRequest request) {
        String jsonstring = request.getParameter("dates");
        CodeMoudlEntity codeEntity = JSONObject.parseObject(jsonstring, CodeMoudlEntity.class);
        //文件生成成功开始注册菜单
        if (CodeGenerator.generate(codeEntity)) {
            //添加模块菜单
            CoreframeMenu coreframeMenu=new CoreframeMenu();
            coreframeMenu.setName(codeEntity.menuname);
            coreframeMenu.setParentid(-1);
            coreframeMenu.setUrl("");
            coreframeMenu.setBadgeIco("");
            coreframeMenu.setIco("");
            iCoreframeMenuService.save(coreframeMenu);
            for (CodeItemEntity codeItemEntity:codeEntity.items) {
                //添加子菜单
                CoreframeMenu coreframeMenu2=new CoreframeMenu();
                coreframeMenu2.setName(codeItemEntity.MenuName);
                coreframeMenu2.setParentid(coreframeMenu.getId());
                coreframeMenu2.setUrl("/"+codeEntity.mouldname+"/"+ StringUtils.underScoreCase2CamelCase(codeItemEntity.TableName));
                coreframeMenu2.setBadgeIco("");
                coreframeMenu2.setIco("");
                iCoreframeMenuService.save(coreframeMenu2);
                //链接视图映射
                CoreframeUrltoview coreframeUrltoview=new CoreframeUrltoview();
                coreframeUrltoview.setShowUrl(coreframeMenu2.getUrl());
                coreframeUrltoview.setMapingUrl("/aceplus"+coreframeMenu2.getUrl());
                iCoreframeUrltoviewService.save(coreframeUrltoview);
            }

            return true;
        }
        else {
            return false;
        }
    }
}
