package com.ylt.skillgather.codegenerator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ylt.skillgather.codegenerator.entity.GeneratorTable;

/**
 * <p>
 * 扫描到需要生产系统的表 服务类
 * </p>
 *
 * @author yuliantao
 * @since 2018-11-24
 */
public interface IGeneratorTableService extends IService<GeneratorTable> {
    int excuteSql(String sql);
}
