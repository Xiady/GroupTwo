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
 * @author HP 请求数据的服务类
 */
public class ServiceUtils {

	// 接口回调需要在服务类中注册即定义一个接口供客户类调用
	public interface RequestListener {
		// 抽想方法--默认是public、static修饰的
		void callBack(String json);
	}

	// 客户端通过请求方法，将接口的实现类放在方法中的参数传递过来
	public void get(Context context, String path, final RequestListener callback) {
		//
		RequestQueue requestQueue = Volley.newRequestQueue(context);

		StringRequest request = new StringRequest(Request.Method.POST,
				URLUtils.URL_LOGIN_PATH, new Response.Listener<String>() {
					/**
					 * 请求成功
					 */
					@Override
					public void onResponse(String response) {
						// 在请求数据成功之后，通过接口的实现类传递参数
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
