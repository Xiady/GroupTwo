package com.number2.redbaby;

import com.google.gson.Gson;
import com.number2.redbaby.bean.LoginReponse;
import com.number2.redbaby.utils.HttpUtil;
import com.number2.redbaby.utils.HttpUtil.RequestListener;
import com.number2.redbaby.utils.NetWorkUtils;
import com.number2.redbaby.utils.SessionUtil;
import com.number2.redbaby.utils.SessionUtil.SessionJsoncallBack;
import com.number2.redbaby.utils.URLUtils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity implements
		android.view.View.OnClickListener {

	protected static final int FAILED = 0;
	protected static final int SUCCESS = 1;
	private TextView mRegisterText;
	private EditText mLoginName;
	private EditText mLoginPwd;
	private TextView mLoginText;
	private String username;
	private String userpwd;
	private TextView mCallBackIm;
	private HttpUtil mHttpUtil;
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {

			int num = msg.what;
			String result = (String) msg.obj;

			switch (num) {
			case FAILED:

				Toast.makeText(LoginActivity.this, result, 0).show();
				break;

			case SUCCESS:
				Toast.makeText(LoginActivity.this, result, 0).show();
				break;

			}

		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		initView();
		mHttpUtil = new HttpUtil();

	}

	/**
	 * 初始化view
	 */
	private void initView() {
		// 用户名
		mLoginName = (EditText) findViewById(R.id.login_name_edit);
		// 密码
		mLoginPwd = (EditText) findViewById(R.id.login_pwd_edit);
		// 登录
		mLoginText = (TextView) findViewById(R.id.login_text);
		mLoginText.setOnClickListener(this);
		// 注册
		mRegisterText = (TextView) findViewById(R.id.register_text);
		mRegisterText.setOnClickListener(this);
		// 返回键
		mCallBackIm = (TextView) findViewById(R.id.callBackIm);
		mCallBackIm.setOnClickListener(this);

	}

	/**
	 * 返回上一级
	 */
	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}

	/**
	 * 点击事件
	 */
	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.callBackIm:
			onBackPressed();
			overridePendingTransition(R.anim.from_left, R.anim.from_right);
			break;

		case R.id.login_text:
			username = mLoginName.getText().toString();
			userpwd = mLoginPwd.getText().toString();
			String path=URLUtils.URL_LOGIN_PATH+"?username="+username+"&password="+userpwd;
			new SessionUtil(getApplicationContext()).getSession(path,new SessionJsoncallBack() {
				
				@Override
				public void setSessionJson(String json) {
				Log.e("TAG", "登录成功"+json);
				startActivity(new Intent(getApplicationContext(), HomeActivity.class));
				}
			});
			
			// mHttpUtil.GetHttpData(username, userpwd, LoginActivity.this,
			// URLUtils.URL_LOGIN_PATH, new RequestListener() {
			//
			//
			//
			// @Override
			// public void CallBack(String json) {
			// Log.i("TAG", json);
			// Gson gson = new Gson();
			// LoginReponse fromJson = gson.fromJson(json,
			// LoginReponse.class);
			// userId = fromJson.getUserinfo().getUserId();
			// String usersession = fromJson.getUserinfo().getUsersession();
			// String response = fromJson.getResponse();
			// if (!(username.isEmpty() && userpwd.isEmpty())) {
			// if (response.equals("login")) {
			// Toast.makeText(getApplicationContext(),
			// "登录成功", Toast.LENGTH_SHORT).show();
			// } else {
			// Toast.makeText(getApplicationContext(),
			// "登录失败", Toast.LENGTH_SHORT).show();
			// }
			// } else {
			// Toast.makeText(getApplicationContext(),
			// "账户或密码不能为空", Toast.LENGTH_SHORT).show();
			// }
			//
			// }
			//
			// });

			break;
		case R.id.register_text:
			// logPost();
			username = mLoginName.getText().toString();
			userpwd = mLoginPwd.getText().toString();
			mHttpUtil.GetHttpData(username, userpwd, LoginActivity.this,
					URLUtils.URL_REGISTER_PATH, new RequestListener() {

						@Override
						public void CallBack(String json) {
							Gson gson = new Gson();
							LoginReponse fromJson = gson.fromJson(json,
									LoginReponse.class);
							String response = fromJson.getResponse();
							if (!(username.isEmpty() && userpwd.isEmpty())) {
								if (response.equals("register")) {
									Toast.makeText(getApplicationContext(),
											"注册成功", Toast.LENGTH_SHORT).show();
								} else {
									Toast.makeText(getApplicationContext(),
											"注册失败", Toast.LENGTH_SHORT).show();
								}
							} else {
								Toast.makeText(getApplicationContext(),
										"账户或密码不能为空", Toast.LENGTH_SHORT).show();
							}
						}

					});
			break;
		default:
			break;
		}

	}

	public void logPost() {

		username = mLoginName.getText().toString().trim();
		userpwd = mLoginPwd.getText().toString().trim();

		new Thread() {

			public void run() {
				String result = NetWorkUtils.getStrPost(
						URLUtils.URL_LOGIN_PATH, username, userpwd);
				Log.i("TAG", result);
				if (result == null) {
					Message msg = Message.obtain();
					msg.obj = result;
					msg.what = FAILED;
					handler.sendMessage(msg);
				} else {
					Message msg = Message.obtain();
					msg.obj = result;
					msg.what = SUCCESS;
					handler.sendMessage(msg);
				}

			};
		}.start();

	}
}
