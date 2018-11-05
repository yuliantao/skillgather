package com.ylt.skillgather.system.dao;

import com.ylt.skillgather.system.domain.PermissionModule;
import java.util.List;

public interface PermissionModuleMapper {
    int deleteByPrimaryKey(String modulecode);

    int insert(PermissionModule record);

    PermissionModule selectByPrimaryKey(String modulecode);

    List<PermissionModule> selectAll();

    int updateByPrimaryKey(PermissionModule record);
}