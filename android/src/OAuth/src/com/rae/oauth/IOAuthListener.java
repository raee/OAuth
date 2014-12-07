package com.rae.oauth;

/**
 * 认证回调
 * 
 * @author ChenRui
 * 
 */
public interface IOAuthListener {
	/**
	 * 认证取消
	 */
	void onOAuthCancle();

	/**
	 * 认证成功
	 * 
	 * @param info
	 *            认证信息
	 */
	void onOAuthSuccess(OAuthInfo info);

	/**
	 * 认证错误
	 * 
	 * @param code
	 *            错误码
	 * @param msg
	 *            错误消息
	 */
	void onOAuthError(String code, String msg);
}
