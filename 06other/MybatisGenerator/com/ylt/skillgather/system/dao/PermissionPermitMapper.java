package com.ylt.skillgather.system.dao;

import com.ylt.skillgather.system.domain.PermissionPermit;
import java.util.List;

public interface PermissionPermitMapper {
    int deleteByPrimaryKey(String permitcode);

    int insert(PermissionPermit record);

    PermissionPermit selectByPrimaryKey(String permitcode);

    List<PermissionPermit> selectAll();

    int updateByPrimaryKey(PermissionPermit record);
}