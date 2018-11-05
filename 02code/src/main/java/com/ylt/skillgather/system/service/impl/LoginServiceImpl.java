package com.ylt.skillgather.system.service.impl;

import com.ylt.skillgather.system.dao.PermissionUserMapper;
import com.ylt.skillgather.system.domain.PermissionUser;
import com.ylt.skillgather.system.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    PermissionUserMapper permissionUserMapper;

    @Override
    public PermissionUser login(String username, String password) {
        return permissionUserMapper.login(username,password);
    }
}
