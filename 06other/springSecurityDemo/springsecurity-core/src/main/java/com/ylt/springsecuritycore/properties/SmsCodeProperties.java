/**
 * 
 */
package com.ylt.springsecuritycore.properties;

/**
 * @author zhailiang
 *
 */
public class SmsCodeProperties {

	private int length = 6;
	private int expirIn = 60;
	private String url;//用于判断链接是否需要进行验证码验证

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getExpirIn() {
		return expirIn;
	}

	public void setExpirIn(int expirIn) {
		this.expirIn = expirIn;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
