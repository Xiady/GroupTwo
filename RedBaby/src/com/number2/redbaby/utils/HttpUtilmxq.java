package com.number2.redbaby.utils;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class HttpUtilmxq {
	private String url = "http://121.42.8.95:8090/ECServer_D/";
	private Context context;
	private String json = "";
	private VolleyCallBack callBack;

	public interface VolleyCallBack {
		void setDataFromVolley(String json);
	}

	public HttpUtilmxq(Context context) {
		super();
		this.context = context;
	}

	public void Get(String path, final VolleyCallBack callBack1) {
		RequestQueue requestQueue = Volley.newRequestQueue(context);

		Request request = new StringRequest(url + path, new Listener<String>() {
			@Override
			public void onResponse(String response) {
				// TODO Auto-generated method stub
				System.out.println(response);
				json = response;
				callBack1.setDataFromVolley(json);
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {

			}
		});
		requestQueue.add(request);
	}
}
