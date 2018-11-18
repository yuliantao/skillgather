package com.ylt.skillgather.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ylt.skillgather.common.utils.ClassUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.Proxy;
import java.util.List;

import static com.ylt.skillgather.common.utils.ClassUtils.getGenericType;

/**
 * @author yuliantao
 * @create 2018-11-08 23:35
 * @description 通用控制器,此控制器实现了通用的增删改查功能
 * 需要提供一个实现了{@link IService}接口的实现类
 */
public abstract class BaseController <PO> {

    /**
     * 获取此Controller需要的服务类,由子类实现
     *
     * @return 通用服务类
     */
    protected abstract IService<PO> getService();

    /**
     * 获取PO的类型
     *
     * @return PO类型
     */
    protected final Class<PO> getPOType() {
        return (Class<PO>) ClassUtils.getGenericType(this.getClass(), 0);

    }

    /**
     * 获取数据列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<PO>  findListByPage() {
//            Page page = new Page(pageIndex,step);
//            targetService.selectPage(page);
//            return BaseResponse.onSuccess(page);
        return  getService().list(null);
    }


    /**
     * 获取全部数据
     */
    @RequestMapping("/all")
    @ResponseBody
    public List<PO> findAll() {
        /*        List<${entity}> models = targetService.selectList(null);
                return BaseResponse.onSuccess(models);*/
          return  getService().list(null);
    }


    /**
     * 根据ID查找数据
     */
    @RequestMapping("/find")
    @ResponseBody
    public PO find(@RequestParam("id") Long id) {
        /*        ${entity} ${entity} = targetService.selectById(id);
                if(${entity}==null){
                return BaseResponse.onFail("尚未查询到此ID");
                }
                return BaseResponse.onSuccess(${entity});*/
        return  getService().getOne(new QueryWrapper<PO>().eq("ID",id));
    }


    /**
     * 添加数据
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public boolean addItem(@RequestBody PO po) {
    /*        boolean isOk = targetService.insert(${entity});
            if(isOk){
            return BaseResponse.onSuccess("数据添加成功！");
            }
            return BaseResponse.onFail("数据添加失败");*/
        return  getService().save(po);
    }


    /**
     * 更新数据
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public boolean updateItem(@RequestBody PO po) {
        /*        boolean isOk = targetService.updateAllColumnById(${entity});
                if(isOk){
                return BaseResponse.onSuccess("数据更改成功！");
                }
                return BaseResponse.onFail("数据更改失败");*/
        return getService().updateById(po);
    }


    /**
     * 删除数据
     */
    @RequestMapping("/del")
    @ResponseBody
    public boolean deleteItems(@RequestParam("ids") List<Long> ids) {
/*            boolean isOk = targetService.deleteBatchIds(ids);
            if(isOk){
            return BaseResponse.onSuccess("数据删除成功！");
            }
            return BaseResponse.onFail("数据删除失败");
            }*/
        return getService().removeByIds(ids);
    }
}


