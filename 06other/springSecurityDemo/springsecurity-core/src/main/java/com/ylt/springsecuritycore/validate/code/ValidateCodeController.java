/**
 * 
 */
package com.ylt.springsecuritycore.validate.code;


import com.ylt.springsecuritycore.properties.MySecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import sun.security.util.SecurityConstants;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @author zhailiang
 *
 */
@RestController
public class ValidateCodeController {

	public static  final String SESSION_KEY="SESSION_KEY_CODE";
	private SessionStrategy sessionStrategy=new HttpSessionSessionStrategy();

	@Autowired
	private ValidateCodeGenerator validateCodeGenerator;

	@GetMapping("/code/image")
	public void createCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ImageCode imageCode=validateCodeGenerator.createImageCode(new ServletWebRequest(request));
		sessionStrategy.setAttribute(new ServletWebRequest(request),SESSION_KEY,imageCode);
		ImageIO.write(imageCode.getImage(),"JPEG",response.getOutputStream());
	}

}
