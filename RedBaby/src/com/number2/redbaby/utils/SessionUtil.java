package com.number2.redbaby.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.content.Context;
import android.util.Log;

import com.number2.redbaby.app.MyApplication;

public class SessionUtil {
	private Context context;

	public SessionUtil(Context context) {
		super();
		this.context = context;
	}

	String path = "http://121.42.8.95:8090/ECServer_D";

	//接口回调的方法
		public interface SessionJsoncallBack{
			void setSessionJson(String json);
		} 
	// 得到session/cookie值并保存
	public void getSession(final String ur,final SessionJsoncallBack callBack) {
		new Thread() {
			public void run() {
				try {
					URL url = new URL(path+ur);
					HttpURLConnection con = (HttpURLConnection) url
							.openConnection();
					if (con.getResponseCode() == 200) {
						// 得到cookieVal
						String cookie = con.getHeaderField("set-cookie");
						// System.out.println("cookieval--->"+cookie);
						// 得到sessionid
						String sessionid = cookie.substring(0,
								cookie.indexOf(";"));
						// System.out.println("cookie---->" + sessionid);
						// 将cookie值进行保存
						MyApplication.setSessionid(sessionid);
						
						Log.e("TAG","保存成功"+sessionid);
						InputStream is = con.getInputStream();
						BufferedReader reader = new BufferedReader(
								new InputStreamReader(is));
						String str = null;
						StringBuffer sb = new StringBuffer();
						while ((str = reader.readLine()) != null) {
							sb.append(str);
						}
						
						callBack.setSessionJson(sb.toString());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			};
		}.start();

	}

	//接口回调的方法
	public interface SessioncallBack{
		void setSession(String json);
	}
	// 得到session/cookie值
	public void netWork(final String ur ,final SessioncallBack callBack) {
		new Thread() {
			public void run() {
				try {
					URL url = new URL(path+ur);
					HttpURLConnection connection = (HttpURLConnection) url
							.openConnection();
					// 得到存储的cookie值
					String cookie = MyApplication.getSessionid();
					System.out.println(cookie);
					// 将cookie值
					// 设置cookie，这样web服务器在接受请求的时候就会自动搜索对应的cookie了，从而保证了在同一会话Session
					connection.setRequestProperty("cookie", cookie);
					if (connection.getResponseCode() == 200) {
						System.out.println("哈哈 ");
						InputStream is = connection.getInputStream();
						BufferedReader reader = new BufferedReader(
								new InputStreamReader(is));
						String str = null;
						StringBuffer sb = new StringBuffer();
						while ((str = reader.readLine()) != null) {
							sb.append(str);
						}
						System.out.println(sb.toString());
						callBack.setSession(sb.toString());
					}
				} catch (Exception e) {
					System.out.println("出错了");
					e.printStackTrace();
				}
			};
		}.start();

	}
}
