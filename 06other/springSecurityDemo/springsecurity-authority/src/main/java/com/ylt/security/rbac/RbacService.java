package com.ylt.security.rbac;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yuliantao
 * @create 2018-12-17 21:38
 * @description 功能描述
 */
public interface RbacService {
    boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
