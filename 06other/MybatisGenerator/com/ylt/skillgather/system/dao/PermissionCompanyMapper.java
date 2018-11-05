package com.ylt.skillgather.system.dao;

import com.ylt.skillgather.system.domain.PermissionCompany;
import java.util.List;

public interface PermissionCompanyMapper {
    int deleteByPrimaryKey(String companycode);

    int insert(PermissionCompany record);

    PermissionCompany selectByPrimaryKey(String companycode);

    List<PermissionCompany> selectAll();

    int updateByPrimaryKey(PermissionCompany record);
}