package com.number2.redbaby.fragment;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.number2.redbaby.DetailActivity;
import com.number2.redbaby.R;
import com.number2.redbaby.adapter.MyXinPinAdapter;
import com.number2.redbaby.bean.BabyBean;
import com.number2.redbaby.bean.BabyBean.Productlist;

public class Shouye_xinpin extends Fragment {

	private String xinpinUrl = "http://121.42.8.95:8090/ECServer_D/newproduct";
	private View v;
	private GridView xinpin_gv;
	private List<Productlist> productlist;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		v = View.inflate(getActivity(), R.layout.shouye_xinpin, null);

		xinpin_gv = (GridView) v.findViewById(R.id.shouye_xinpin_gv);
		// 点击跳转详情
		xinpin_gv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// 跳转到详情页面
				Intent intent = new Intent(getActivity(), DetailActivity.class);
				int id = productlist.get(arg2).id;

				Log.i("Tag", "跳转前商品ID===========" + id);

				intent.putExtra("id", id);
				startActivity(intent);
			}
		});
		initEvent();
		return v;
	}

	private void initEvent() {
		RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
		StringRequest request = new StringRequest(Request.Method.GET, xinpinUrl, new Response.Listener<String>() {

			@Override
			public void onResponse(String response) {
				Log.i("TAG", "===========shouye_xinpin+++" + response);

				Gson gson = new Gson();
				BabyBean bean = gson.fromJson(response.toString(), BabyBean.class);
				productlist = bean.productlist;

				MyXinPinAdapter adapter = new MyXinPinAdapter(getActivity(), productlist);
				xinpin_gv.setAdapter(adapter);
			}

		}, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {

			}
		});
		requestQueue.add(request);
	}
}
