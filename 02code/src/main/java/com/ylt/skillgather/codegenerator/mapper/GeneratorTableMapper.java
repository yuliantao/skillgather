package com.ylt.skillgather.codegenerator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ylt.skillgather.codegenerator.entity.GeneratorTable;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 扫描到需要生产系统的表 Mapper 接口
 * </p>
 *
 * @author yuliantao
 * @since 2018-11-24
 */
public interface GeneratorTableMapper extends BaseMapper<GeneratorTable> {

    int excuteSql(String sql);
}
