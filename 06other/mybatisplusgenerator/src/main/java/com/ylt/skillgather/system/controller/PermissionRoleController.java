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
import com.ylt.skillgather.system.service.IPermissionRoleService;
import com.ylt.skillgather.system.entity.PermissionRole;
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
@RequestMapping("/system/permission-role")
public class PermissionRoleController extends BaseController {
private final Logger logger = LoggerFactory.getLogger(PermissionRoleController.class);

@Autowired
public IPermissionRoleService iPermissionRoleService;

/**
 * 跳转列表页面
 * @param request
 * @param model
 * @return
 */
@RequestMapping(method= RequestMethod.GET,value = {"/permissionRoleIndex"})
public String index(HttpServletRequest request, Model model)
        {
             return "permissionRoleListIndex";
        }

/**
 * 分页查询数据
 *
 * @param bootStrapTable  分页信息
 * @param permissionRole   查询条件
 * @return
 */
@ResponseBody
@GetMapping("/getPermissionRolePageList")
public Map<String, Object> getPermissionRoleList(BootStrapTable<PermissionRole> bootStrapTable,PermissionRole permissionRole) {
        Map<String,Object> result = new HashMap<String,Object>();
        try {
                result = bootStrapTable.setRows(iPermissionRoleService.selectPage(bootStrapTable,permissionRole));
            } catch (Exception e) {
                logger.error("getPermissionRoleList -=- {}",e.toString());
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
@RequestMapping(method=RequestMethod.GET,value="/permissionRoleAdd")
public String permissionRoleAdd(HttpServletRequest request,HttpServletResponse response,Model model) {
        try {


        }catch (Exception ex){
        logger.error("permissionRoleAdd -=- {}",ex.toString());
        }
        return "permissionRoleAdd";
        }

/**
 * 跳转修改页面
 * @param request
 * @param id  实体ID
 * @return
 */
@RequestMapping(method=RequestMethod.GET,value="/permissionRoleUpdate")
public String permissionRoleUpdate(HttpServletRequest request,Long id) {
        try {
    PermissionRole permissionRole = iPermissionRoleService.selectById(id);
        request.setAttribute("permissionRole",permissionRole);
        }catch (Exception ex){
        logger.error("permissionRoleUpdate -=- {}",ex.toString());
        }
        return "permissionRoleUpd";
        }

/**
 * 保存和修改公用的
 * @param permissionRole  传递的实体
 * @return  0 失败  1 成功
 */
@ResponseBody
@RequestMapping(method=RequestMethod.POST,value="/permissionRoleSave")
public int permissionRoleSave(PermissionRole permissionRole) {
        int count = 0;
        try {
        count = iPermissionRoleService.insertOrUpdate(permissionRole) ? 1 : 0;
        } catch (Exception e) {
        logger.error("permissionRoleSave -=- {}",e.toString());
        }
        return count;
        }

/**
 * 根据id删除对象
 * @param id  实体ID
 * @return 0 失败  1 成功
 */
@ResponseBody
@RequestMapping(method= RequestMethod.POST,value="/permissionRoleDelete")
public int permissionRoleDelete(Long id){
        int count = 0;
        try {
        count = iPermissionRoleService.deleteById(id) ? 1 : 0;
        }catch (Exception e){
        logger.error("permissionRoleDelete -=- {}",e.toString());
        }
        return count;
        }

/**
 * 批量删除对象
 * @param item 实体集合ID
 * @return  0 失败  1 成功
 */
@ResponseBody
@RequestMapping(method= RequestMethod.POST,value="/permissionRoleBatchDelete")
public int deleteBatchIds(String item){
        int count = 0;
        try {
        List<Long> ids = (List<Long>) JSON.parse(item);
        count = iPermissionRoleService.deleteBatchIds(ids) ? 1 : 0;
        }catch (Exception e){
        logger.error("permissionRoleBatchDelete -=- {}",e.toString());
        }
        return count;
        }


        }