package com.ylt.skillgather.system.dao;

import com.ylt.skillgather.system.domain.PermissionUserPermit;
import java.util.List;

public interface PermissionUserPermitMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(PermissionUserPermit record);

    PermissionUserPermit selectByPrimaryKey(Integer userid);

    List<PermissionUserPermit> selectAll();

    int updateByPrimaryKey(PermissionUserPermit record);
}