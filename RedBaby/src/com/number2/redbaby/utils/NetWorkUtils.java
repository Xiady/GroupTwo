package com.number2.redbaby.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.util.Log;

import com.number2.redbaby.bean.LoginReponse;
import com.number2.redbaby.bean.LoginReponse.UserInfo;

public class NetWorkUtils {
	/**
	 * post�����¼ע������
	 * 
	 * @param name
	 * @param passWord
	 * @return
	 */
	public static String getStrPost(String path, String name, String pwd) {
		try {
			HttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost(URLUtils.URL_LOGIN_PATH);
			// ����ҪЯ���Ĳ���
			List<NameValuePair> parameters = new ArrayList<NameValuePair>();
			parameters.add(new BasicNameValuePair("userName", name));
			parameters.add(new BasicNameValuePair("passWord", pwd));
			// ����UrlEncodedFormEntity��ʵ��
			HttpEntity entity = new UrlEncodedFormEntity(parameters);
			// post������
			post.setEntity(entity);
			HttpResponse response = client.execute(post);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				Log.i("TAG", EntityUtils.toString(response.getEntity()));
				return EntityUtils.toString(response.getEntity());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
