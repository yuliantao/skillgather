package cn.ylt.springcloud.service.impl;

import cn.ylt.springcloud.dao.DeptDao;
import cn.ylt.springcloud.entities.Dept;
import cn.ylt.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuliantao
 * @create 2019-01-09 22:53
 * @description 功能描述
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao dao;
    @Override
    public boolean add(Dept dept)
    {
        return dao.addDept(dept);
    }
    @Override
    public Dept get(Long id)
    {
        return dao.findById(id);
    }
    @Override
    public List<Dept> list()
    {
        return dao.findAll();
    }
}
