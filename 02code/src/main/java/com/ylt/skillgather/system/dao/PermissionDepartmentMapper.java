package com.ylt.skillgather.system.dao;

import com.ylt.skillgather.system.domain.PermissionDepartment;
import java.util.List;

public interface PermissionDepartmentMapper {
    int deleteByPrimaryKey(String departmentcode);

    int insert(PermissionDepartment record);

    PermissionDepartment selectByPrimaryKey(String departmentcode);

    List<PermissionDepartment> selectAll();

    int updateByPrimaryKey(PermissionDepartment record);
}