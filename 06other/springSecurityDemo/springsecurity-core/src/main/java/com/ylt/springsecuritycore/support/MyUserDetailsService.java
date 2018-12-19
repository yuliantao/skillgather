package com.ylt.springsecuritycore.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author yuliantao
 * @create 2018-12-03 13:41
 * @description 功能描述
 */
public class MyUserDetailsService implements UserDetailsService {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //密码和权限应从数据库取，现在用静态
        //3个true一个false是针对账号的状态，账户是否过期，密码是否过期，账户是否删除，账户被锁定，实际开发中需要根据数据库字段进行逻辑判断");
        return new User(s,new BCryptPasswordEncoder().encode("123456"),true,true,true,true, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,user"));
    }
}
