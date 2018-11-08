package com.ylt.skillgather.system.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.ant.common.BaseController;
import com.alibaba.fastjson.JSON;
import com.dcy.constant.Constant;
import com.dcy.model.BootStrapTable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ylt.skillgather.system.service.IPermissionModuleService;
import com.ylt.skillgather.system.entity.PermissionModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author yuliantao
 * @since 2018-11-08
 */
@RestController
@RequestMapping("/system/permission-module")
public class PermissionModuleController extends BaseController {
private final Logger logger = LoggerFactory.getLogger(PermissionModuleController.class);

@Autowired
public IPermissionModuleService iPermissionModuleService;

/**
 * 跳转列表页面
 * @param request
 * @param model
 * @return
 */
@RequestMapping(method= RequestMethod.GET,value = {"/permissionModuleIndex"})
public String index(HttpServletRequest request, Model model)
        {
             return "permissionModuleListIndex";
        }

/**
 * 分页查询数据
 *
 * @param bootStrapTable  分页信息
 * @param permissionModule   查询条件
 * @return
 */
@ResponseBody
@GetMapping("/getPermissionModulePageList")
public Map<String, Object> getPermissionModuleList(BootStrapTable<PermissionModule> bootStrapTable,PermissionModule permissionModule) {
        Map<String,Object> result = new HashMap<String,Object>();
        try {
                result = bootStrapTable.setRows(iPermissionModuleService.selectPage(bootStrapTable,permissionModule));
            } catch (Exception e) {
                logger.error("getPermissionModuleList -=- {}",e.toString());
                result.put(Constant.BOOTSTAP_TABLE_ROWS, new ArrayList<>());
                result.put(Constant.BOOTSTRAP_TABLE_TOTAL, 0);
            }
        return result;
        }

/**
 * 跳转添加页面
 * @param request
 * @param response
 * @param model
 * @return
 */
@RequestMapping(method=RequestMethod.GET,value="/permissionModuleAdd")
public String permissionModuleAdd(HttpServletRequest request,HttpServletResponse response,Model model) {
        try {


        }catch (Exception ex){
        logger.error("permissionModuleAdd -=- {}",ex.toString());
        }
        return "permissionModuleAdd";
        }

/**
 * 跳转修改页面
 * @param request
 * @param id  实体ID
 * @return
 */
@RequestMapping(method=RequestMethod.GET,value="/permissionModuleUpdate")
public String permissionModuleUpdate(HttpServletRequest request,Long id) {
        try {
    PermissionModule permissionModule = iPermissionModuleService.selectById(id);
        request.setAttribute("permissionModule",permissionModule);
        }catch (Exception ex){
        logger.error("permissionModuleUpdate -=- {}",ex.toString());
        }
        return "permissionModuleUpd";
        }

/**
 * 保存和修改公用的
 * @param permissionModule  传递的实体
 * @return  0 失败  1 成功
 */
@ResponseBody
@RequestMapping(method=RequestMethod.POST,value="/permissionModuleSave")
public int permissionModuleSave(PermissionModule permissionModule) {
        int count = 0;
        try {
        count = iPermissionModuleService.insertOrUpdate(permissionModule) ? 1 : 0;
        } catch (Exception e) {
        logger.error("permissionModuleSave -=- {}",e.toString());
        }
        return count;
        }

/**
 * 根据id删除对象
 * @param id  实体ID
 * @return 0 失败  1 成功
 */
@ResponseBody
@RequestMapping(method= RequestMethod.POST,value="/permissionModuleDelete")
public int permissionModuleDelete(Long id){
        int count = 0;
        try {
        count = iPermissionModuleService.deleteById(id) ? 1 : 0;
        }catch (Exception e){
        logger.error("permissionModuleDelete -=- {}",e.toString());
        }
        return count;
        }

/**
 * 批量删除对象
 * @param item 实体集合ID
 * @return  0 失败  1 成功
 */
@ResponseBody
@RequestMapping(method= RequestMethod.POST,value="/permissionModuleBatchDelete")
public int deleteBatchIds(String item){
        int count = 0;
        try {
        List<Long> ids = (List<Long>) JSON.parse(item);
        count = iPermissionModuleService.deleteBatchIds(ids) ? 1 : 0;
        }catch (Exception e){
        logger.error("permissionModuleBatchDelete -=- {}",e.toString());
        }
        return count;
        }


        }