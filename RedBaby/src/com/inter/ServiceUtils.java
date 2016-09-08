package com.inter;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.number2.redbaby.utils.URLUtils;

/**
 * @author HP �������ݵķ�����
 */
public class ServiceUtils {

	// �ӿڻص���Ҫ�ڷ�������ע�ἴ����һ���ӿڹ��ͻ������
	public interface RequestListener {
		// ���뷽��--Ĭ����public��static���ε�
		void callBack(String json);
	}

	// �ͻ���ͨ�����󷽷������ӿڵ�ʵ������ڷ����еĲ������ݹ���
	public void get(Context context, String path, final RequestListener callback) {
		//
		RequestQueue requestQueue = Volley.newRequestQueue(context);

		StringRequest request = new StringRequest(Request.Method.POST,
				URLUtils.URL_LOGIN_PATH, new Response.Listener<String>() {
					/**
					 * ����ɹ�
					 */
					@Override
					public void onResponse(String response) {
						// ���������ݳɹ�֮��ͨ���ӿڵ�ʵ���ഫ�ݲ���
						callback.callBack(response);

					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {

					}
				});
		requestQueue.add(request);
	}
}
