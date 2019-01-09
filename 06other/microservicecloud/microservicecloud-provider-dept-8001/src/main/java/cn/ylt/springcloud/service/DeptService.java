package cn.ylt.springcloud.service;

import cn.ylt.springcloud.entities.Dept;

import java.util.List;

/**
 * @author yuliantao
 * @create 2019-01-09 22:52
 * @description 功能描述
 */
public interface DeptService {
    public boolean add(Dept dept);
    public Dept get(Long id);
    public List<Dept> list();
}
