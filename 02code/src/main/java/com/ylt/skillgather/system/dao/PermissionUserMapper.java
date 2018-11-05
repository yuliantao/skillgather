package com.ylt.skillgather.system.dao;

import com.ylt.skillgather.system.domain.PermissionUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionUserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(PermissionUser record);

    PermissionUser selectByPrimaryKey(Integer userid);

    List<PermissionUser> selectAll();

    int updateByPrimaryKey(PermissionUser record);

    PermissionUser login(@Param("username") String username, @Param("password") String password);
}