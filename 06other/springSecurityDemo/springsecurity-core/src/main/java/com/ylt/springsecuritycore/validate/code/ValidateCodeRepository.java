package com.ylt.springsecuritycore.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author yuliantao
 * @create 2018-12-21 20:56
 * @description 保存验证码（如果是web应用就保存到session中，session本身也可以保存在redis中。如果是其他应用保存到redis中，它没有sessionid用其他标识代替）
 */
public interface ValidateCodeRepository {

    /**
     * 保存验证码
     * @param request
     * @param validateCodeType
     */
    void save(ServletWebRequest request,ValidateCode code, ValidateCodeType validateCodeType);

    /**
     * 获取验证码
     * @param request
     * @return
     */
    ValidateCode get(ServletWebRequest request,ValidateCodeType validateCodeType);

    /**
     * 移除验证码
     * @param request
     * @param codeType
     */
    void  remove(ServletWebRequest request,ValidateCodeType codeType);


}
