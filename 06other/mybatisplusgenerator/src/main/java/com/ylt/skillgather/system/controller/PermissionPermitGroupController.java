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
import com.ylt.skillgather.system.service.IPermissionPermitGroupService;
import com.ylt.skillgather.system.entity.PermissionPermitGroup;
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
@RequestMapping("/system/permission-permit-group")
public class PermissionPermitGroupController extends BaseController {
private final Logger logger = LoggerFactory.getLogger(PermissionPermitGroupController.class);

@Autowired
public IPermissionPermitGroupService iPermissionPermitGroupService;

/**
 * 跳转列表页面
 * @param request
 * @param model
 * @return
 */
@RequestMapping(method= RequestMethod.GET,value = {"/permissionPermitGroupIndex"})
public String index(HttpServletRequest request, Model model)
        {
             return "permissionPermitGroupListIndex";
        }

/**
 * 分页查询数据
 *
 * @param bootStrapTable  分页信息
 * @param permissionPermitGroup   查询条件
 * @return
 */
@ResponseBody
@GetMapping("/getPermissionPermitGroupPageList")
public Map<String, Object> getPermissionPermitGroupList(BootStrapTable<PermissionPermitGroup> bootStrapTable,PermissionPermitGroup permissionPermitGroup) {
        Map<String,Object> result = new HashMap<String,Object>();
        try {
                result = bootStrapTable.setRows(iPermissionPermitGroupService.selectPage(bootStrapTable,permissionPermitGroup));
            } catch (Exception e) {
                logger.error("getPermissionPermitGroupList -=- {}",e.toString());
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
@RequestMapping(method=RequestMethod.GET,value="/permissionPermitGroupAdd")
public String permissionPermitGroupAdd(HttpServletRequest request,HttpServletResponse response,Model model) {
        try {


        }catch (Exception ex){
        logger.error("permissionPermitGroupAdd -=- {}",ex.toString());
        }
        return "permissionPermitGroupAdd";
        }

/**
 * 跳转修改页面
 * @param request
 * @param id  实体ID
 * @return
 */
@RequestMapping(method=RequestMethod.GET,value="/permissionPermitGroupUpdate")
public String permissionPermitGroupUpdate(HttpServletRequest request,Long id) {
        try {
    PermissionPermitGroup permissionPermitGroup = iPermissionPermitGroupService.selectById(id);
        request.setAttribute("permissionPermitGroup",permissionPermitGroup);
        }catch (Exception ex){
        logger.error("permissionPermitGroupUpdate -=- {}",ex.toString());
        }
        return "permissionPermitGroupUpd";
        }

/**
 * 保存和修改公用的
 * @param permissionPermitGroup  传递的实体
 * @return  0 失败  1 成功
 */
@ResponseBody
@RequestMapping(method=RequestMethod.POST,value="/permissionPermitGroupSave")
public int permissionPermitGroupSave(PermissionPermitGroup permissionPermitGroup) {
        int count = 0;
        try {
        count = iPermissionPermitGroupService.insertOrUpdate(permissionPermitGroup) ? 1 : 0;
        } catch (Exception e) {
        logger.error("permissionPermitGroupSave -=- {}",e.toString());
        }
        return count;
        }

/**
 * 根据id删除对象
 * @param id  实体ID
 * @return 0 失败  1 成功
 */
@ResponseBody
@RequestMapping(method= RequestMethod.POST,value="/permissionPermitGroupDelete")
public int permissionPermitGroupDelete(Long id){
        int count = 0;
        try {
        count = iPermissionPermitGroupService.deleteById(id) ? 1 : 0;
        }catch (Exception e){
        logger.error("permissionPermitGroupDelete -=- {}",e.toString());
        }
        return count;
        }

/**
 * 批量删除对象
 * @param item 实体集合ID
 * @return  0 失败  1 成功
 */
@ResponseBody
@RequestMapping(method= RequestMethod.POST,value="/permissionPermitGroupBatchDelete")
public int deleteBatchIds(String item){
        int count = 0;
        try {
        List<Long> ids = (List<Long>) JSON.parse(item);
        count = iPermissionPermitGroupService.deleteBatchIds(ids) ? 1 : 0;
        }catch (Exception e){
        logger.error("permissionPermitGroupBatchDelete -=- {}",e.toString());
        }
        return count;
        }


        }