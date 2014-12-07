package com.rae.oauth;

/**
 * 认证成功返回的信息
 * 
 * @author ChenRui
 * 
 */
public class OAuthInfo {
	private String	openId;		// 开放Id
	private String	accessToken;	// 唯一的访问权限
	private long	expiresIn;		// 过期间隔

	/**
	 * 获取开放Id
	 * 
	 * @return
	 */
	public String getOpenId() {
		return openId;
	}

	/**
	 * 获取访问权限
	 * 
	 * @return
	 */
	public String getAccessToken() {
		return accessToken;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * 获取凭证有效时间
	 * 
	 * @return
	 */
	public long getExpiresIn() {
		return expiresIn;
	}

	/**
	 * 获取凭证过期时间
	 * 
	 * @return
	 */
	public long getExpiresTime() {
		return System.currentTimeMillis() + expiresIn;
	}

	public void setExpiresIn(long expiresIn) {
		this.expiresIn = expiresIn;
	}

}
