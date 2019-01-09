package cn.ylt.springcloud.dao;

import cn.ylt.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author yuliantao
 * @create 2019-01-09 22:30
 * @description 功能描述
 */
@Mapper
public interface DeptDao {
   public boolean addDept(Dept dept);
   public Dept findById(Long id);
   public List<Dept> findAll();
}
