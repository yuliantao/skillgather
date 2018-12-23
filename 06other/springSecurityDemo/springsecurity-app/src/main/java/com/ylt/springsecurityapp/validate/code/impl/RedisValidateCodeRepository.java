package com.ylt.springsecurityapp.validate.code.impl;

import com.ylt.springsecuritycore.validate.code.ValidateCode;
import com.ylt.springsecuritycore.validate.code.ValidateCodeException;
import com.ylt.springsecuritycore.validate.code.ValidateCodeRepository;
import com.ylt.springsecuritycore.validate.code.ValidateCodeType;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.concurrent.TimeUnit;

/**
 * @author yuliantao
 * @create 2018-12-21 21:34
 * @description 功能描述
 */
@Component
public class RedisValidateCodeRepository implements ValidateCodeRepository {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    private String buildkey(ServletWebRequest request,ValidateCodeType type) {
        String deviceId = request.getHeader("deviceId");
        if (StringUtils.isBlank(deviceId)) {
            logger.info("请在请求头中携带deviceId参数");
            throw new ValidateCodeException("请在请求头中携带deviceId参数");
        }
        return "code:" + type.toString().toLowerCase() + ":" + deviceId;
    }

    @Override
    public void save(ServletWebRequest request, ValidateCode code, ValidateCodeType type) {
        redisTemplate.opsForValue().set(buildkey(request,type),code,30, TimeUnit.MINUTES);
    }

    @Override
    public ValidateCode get(ServletWebRequest request, ValidateCodeType type) {
        Object value=redisTemplate.opsForValue().get(buildkey(request,type));
        if (value==null)
        {
            return null;
        }
        return (ValidateCode) value;
    }

    @Override
    public void remove(ServletWebRequest request, ValidateCodeType type) {
        redisTemplate.delete(buildkey(request,type));
    }






}
