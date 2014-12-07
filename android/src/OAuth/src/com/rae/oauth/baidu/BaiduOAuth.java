package com.rae.oauth.baidu;

import android.app.Activity;
import android.os.Bundle;

import com.baidu.api.Baidu;
import com.baidu.api.BaiduDialog.BaiduDialogListener;
import com.baidu.api.BaiduDialogError;
import com.baidu.api.BaiduException;
import com.rae.oauth.IOAuthListener;
import com.rae.oauth.OAuth;
import com.rae.oauth.OAuthInfo;

/**
 * °Ù¶È
 * 
 * @author ChenRui
 * 
 */
public class BaiduOAuth extends OAuth {

	private Baidu			mBaidu;
	private boolean			isForceLogin;
	private boolean			isConfirmLogin;
	private BaiduListener	mListener;
	private IOAuthListener	mOAuthListener;

	public BaiduOAuth(Activity context, String appId) {
		super(context, appId);
		mBaidu = new Baidu(getAppId(), context);
		mListener = new BaiduListener();
	}

	@Override
	public void login() {
		mBaidu.authorize(getActivity(), isForceLogin, isConfirmLogin, mListener);
	}

	@Override
	public void setOAuthListener(IOAuthListener l) {
		this.mOAuthListener = l;
	}

	@Override
	public boolean isSessionValid() {
		return mBaidu.isSessionValid();
	}

	class BaiduListener implements BaiduDialogListener {

		@Override
		public void onBaiduException(BaiduException e) {
			if (mOAuthListener != null) {
				mOAuthListener.onOAuthError(e.getErrorCode(), e.getMessage());
			}
		}

		@Override
		public void onCancel() {
			if (mOAuthListener != null) {
				mOAuthListener.onOAuthCancle();
			}
		}

		@Override
		public void onComplete(Bundle extra) {
			if (mOAuthListener != null) {
				OAuthInfo info = new OAuthInfo();
				info.setOpenId(extra.getString("session_key"));
				info.setAccessToken(mBaidu.getAccessToken());
				info.setExpiresIn(Long.parseLong(extra.getString("expires_in")));
				mOAuthListener.onOAuthSuccess(info);
			}
		}

		@Override
		public void onError(BaiduDialogError e) {
			if (mOAuthListener != null) {
				mOAuthListener.onOAuthError(e.getErrorCode() + "", e.getMessage());
			}
		}

	}

	@Override
	public void logout() {
		mBaidu.clearAccessToken();
	}

}
