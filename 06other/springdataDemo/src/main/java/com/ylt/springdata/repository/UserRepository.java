package com.ylt.springdata.repository;

import com.ylt.springdata.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yuliantao
 * @create 2018-11-30 10:28
 * @description 普通数据库映射的增删改查
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}
