package com.ylt.skillgather.system.dao;

import com.ylt.skillgather.system.domain.PermissionAction;
import java.util.List;

public interface PermissionActionMapper {
    int deleteByPrimaryKey(String actioncode);

    int insert(PermissionAction record);

    PermissionAction selectByPrimaryKey(String actioncode);

    List<PermissionAction> selectAll();

    int updateByPrimaryKey(PermissionAction record);
}