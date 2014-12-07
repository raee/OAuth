package com.rae.oauth.tencent;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.rae.oauth.IOAuthListener;
import com.rae.oauth.OAuth;
import com.rae.oauth.OAuthInfo;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

public class TencentUIListener implements IUiListener {
	private IOAuthListener	mListener;
	private String			tag	= "TencentUIListener";
	private Tencent			mTencent;

	public TencentUIListener(Tencent tencent, IOAuthListener l) {
		this.mListener = l;
		this.mTencent = tencent;
	}

	@Override
	public void onCancel() {
		mListener.onOAuthCancle();
	}

	@Override
	public void onComplete(Object obj) {
		Log.i(tag, obj.toString());

		OAuthInfo info = new OAuthInfo();
		if (obj instanceof JSONObject) {
			JSONObject json = (JSONObject) obj;
			try {
				info.setAccessToken(json.getString("access_token"));
				info.setExpiresIn(Long.parseLong(json.getString("expires_in")));
				info.setOpenId(json.getString("openid"));
				mListener.onOAuthSuccess(info);
				mTencent.setOpenId(info.getOpenId());
				mTencent.setAccessToken(info.getAccessToken(), info.getExpiresIn() + "");
			}
			catch (NumberFormatException e) {
				mListener.onOAuthError(OAuth.ERROR_PARSE, "转换超时时间错误！");
			}
			catch (JSONException e) {
				mListener.onOAuthError(OAuth.ERROR_JSON, "Json解析错误!");
				e.printStackTrace();
			}
		}

	}

	@Override
	public void onError(UiError e) {
		mListener.onOAuthError(e.errorCode + "", e.errorMessage + "\r\n" + e.errorDetail);
	}

}
