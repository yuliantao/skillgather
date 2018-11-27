package com.ylt.skillgather.common.service.impl;

import com.ylt.skillgather.common.mapper.CommonMapper;
import com.ylt.skillgather.common.service.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CommonServiceImpl implements ICommonService {

    @Autowired
    private CommonMapper commonMapper;
    public void excuteSql(String sql)
    {
        commonMapper.excuteSql(sql);
    }
}
