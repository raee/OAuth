package com.rae.oauth;

/**
 * ��֤�ɹ����ص���Ϣ
 * 
 * @author ChenRui
 * 
 */
public class OAuthInfo {
	private String	openId;		// ����Id
	private String	accessToken;	// Ψһ�ķ���Ȩ��
	private long	expiresIn;		// ���ڼ��

	/**
	 * ��ȡ����Id
	 * 
	 * @return
	 */
	public String getOpenId() {
		return openId;
	}

	/**
	 * ��ȡ����Ȩ��
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
	 * ��ȡƾ֤��Чʱ��
	 * 
	 * @return
	 */
	public long getExpiresIn() {
		return expiresIn;
	}

	/**
	 * ��ȡƾ֤����ʱ��
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
