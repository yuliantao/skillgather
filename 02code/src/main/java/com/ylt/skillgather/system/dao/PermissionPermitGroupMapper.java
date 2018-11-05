package com.ylt.skillgather.system.dao;

import com.ylt.skillgather.system.domain.PermissionPermitGroup;
import java.util.List;

public interface PermissionPermitGroupMapper {
    int deleteByPrimaryKey(String groupcode);

    int insert(PermissionPermitGroup record);

    PermissionPermitGroup selectByPrimaryKey(String groupcode);

    List<PermissionPermitGroup> selectAll();

    int updateByPrimaryKey(PermissionPermitGroup record);
}