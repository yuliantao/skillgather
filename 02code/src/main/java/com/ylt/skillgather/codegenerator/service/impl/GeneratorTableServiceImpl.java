package com.ylt.skillgather.codegenerator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ylt.skillgather.codegenerator.entity.GeneratorTable;
import com.ylt.skillgather.codegenerator.mapper.GeneratorTableMapper;
import com.ylt.skillgather.codegenerator.service.IGeneratorTableService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 扫描到需要生产系统的表 服务实现类
 * </p>
 *
 * @author yuliantao
 * @since 2018-11-24
 */
@Service
public class GeneratorTableServiceImpl extends ServiceImpl<GeneratorTableMapper, GeneratorTable> implements IGeneratorTableService {
    public int excuteSql(String sql)
    {
        return super.baseMapper.excuteSql(sql);
    }
}
