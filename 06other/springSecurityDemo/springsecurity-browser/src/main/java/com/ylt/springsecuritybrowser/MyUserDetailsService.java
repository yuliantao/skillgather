package com.ylt.springsecuritybrowser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author yuliantao
 * @create 2018-12-03 13:41
 * @description 功能描述
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        logger.info("此处的用户密码和所用权限应该从数据库读取出来，现在实验就用静态");
        logger.info("此处3个true一个false是针对账号的状态，账户是否过期，密码是否过期，账户是否删除，账户被锁定，实际开发中需要根据数据库字段进行逻辑判断");
        return new User(s,new BCryptPasswordEncoder().encode("123456"),true,true,true,true, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,user"));
    }
}
