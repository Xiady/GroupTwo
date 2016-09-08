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
import com.number2.redbaby.adapter.MyTuiJian1Adapter;
import com.number2.redbaby.adapter.MyTuiJian2Adapter;
import com.number2.redbaby.bean.BabyBean;
import com.number2.redbaby.bean.BabyBean.Brand;

public class Shouye_tuijian extends Fragment {
	private String tuijian_url = "http://121.42.8.95:8090/ECServer_D/brand";
	private View v;
	private GridView tuijian_gv_mother;
	private GridView tuijian_gv_shipin;
	private List<Brand> brandList;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		v = View.inflate(getActivity(), R.layout.shouye_tuijian, null);

		tuijian_gv_mother = (GridView) v.findViewById(R.id.tuijian_gv_mother);
		tuijian_gv_shipin = (GridView) v.findViewById(R.id.tuijian_gv_shipin);
		// 点击跳转详情
		tuijian_gv_mother.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// 跳转到详情页面
				Intent intent = new Intent(getActivity(), DetailActivity.class);
				int id = brandList.get(0).value.get(arg2).id;

				Log.i("Tag", "跳转前商品ID===========" + id);

				intent.putExtra("id", id);
				startActivity(intent);
			}
		});
		// 点击跳转详情
		tuijian_gv_shipin.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// 跳转到详情页面
				Intent intent = new Intent(getActivity(), DetailActivity.class);
				int id = brandList.get(1).value.get(arg2).id;

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
		StringRequest request = new StringRequest(Request.Method.GET, tuijian_url, new Response.Listener<String>() {

			@Override
			public void onResponse(String response) {
				Log.i("TAG", "===========shouye_tuijian+++" + response);

				Gson gson = new Gson();
				BabyBean xianShiBean = gson.fromJson(response.toString(), BabyBean.class);
				brandList = xianShiBean.brand;

				tuijian_gv_mother.setAdapter(new MyTuiJian1Adapter(getActivity(), brandList));
				tuijian_gv_shipin.setAdapter(new MyTuiJian2Adapter(getActivity(), brandList));
			}

		}, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {

			}
		});
		requestQueue.add(request);
	}

}
