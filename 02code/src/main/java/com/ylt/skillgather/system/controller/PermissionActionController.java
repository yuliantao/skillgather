package com.ylt.skillgather.system.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
import com.ylt.skillgather.system.service.IPermissionActionService;
import com.ylt.skillgather.system.entity.PermissionAction;
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
@RequestMapping("/a/system/permission-action")
public class PermissionActionController extends BaseController {
private final Logger logger = LoggerFactory.getLogger(PermissionActionController.class);

@Autowired
public IPermissionActionService iPermissionActionService;

/**
 * 跳转列表页面
 * @param request
 * @param model
 * @return
 */
@RequestMapping(method= RequestMethod.GET,value = {"/permissionActionIndex"})
public String index(HttpServletRequest request, Model model) {
        return "permissionActionListIndex";
        }

/**
 * 分页查询数据
 *
 * @param bootStrapTable  分页信息
 * @param permissionAction   查询条件
 * @return
 */
@ResponseBody
@GetMapping("/getPermissionActionPageList")
public Map<String, Object> getPermissionActionList(BootStrapTable<PermissionAction> bootStrapTable,PermissionAction permissionAction) {
        Map<String,Object> result = new HashMap<String,Object>();
        try {
        result = bootStrapTable.setRows(iPermissionActionService.selectPage(bootStrapTable,permissionAction));
        } catch (Exception e) {
        logger.error("getPermissionActionList -=- {}",e.toString());
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
@RequestMapping(method=RequestMethod.GET,value="/permissionActionAdd")
public String permissionActionAdd(HttpServletRequest request,HttpServletResponse response,Model model) {
        try {


        }catch (Exception ex){
        logger.error("permissionActionAdd -=- {}",ex.toString());
        }
        return "permissionActionAdd";
        }

/**
 * 跳转修改页面
 * @param request
 * @param id  实体ID
 * @return
 */
@RequestMapping(method=RequestMethod.GET,value="/permissionActionUpdate")
public String permissionActionUpdate(HttpServletRequest request,Long id) {
        try {
    PermissionAction permissionAction = iPermissionActionService.selectById(id);
        request.setAttribute("permissionAction",permissionAction);
        }catch (Exception ex){
        logger.error("permissionActionUpdate -=- {}",ex.toString());
        }
        return "permissionActionUpd";
        }

/**
 * 保存和修改公用的
 * @param permissionAction  传递的实体
 * @return  0 失败  1 成功
 */
@ResponseBody
@RequestMapping(method=RequestMethod.POST,value="/permissionActionSave")
public int permissionActionSave(PermissionAction permissionAction) {
        int count = 0;
        try {
        count = iPermissionActionService.insertOrUpdate(permissionAction) ? 1 : 0;
        } catch (Exception e) {
        logger.error("permissionActionSave -=- {}",e.toString());
        }
        return count;
        }

/**
 * 根据id删除对象
 * @param id  实体ID
 * @return 0 失败  1 成功
 */
@ResponseBody
@RequestMapping(method= RequestMethod.POST,value="/permissionActionDelete")
public int permissionActionDelete(Long id){
        int count = 0;
        try {
        count = iPermissionActionService.deleteById(id) ? 1 : 0;
        }catch (Exception e){
        logger.error("permissionActionDelete -=- {}",e.toString());
        }
        return count;
        }

/**
 * 批量删除对象
 * @param item 实体集合ID
 * @return  0 失败  1 成功
 */
@ResponseBody
@RequestMapping(method= RequestMethod.POST,value="/permissionActionBatchDelete")
public int deleteBatchIds(String item){
        int count = 0;
        try {
        List<Long> ids = (List<Long>) JSON.parse(item);
        count = iPermissionActionService.deleteBatchIds(ids) ? 1 : 0;
        }catch (Exception e){
        logger.error("permissionActionBatchDelete -=- {}",e.toString());
        }
        return count;
        }


        }