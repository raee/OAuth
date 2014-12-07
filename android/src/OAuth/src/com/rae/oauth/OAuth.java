package com.rae.oauth;

import android.app.Activity;

/**
 * ��������֤�ӿ�
 * 
 * <ul>
 * ���е���֤����ʹ������Ȩ�ޣ�
 * <li>{@link android.Manifest.permission#ACCESS_NETWORK_STATE
 * ACCESS_NETWORK_STATE}</li>
 * <li>{@link android.Manifest.permission#INTERNET INTERNET}</li>
 * </ul>
 * 
 * @author ChenRui
 * 
 */
public abstract class OAuth {
	/**
	 * ����ת������
	 */
	public static final String	ERROR_PARSE		= "1000";
	/**
	 * JSON��������
	 */
	public static final String	ERROR_JSON		= "1001";
	/**
	 * �Ѿ���¼
	 */
	public static final String	ERROR_LOGINED	= "1002";

	private Activity			context;
	private String				appId;
	private String				openId;
	private String				accessToken;

	public OAuth(Activity context, String appId) {
		this.context = context;
		this.appId = appId;
	}

	protected Activity getActivity() {
		return context;
	}

	/**
	 * Ӧ��ID
	 * 
	 * @return
	 */
	public String getAppId() {
		return appId;
	}

	/**
	 * �Ƿ��Ѿ���¼��Ȩ
	 * 
	 * @return
	 */
	public abstract boolean isSessionValid();

	/**
	 * ��¼����Ȩ
	 */
	public abstract void login();

	/**
	 * ע����¼
	 */
	public abstract void logout();

	/**
	 * ����ID
	 * 
	 * @param openId
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public abstract void setOAuthListener(IOAuthListener l);
}
