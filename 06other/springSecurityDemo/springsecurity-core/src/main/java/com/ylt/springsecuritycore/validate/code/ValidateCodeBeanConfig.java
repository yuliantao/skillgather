/**
 * 
 */
package com.ylt.springsecuritycore.validate.code;

import com.ylt.springsecuritycore.properties.MySecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhailiang
 *
 */
@Configuration
public class ValidateCodeBeanConfig {
	
	@Autowired
	private MySecurityProperties securityProperties;
	
	@Bean
	@ConditionalOnMissingBean(name = "ValidateCodeGenerator")
	public ValidateCodeGenerator imageValidateCodeGenerator() {
		ImageCodeGenerator codeGenerator = new ImageCodeGenerator(); 
		codeGenerator.setSecurityProperties(securityProperties);
		return codeGenerator;
	}

}
