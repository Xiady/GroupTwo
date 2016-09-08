package com.number2.redbaby.utils;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.number2.redbaby.AddAddressActivity;

public class HttpUtil {

	/**
	 * 定义一接口，供回调
	 * 
	 * @author HP
	 * 
	 */
	public interface RequestListener {
		void CallBack(String json);
	}

	/**
	 * 请求数据的方法(登录、注册)
	 */
	public void GetHttpData(final String name, final String pwd,
			Context context, String path, final RequestListener requestListener) {

		RequestQueue requestQueue = Volley.newRequestQueue(context);

		StringRequest request = new StringRequest(Request.Method.POST, path,
				new Response.Listener<String>() {
					/**
					 * 请求成功
					 */
					@Override
					public void onResponse(String response) {
						requestListener.CallBack(response);
					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {

					}
				}) {

			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				HashMap<String, String> map = setMap();
				return map;
			}

			private HashMap<String, String> setMap() {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("username", name);
				map.put("password", pwd);
				return map;
			}

		};

		requestQueue.add(request);
	}

	public void GetHttpAddresssave(final int id,final String name, final String phonenumber,
			final String fixedtel, final String areaid,
			final String areadetail, final String zipcode, Context context,
			String path, final RequestListener requestListener) {

		RequestQueue requestQueue = Volley.newRequestQueue(context);

		StringRequest request = new StringRequest(Request.Method.POST, path,
				new Response.Listener<String>() {
					/**
					 * 请求成功
					 */
					@Override
					public void onResponse(String response) {
						requestListener.CallBack(response);
					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {

					}
				}) {

			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				HashMap<String, String> map = setMap();
				return map;
			}

			private HashMap<String, String> setMap() {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("id", id+"");
				map.put("name", name);
				map.put("phonenumber", phonenumber);
				map.put("fixedtel", fixedtel);
				map.put("areaid", areaid);
				map.put("areadetail", areadetail);
				map.put("zipcode", zipcode);
				return map;
			}

		};

		requestQueue.add(request);
	}
}
