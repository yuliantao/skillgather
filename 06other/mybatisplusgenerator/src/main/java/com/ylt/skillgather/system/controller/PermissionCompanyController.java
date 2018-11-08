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
import com.ylt.skillgather.system.service.IPermissionCompanyService;
import com.ylt.skillgather.system.entity.PermissionCompany;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author yuliantao
 * @since 2018-11-07
 */
@RestController
@RequestMapping("/a/system/permission-company")
public class PermissionCompanyController extends BaseController {
private final Logger logger = LoggerFactory.getLogger(PermissionCompanyController.class);

@Autowired
public IPermissionCompanyService iPermissionCompanyService;

/**
 * 跳转列表页面
 * @param request
 * @param model
 * @return
 */
@RequestMapping(method= RequestMethod.GET,value = {"/permissionCompanyIndex"})
public String index(HttpServletRequest request, Model model) {
        return "permissionCompanyListIndex";
        }

/**
 * 分页查询数据
 *
 * @param bootStrapTable  分页信息
 * @param permissionCompany   查询条件
 * @return
 */
@ResponseBody
@GetMapping("/getPermissionCompanyPageList")
public Map<String, Object> getPermissionCompanyList(BootStrapTable<PermissionCompany> bootStrapTable,PermissionCompany permissionCompany) {
        Map<String,Object> result = new HashMap<String,Object>();
        try {
        result = bootStrapTable.setRows(iPermissionCompanyService.selectPage(bootStrapTable,permissionCompany));
        } catch (Exception e) {
        logger.error("getPermissionCompanyList -=- {}",e.toString());
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
@RequestMapping(method=RequestMethod.GET,value="/permissionCompanyAdd")
public String permissionCompanyAdd(HttpServletRequest request,HttpServletResponse response,Model model) {
        try {


        }catch (Exception ex){
        logger.error("permissionCompanyAdd -=- {}",ex.toString());
        }
        return "permissionCompanyAdd";
        }

/**
 * 跳转修改页面
 * @param request
 * @param id  实体ID
 * @return
 */
@RequestMapping(method=RequestMethod.GET,value="/permissionCompanyUpdate")
public String permissionCompanyUpdate(HttpServletRequest request,Long id) {
        try {
    PermissionCompany permissionCompany = iPermissionCompanyService.selectById(id);
        request.setAttribute("permissionCompany",permissionCompany);
        }catch (Exception ex){
        logger.error("permissionCompanyUpdate -=- {}",ex.toString());
        }
        return "permissionCompanyUpd";
        }

/**
 * 保存和修改公用的
 * @param permissionCompany  传递的实体
 * @return  0 失败  1 成功
 */
@ResponseBody
@RequestMapping(method=RequestMethod.POST,value="/permissionCompanySave")
public int permissionCompanySave(PermissionCompany permissionCompany) {
        int count = 0;
        try {
        count = iPermissionCompanyService.insertOrUpdate(permissionCompany) ? 1 : 0;
        } catch (Exception e) {
        logger.error("permissionCompanySave -=- {}",e.toString());
        }
        return count;
        }

/**
 * 根据id删除对象
 * @param id  实体ID
 * @return 0 失败  1 成功
 */
@ResponseBody
@RequestMapping(method= RequestMethod.POST,value="/permissionCompanyDelete")
public int permissionCompanyDelete(Long id){
        int count = 0;
        try {
        count = iPermissionCompanyService.deleteById(id) ? 1 : 0;
        }catch (Exception e){
        logger.error("permissionCompanyDelete -=- {}",e.toString());
        }
        return count;
        }

/**
 * 批量删除对象
 * @param item 实体集合ID
 * @return  0 失败  1 成功
 */
@ResponseBody
@RequestMapping(method= RequestMethod.POST,value="/permissionCompanyBatchDelete")
public int deleteBatchIds(String item){
        int count = 0;
        try {
        List<Long> ids = (List<Long>) JSON.parse(item);
        count = iPermissionCompanyService.deleteBatchIds(ids) ? 1 : 0;
        }catch (Exception e){
        logger.error("permissionCompanyBatchDelete -=- {}",e.toString());
        }
        return count;
        }


        }