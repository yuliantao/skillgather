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
import com.ylt.skillgather.system.service.IPermissionUserService;
import com.ylt.skillgather.system.entity.PermissionUser;
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
@RequestMapping("/a/system/permission-user")
public class PermissionUserController extends BaseController {
private final Logger logger = LoggerFactory.getLogger(PermissionUserController.class);

@Autowired
public IPermissionUserService iPermissionUserService;

/**
 * 跳转列表页面
 * @param request
 * @param model
 * @return
 */
@RequestMapping(method= RequestMethod.GET,value = {"/permissionUserIndex"})
public String index(HttpServletRequest request, Model model) {
        return "permissionUserListIndex";
        }

/**
 * 分页查询数据
 *
 * @param bootStrapTable  分页信息
 * @param permissionUser   查询条件
 * @return
 */
@ResponseBody
@GetMapping("/getPermissionUserPageList")
public Map<String, Object> getPermissionUserList(BootStrapTable<PermissionUser> bootStrapTable,PermissionUser permissionUser) {
        Map<String,Object> result = new HashMap<String,Object>();
        try {
        result = bootStrapTable.setRows(iPermissionUserService.selectPage(bootStrapTable,permissionUser));
        } catch (Exception e) {
        logger.error("getPermissionUserList -=- {}",e.toString());
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
@RequestMapping(method=RequestMethod.GET,value="/permissionUserAdd")
public String permissionUserAdd(HttpServletRequest request,HttpServletResponse response,Model model) {
        try {


        }catch (Exception ex){
        logger.error("permissionUserAdd -=- {}",ex.toString());
        }
        return "permissionUserAdd";
        }

/**
 * 跳转修改页面
 * @param request
 * @param id  实体ID
 * @return
 */
@RequestMapping(method=RequestMethod.GET,value="/permissionUserUpdate")
public String permissionUserUpdate(HttpServletRequest request,Long id) {
        try {
    PermissionUser permissionUser = iPermissionUserService.selectById(id);
        request.setAttribute("permissionUser",permissionUser);
        }catch (Exception ex){
        logger.error("permissionUserUpdate -=- {}",ex.toString());
        }
        return "permissionUserUpd";
        }

/**
 * 保存和修改公用的
 * @param permissionUser  传递的实体
 * @return  0 失败  1 成功
 */
@ResponseBody
@RequestMapping(method=RequestMethod.POST,value="/permissionUserSave")
public int permissionUserSave(PermissionUser permissionUser) {
        int count = 0;
        try {
        count = iPermissionUserService.insertOrUpdate(permissionUser) ? 1 : 0;
        } catch (Exception e) {
        logger.error("permissionUserSave -=- {}",e.toString());
        }
        return count;
        }

/**
 * 根据id删除对象
 * @param id  实体ID
 * @return 0 失败  1 成功
 */
@ResponseBody
@RequestMapping(method= RequestMethod.POST,value="/permissionUserDelete")
public int permissionUserDelete(Long id){
        int count = 0;
        try {
        count = iPermissionUserService.deleteById(id) ? 1 : 0;
        }catch (Exception e){
        logger.error("permissionUserDelete -=- {}",e.toString());
        }
        return count;
        }

/**
 * 批量删除对象
 * @param item 实体集合ID
 * @return  0 失败  1 成功
 */
@ResponseBody
@RequestMapping(method= RequestMethod.POST,value="/permissionUserBatchDelete")
public int deleteBatchIds(String item){
        int count = 0;
        try {
        List<Long> ids = (List<Long>) JSON.parse(item);
        count = iPermissionUserService.deleteBatchIds(ids) ? 1 : 0;
        }catch (Exception e){
        logger.error("permissionUserBatchDelete -=- {}",e.toString());
        }
        return count;
        }


        }