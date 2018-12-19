/**
 * 
 */
package com.ylt.springsecuritycore.support;

/**
 * @author ylt
 * 用户信息返回包装类
 */
public class SimpleResponse {
	
	public SimpleResponse(Object content){
		this.content = content;
	}
	
	private Object content;

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}
	
}
