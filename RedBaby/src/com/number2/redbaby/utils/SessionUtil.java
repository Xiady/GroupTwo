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

	//�ӿڻص��ķ���
		public interface SessionJsoncallBack{
			void setSessionJson(String json);
		} 
	// �õ�session/cookieֵ������
	public void getSession(final String ur,final SessionJsoncallBack callBack) {
		new Thread() {
			public void run() {
				try {
					URL url = new URL(path+ur);
					HttpURLConnection con = (HttpURLConnection) url
							.openConnection();
					if (con.getResponseCode() == 200) {
						// �õ�cookieVal
						String cookie = con.getHeaderField("set-cookie");
						// System.out.println("cookieval--->"+cookie);
						// �õ�sessionid
						String sessionid = cookie.substring(0,
								cookie.indexOf(";"));
						// System.out.println("cookie---->" + sessionid);
						// ��cookieֵ���б���
						MyApplication.setSessionid(sessionid);
						
						Log.e("TAG","����ɹ�"+sessionid);
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

	//�ӿڻص��ķ���
	public interface SessioncallBack{
		void setSession(String json);
	}
	// �õ�session/cookieֵ
	public void netWork(final String ur ,final SessioncallBack callBack) {
		new Thread() {
			public void run() {
				try {
					URL url = new URL(path+ur);
					HttpURLConnection connection = (HttpURLConnection) url
							.openConnection();
					// �õ��洢��cookieֵ
					String cookie = MyApplication.getSessionid();
					System.out.println(cookie);
					// ��cookieֵ
					// ����cookie������web�������ڽ��������ʱ��ͻ��Զ�������Ӧ��cookie�ˣ��Ӷ���֤����ͬһ�ỰSession
					connection.setRequestProperty("cookie", cookie);
					if (connection.getResponseCode() == 200) {
						System.out.println("���� ");
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
					System.out.println("������");
					e.printStackTrace();
				}
			};
		}.start();

	}
}
