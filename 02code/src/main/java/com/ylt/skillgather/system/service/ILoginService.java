package com.ylt.skillgather.system.service;

import com.ylt.skillgather.system.domain.PermissionUser;

public interface ILoginService {
    PermissionUser login(String username, String password);
}
