/**
 * 
 */
package com.ylt.springsecuritycore.properties;

/**
 * @author zhailiang
 *
 */
public class ImageCodeProperties {
	

	private int width = 67;
	private int height = 23;
	private int length = 4;
	private int expirIn = 60;
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

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
}
