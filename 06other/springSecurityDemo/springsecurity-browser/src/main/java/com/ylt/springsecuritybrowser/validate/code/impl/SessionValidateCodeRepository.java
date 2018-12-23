package com.ylt.springsecuritybrowser.validate.code.impl;

import com.ylt.springsecuritycore.validate.code.ValidateCode;
import com.ylt.springsecuritycore.validate.code.ValidateCodeRepository;
import com.ylt.springsecuritycore.validate.code.ValidateCodeType;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author yuliantao
 * @create 2018-12-21 21:18
 * @description 功能描述
 */
@Component
public class SessionValidateCodeRepository implements ValidateCodeRepository {

    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    private SessionStrategy sessionStrategy =new HttpSessionSessionStrategy();

    private String getSessionkey(ServletWebRequest request,ValidateCodeType validateCodeType) {
        return SESSION_KEY_PREFIX + validateCodeType.toString().toUpperCase();
    }

    @Override
    public void save(ServletWebRequest request, ValidateCode code, ValidateCodeType validateCodeType) {
        sessionStrategy.setAttribute(request,getSessionkey(request,validateCodeType),code);
    }

    @Override
    public ValidateCode get(ServletWebRequest request, ValidateCodeType validateCodeType) {
        return (ValidateCode)sessionStrategy.getAttribute(request,getSessionkey(request,validateCodeType));
    }

    @Override
    public void remove(ServletWebRequest request, ValidateCodeType codeType) {
            sessionStrategy.removeAttribute(request,getSessionkey(request,codeType));
    }
}
