package com.ylt.skillgather.codegenerator.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ylt.skillgather.codegenerator.entity.CodeItemEntity;
import com.ylt.skillgather.codegenerator.entity.CodeMoudlEntity;
import com.ylt.skillgather.codegenerator.entity.GeneratorTable;
import com.ylt.skillgather.codegenerator.service.IGeneratorTableService;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

    @Autowired
    IGeneratorTableService iGeneratorTableService;

    @RequestMapping(value = "/creat")
    @ResponseBody
    public boolean updateItem(HttpServletRequest request) {
        String jsonstring = request.getParameter("dates");
        CodeMoudlEntity codeEntity = JSONObject.parseObject(jsonstring, CodeMoudlEntity.class);
        //文件生成成功开始注册菜单
        if (codeEntity.items.size()>0&&CodeGenerator.generate(codeEntity)) {
            //添加模块菜单
            CoreframeMenu coreframeMenu=new CoreframeMenu();
            coreframeMenu.setName(codeEntity.menuname);
            coreframeMenu.setParentid(-1);
            coreframeMenu.setUrl("");
            //随机展示是否有徽章
            coreframeMenu.setBadgeIco(new Random(4).nextInt(4)==3?getRandomBadgeIco():"");
            coreframeMenu.setIco(getRandomIco());
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
                //更新创建表状态
                String sql="";
                for (CodeItemEntity codeItemEntity1:codeEntity.items)
                {
                    sql+="'"+ codeItemEntity1.TableName+"',";
                }
                UpdateWrapper<GeneratorTable> generatorTableUpdateWrapper=new UpdateWrapper<>();
                generatorTableUpdateWrapper.setSql("IsCreat=1");
                generatorTableUpdateWrapper.inSql("TableName",sql.substring(0,sql.length()-1));
                GeneratorTable generatorTable=new GeneratorTable();
                generatorTable.setIsCreat(true);
                Boolean flag= iGeneratorTableService.update(generatorTable,generatorTableUpdateWrapper);
                //直接创建sql语句
             /*   String sql="update generator_table set IsCreat=1 where TableName in (";
                for (CodeItemEntity codeItemEntity1:codeEntity.items)
                {
                    sql+="'"+ codeItemEntity1.TableName+"',";
                }
                iGeneratorTableService.excuteSql(sql.substring(0,sql.length()-1));*/

            }

            return true;
        }
        else {
            return false;
        }
    }

    /**
     * 返回随机的菜单图标
     * @return
     */
    private String getRandomIco()
    {
        List<String> lists=new ArrayList<>();
        lists.addAll(Arrays.asList(("fa-bar-chart-o,fa-barcode,fa-bell-o,fa-book,fa-bookmark," +
                " fa-briefcase,fa-calendar,fa-camera,fa-certificate,fa-cog,fa-credit-card,fa-tachometer," +
                "fa-pencil-square-o,fa-external-link,fa-flag,fa-lemon-o,fa-leaf").split(",")));
        Random random=new Random();
        return "menu-icon fa "+lists.get(random.nextInt(lists.size()-1));
    }

    /**
     * 返回随机徽章
     */
    private String getRandomBadgeIco()
    {
        List<String> lists=new ArrayList<>();
        lists.addAll(Arrays.asList(("badge badge-yellow,badge badge-pink,badge badge-inverse,badge badge-purple," +
                "badge badge-info,badge badge-danger,badge badge-warning,badge badge-success,badge badge-grey").split(",")));
        Random random=new Random();
        return lists.get(random.nextInt(lists.size()-1));
    }
}
