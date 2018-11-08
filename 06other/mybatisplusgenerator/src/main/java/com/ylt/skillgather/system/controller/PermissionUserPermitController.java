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
import com.ylt.skillgather.system.service.IPermissionUserPermitService;
import com.ylt.skillgather.system.entity.PermissionUserPermit;
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
@RequestMapping("/system/permission-user-permit")
public class PermissionUserPermitController extends BaseController {
private final Logger logger = LoggerFactory.getLogger(PermissionUserPermitController.class);

@Autowired
public IPermissionUserPermitService iPermissionUserPermitService;

/**
 * 跳转列表页面
 * @param request
 * @param model
 * @return
 */
@RequestMapping(method= RequestMethod.GET,value = {"/permissionUserPermitIndex"})
public String index(HttpServletRequest request, Model model)
        {
             return "permissionUserPermitListIndex";
        }

/**
 * 分页查询数据
 *
 * @param bootStrapTable  分页信息
 * @param permissionUserPermit   查询条件
 * @return
 */
@ResponseBody
@GetMapping("/getPermissionUserPermitPageList")
public Map<String, Object> getPermissionUserPermitList(BootStrapTable<PermissionUserPermit> bootStrapTable,PermissionUserPermit permissionUserPermit) {
        Map<String,Object> result = new HashMap<String,Object>();
        try {
                result = bootStrapTable.setRows(iPermissionUserPermitService.selectPage(bootStrapTable,permissionUserPermit));
            } catch (Exception e) {
                logger.error("getPermissionUserPermitList -=- {}",e.toString());
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
@RequestMapping(method=RequestMethod.GET,value="/permissionUserPermitAdd")
public String permissionUserPermitAdd(HttpServletRequest request,HttpServletResponse response,Model model) {
        try {


        }catch (Exception ex){
        logger.error("permissionUserPermitAdd -=- {}",ex.toString());
        }
        return "permissionUserPermitAdd";
        }

/**
 * 跳转修改页面
 * @param request
 * @param id  实体ID
 * @return
 */
@RequestMapping(method=RequestMethod.GET,value="/permissionUserPermitUpdate")
public String permissionUserPermitUpdate(HttpServletRequest request,Long id) {
        try {
    PermissionUserPermit permissionUserPermit = iPermissionUserPermitService.selectById(id);
        request.setAttribute("permissionUserPermit",permissionUserPermit);
        }catch (Exception ex){
        logger.error("permissionUserPermitUpdate -=- {}",ex.toString());
        }
        return "permissionUserPermitUpd";
        }

/**
 * 保存和修改公用的
 * @param permissionUserPermit  传递的实体
 * @return  0 失败  1 成功
 */
@ResponseBody
@RequestMapping(method=RequestMethod.POST,value="/permissionUserPermitSave")
public int permissionUserPermitSave(PermissionUserPermit permissionUserPermit) {
        int count = 0;
        try {
        count = iPermissionUserPermitService.insertOrUpdate(permissionUserPermit) ? 1 : 0;
        } catch (Exception e) {
        logger.error("permissionUserPermitSave -=- {}",e.toString());
        }
        return count;
        }

/**
 * 根据id删除对象
 * @param id  实体ID
 * @return 0 失败  1 成功
 */
@ResponseBody
@RequestMapping(method= RequestMethod.POST,value="/permissionUserPermitDelete")
public int permissionUserPermitDelete(Long id){
        int count = 0;
        try {
        count = iPermissionUserPermitService.deleteById(id) ? 1 : 0;
        }catch (Exception e){
        logger.error("permissionUserPermitDelete -=- {}",e.toString());
        }
        return count;
        }

/**
 * 批量删除对象
 * @param item 实体集合ID
 * @return  0 失败  1 成功
 */
@ResponseBody
@RequestMapping(method= RequestMethod.POST,value="/permissionUserPermitBatchDelete")
public int deleteBatchIds(String item){
        int count = 0;
        try {
        List<Long> ids = (List<Long>) JSON.parse(item);
        count = iPermissionUserPermitService.deleteBatchIds(ids) ? 1 : 0;
        }catch (Exception e){
        logger.error("permissionUserPermitBatchDelete -=- {}",e.toString());
        }
        return count;
        }


        }