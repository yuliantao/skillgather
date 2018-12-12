/**
 * 
 */
package com.ylt.springsecuritycore.validate.code.sms;

import com.ylt.springsecuritycore.properties.MySecurityProperties;
import com.ylt.springsecuritycore.validate.code.ValidateCode;
import com.ylt.springsecuritycore.validate.code.ValidateCodeGenerator;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;


/**
 * @author zhailiang
 *
 */
@Component("smsValidateCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {

	@Autowired
	private MySecurityProperties securityProperties;
	
	@Override
	public ValidateCode generate(ServletWebRequest request) {
		String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
		return new ValidateCode(code, securityProperties.getCode().getSms().getExpirIn());
	}

	public MySecurityProperties getSecurityProperties() {
		return securityProperties;
	}

	public void setSecurityProperties(MySecurityProperties securityProperties) {
		this.securityProperties = securityProperties;
	}
}
