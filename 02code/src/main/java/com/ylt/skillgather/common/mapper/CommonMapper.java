package com.ylt.skillgather.common.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 自定义需要执行的SQL语句
 * </p>
 *
 * @author yuliantao
 * @since 2018-11-24
 */
public interface CommonMapper{

    void excuteSql(@Param(value = "sql") String sql);
}
