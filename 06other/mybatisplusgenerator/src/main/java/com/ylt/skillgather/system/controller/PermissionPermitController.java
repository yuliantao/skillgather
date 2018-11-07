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
import com.ylt.skillgather.system.service.IPermissionPermitService;
import com.ylt.skillgather.system.entity.PermissionPermit;
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
@RequestMapping("/a/system/permission-permit")
public class PermissionPermitController extends BaseController {
private final Logger logger = LoggerFactory.getLogger(PermissionPermitController.class);

@Autowired
public IPermissionPermitService iPermissionPermitService;

/**
 * 跳转列表页面
 * @param request
 * @param model
 * @return
 */
@RequestMapping(method= RequestMethod.GET,value = {"/permissionPermitIndex"})
public String index(HttpServletRequest request, Model model) {
        return "permissionPermitListIndex";
        }

/**
 * 分页查询数据
 *
 * @param bootStrapTable  分页信息
 * @param permissionPermit   查询条件
 * @return
 */
@ResponseBody
@GetMapping("/getPermissionPermitPageList")
public Map<String, Object> getPermissionPermitList(BootStrapTable<PermissionPermit> bootStrapTable,PermissionPermit permissionPermit) {
        Map<String,Object> result = new HashMap<String,Object>();
        try {
        result = bootStrapTable.setRows(iPermissionPermitService.selectPage(bootStrapTable,permissionPermit));
        } catch (Exception e) {
        logger.error("getPermissionPermitList -=- {}",e.toString());
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
@RequestMapping(method=RequestMethod.GET,value="/permissionPermitAdd")
public String permissionPermitAdd(HttpServletRequest request,HttpServletResponse response,Model model) {
        try {


        }catch (Exception ex){
        logger.error("permissionPermitAdd -=- {}",ex.toString());
        }
        return "permissionPermitAdd";
        }

/**
 * 跳转修改页面
 * @param request
 * @param id  实体ID
 * @return
 */
@RequestMapping(method=RequestMethod.GET,value="/permissionPermitUpdate")
public String permissionPermitUpdate(HttpServletRequest request,Long id) {
        try {
    PermissionPermit permissionPermit = iPermissionPermitService.selectById(id);
        request.setAttribute("permissionPermit",permissionPermit);
        }catch (Exception ex){
        logger.error("permissionPermitUpdate -=- {}",ex.toString());
        }
        return "permissionPermitUpd";
        }

/**
 * 保存和修改公用的
 * @param permissionPermit  传递的实体
 * @return  0 失败  1 成功
 */
@ResponseBody
@RequestMapping(method=RequestMethod.POST,value="/permissionPermitSave")
public int permissionPermitSave(PermissionPermit permissionPermit) {
        int count = 0;
        try {
        count = iPermissionPermitService.insertOrUpdate(permissionPermit) ? 1 : 0;
        } catch (Exception e) {
        logger.error("permissionPermitSave -=- {}",e.toString());
        }
        return count;
        }

/**
 * 根据id删除对象
 * @param id  实体ID
 * @return 0 失败  1 成功
 */
@ResponseBody
@RequestMapping(method= RequestMethod.POST,value="/permissionPermitDelete")
public int permissionPermitDelete(Long id){
        int count = 0;
        try {
        count = iPermissionPermitService.deleteById(id) ? 1 : 0;
        }catch (Exception e){
        logger.error("permissionPermitDelete -=- {}",e.toString());
        }
        return count;
        }

/**
 * 批量删除对象
 * @param item 实体集合ID
 * @return  0 失败  1 成功
 */
@ResponseBody
@RequestMapping(method= RequestMethod.POST,value="/permissionPermitBatchDelete")
public int deleteBatchIds(String item){
        int count = 0;
        try {
        List<Long> ids = (List<Long>) JSON.parse(item);
        count = iPermissionPermitService.deleteBatchIds(ids) ? 1 : 0;
        }catch (Exception e){
        logger.error("permissionPermitBatchDelete -=- {}",e.toString());
        }
        return count;
        }


        }