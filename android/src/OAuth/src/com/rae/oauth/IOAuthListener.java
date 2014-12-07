package com.rae.oauth;

/**
 * ��֤�ص�
 * 
 * @author ChenRui
 * 
 */
public interface IOAuthListener {
	/**
	 * ��֤ȡ��
	 */
	void onOAuthCancle();

	/**
	 * ��֤�ɹ�
	 * 
	 * @param info
	 *            ��֤��Ϣ
	 */
	void onOAuthSuccess(OAuthInfo info);

	/**
	 * ��֤����
	 * 
	 * @param code
	 *            ������
	 * @param msg
	 *            ������Ϣ
	 */
	void onOAuthError(String code, String msg);
}
