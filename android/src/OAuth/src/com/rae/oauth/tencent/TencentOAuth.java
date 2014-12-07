package com.rae.oauth.tencent;

import android.app.Activity;

import com.rae.oauth.IOAuthListener;
import com.rae.oauth.OAuth;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

/**
 * 腾讯认证
 * 
 * <pre>
 * 需要在清单文件中配置一个activity并传入应用Id。
 * {@code
 * <activity android:name="com.tencent.connect.common.AssistActivity"
 *             android:theme="@android:style/Theme.Translucent.NoTitleBar" 
 *             android:screenOrientation="portrait"/>
 *  <activity android:name="com.tencent.tauth.AuthActivity"
 *             android:launchMode="singleTask"
 *             android:noHistory="true" >
 *             <intent-filter>
 *                 <action android:name="android.intent.action.VIEW" />
 *                 <category android:name="android.intent.category.DEFAULT" />
 *                 <category android:name="android.intent.category.BROWSABLE" />
 *                 <data android:scheme="tencent这里填写应用ID" />
 *             </intent-filter></activity>
 *  }
 * 
 * @author ChenRui
 * 
 */
public class TencentOAuth extends OAuth {

	private Tencent		mTencent;
	private IUiListener	mUIListener;

	public TencentOAuth(Activity context, String appId) {
		super(context, appId);
		mTencent = Tencent.createInstance(appId, context);
	}

	@Override
	public boolean isSessionValid() {
		return mTencent.isSessionValid();
	}

	@Override
	public void login() {
		if (isSessionValid()) {
			mUIListener.onError(new UiError(Integer.parseInt(OAuth.ERROR_LOGINED), "已经登录！", "已经登录！"));
			return;
		}
		mTencent.login(getActivity(), "all", mUIListener);
	}

	@Override
	public void setOAuthListener(IOAuthListener l) {
		if (mUIListener == null) {
			mUIListener = new TencentUIListener(mTencent, l);
		}
	}

	@Override
	public void logout() {
		mTencent.logout(getActivity());
	}

}
