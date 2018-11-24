package com.ylt.skillgather.coreframe.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ylt.skillgather.common.utils.ClassUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


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
        return  getService().list(null);
    }


    /**
     * 获取全部数据
     */
    @RequestMapping("/all")
    @ResponseBody
    public List<PO> findAll() {
          return  getService().list(null);
    }


    /**
     * 根据ID查找数据
     */
    @RequestMapping("/find")
    @ResponseBody
    public PO find(@RequestParam("id") Long id) {
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
    public boolean updateItem(PO po, HttpServletRequest request) {
        return getService().updateById(po);
    }


    /**
     * 删除数据
     */
    @RequestMapping("/del")
    @ResponseBody
    public boolean deleteItems(@RequestParam("ids") List<Long> ids) {
        return getService().removeByIds(ids);
    }


    /**
     * 更新数据
     */
    @RequestMapping(value = "/jqgridedite")
    @ResponseBody
    public boolean jqgridEdite(PO po, HttpServletRequest request) {

         String oper= request.getParameter("oper");
        switch (oper)
        {
            case "edit":
                return getService().updateById(po);
            case "del":
                Integer id=Integer.valueOf(request.getParameter("id"));
                return getService().removeById(id);
            case "add":
                return getService().save(po);
            default:
                return  false;
        }
    }

    /**
     * 获取数据列表
     */
    @RequestMapping("/jqgridlist")
    @ResponseBody
    public List<PO>  jqgridlist(HttpServletRequest request) {
         List<PO> lits= getService().list(null);
        return lits;
    }
}
