package com.ylt.skillgather.system.dao;

import com.ylt.skillgather.system.domain.PermissionRole;
import java.util.List;

public interface PermissionRoleMapper {
    int deleteByPrimaryKey(String rolecode);

    int insert(PermissionRole record);

    PermissionRole selectByPrimaryKey(String rolecode);

    List<PermissionRole> selectAll();

    int updateByPrimaryKey(PermissionRole record);
}