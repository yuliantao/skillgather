/**
 * 
 */
package com.ylt.springsecuritycore.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author zhailiang
 *
 */
public interface ValidateCodeGenerator {

	ImageCode createImageCode(ServletWebRequest request);
}
