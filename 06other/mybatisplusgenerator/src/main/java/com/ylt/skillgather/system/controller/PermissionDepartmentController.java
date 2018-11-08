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
import com.ylt.skillgather.system.service.IPermissionDepartmentService;
import com.ylt.skillgather.system.entity.PermissionDepartment;
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
@RequestMapping("/system/permission-department")
public class PermissionDepartmentController extends BaseController {
private final Logger logger = LoggerFactory.getLogger(PermissionDepartmentController.class);

@Autowired
public IPermissionDepartmentService iPermissionDepartmentService;

/**
 * 跳转列表页面
 * @param request
 * @param model
 * @return
 */
@RequestMapping(method= RequestMethod.GET,value = {"/permissionDepartmentIndex"})
public String index(HttpServletRequest request, Model model)
        {
             return "permissionDepartmentListIndex";
        }

/**
 * 分页查询数据
 *
 * @param bootStrapTable  分页信息
 * @param permissionDepartment   查询条件
 * @return
 */
@ResponseBody
@GetMapping("/getPermissionDepartmentPageList")
public Map<String, Object> getPermissionDepartmentList(BootStrapTable<PermissionDepartment> bootStrapTable,PermissionDepartment permissionDepartment) {
        Map<String,Object> result = new HashMap<String,Object>();
        try {
                result = bootStrapTable.setRows(iPermissionDepartmentService.selectPage(bootStrapTable,permissionDepartment));
            } catch (Exception e) {
                logger.error("getPermissionDepartmentList -=- {}",e.toString());
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
@RequestMapping(method=RequestMethod.GET,value="/permissionDepartmentAdd")
public String permissionDepartmentAdd(HttpServletRequest request,HttpServletResponse response,Model model) {
        try {


        }catch (Exception ex){
        logger.error("permissionDepartmentAdd -=- {}",ex.toString());
        }
        return "permissionDepartmentAdd";
        }

/**
 * 跳转修改页面
 * @param request
 * @param id  实体ID
 * @return
 */
@RequestMapping(method=RequestMethod.GET,value="/permissionDepartmentUpdate")
public String permissionDepartmentUpdate(HttpServletRequest request,Long id) {
        try {
    PermissionDepartment permissionDepartment = iPermissionDepartmentService.selectById(id);
        request.setAttribute("permissionDepartment",permissionDepartment);
        }catch (Exception ex){
        logger.error("permissionDepartmentUpdate -=- {}",ex.toString());
        }
        return "permissionDepartmentUpd";
        }

/**
 * 保存和修改公用的
 * @param permissionDepartment  传递的实体
 * @return  0 失败  1 成功
 */
@ResponseBody
@RequestMapping(method=RequestMethod.POST,value="/permissionDepartmentSave")
public int permissionDepartmentSave(PermissionDepartment permissionDepartment) {
        int count = 0;
        try {
        count = iPermissionDepartmentService.insertOrUpdate(permissionDepartment) ? 1 : 0;
        } catch (Exception e) {
        logger.error("permissionDepartmentSave -=- {}",e.toString());
        }
        return count;
        }

/**
 * 根据id删除对象
 * @param id  实体ID
 * @return 0 失败  1 成功
 */
@ResponseBody
@RequestMapping(method= RequestMethod.POST,value="/permissionDepartmentDelete")
public int permissionDepartmentDelete(Long id){
        int count = 0;
        try {
        count = iPermissionDepartmentService.deleteById(id) ? 1 : 0;
        }catch (Exception e){
        logger.error("permissionDepartmentDelete -=- {}",e.toString());
        }
        return count;
        }

/**
 * 批量删除对象
 * @param item 实体集合ID
 * @return  0 失败  1 成功
 */
@ResponseBody
@RequestMapping(method= RequestMethod.POST,value="/permissionDepartmentBatchDelete")
public int deleteBatchIds(String item){
        int count = 0;
        try {
        List<Long> ids = (List<Long>) JSON.parse(item);
        count = iPermissionDepartmentService.deleteBatchIds(ids) ? 1 : 0;
        }catch (Exception e){
        logger.error("permissionDepartmentBatchDelete -=- {}",e.toString());
        }
        return count;
        }


        }