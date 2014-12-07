package com.rae.oauth;

import android.app.Activity;

/**
 * 第三方认证接口
 * 
 * <ul>
 * 所有的认证必须使用网络权限：
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
	 * 类型转换错误
	 */
	public static final String	ERROR_PARSE		= "1000";
	/**
	 * JSON解析错误
	 */
	public static final String	ERROR_JSON		= "1001";
	/**
	 * 已经登录
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
	 * 应用ID
	 * 
	 * @return
	 */
	public String getAppId() {
		return appId;
	}

	/**
	 * 是否已经登录授权
	 * 
	 * @return
	 */
	public abstract boolean isSessionValid();

	/**
	 * 登录，授权
	 */
	public abstract void login();

	/**
	 * 注销登录
	 */
	public abstract void logout();

	/**
	 * 设置ID
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
