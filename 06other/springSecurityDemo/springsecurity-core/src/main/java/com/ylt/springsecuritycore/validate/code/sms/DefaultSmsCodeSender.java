package com.ylt.springsecuritycore.validate.code.sms;

/**
 * @author yuliantao
 * @create 2018-12-08 10:33
 * @description 功能描述
 */
public class DefaultSmsCodeSender implements SmsCodeSender {
    @Override
    public void send(String mobile, String code) {
        System.out.println("向手机："+mobile+"发送短信验证码:"+code);
    }
}
