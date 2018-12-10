package com.ylt.springsecuritycore.validate.code.sms;

/**
 * @author yuliantao
 * @create 2018-12-08 10:31
 * @description 短信发送接口
 */
public interface SmsCodeSender {
    void send(String mobile,String code);
}
