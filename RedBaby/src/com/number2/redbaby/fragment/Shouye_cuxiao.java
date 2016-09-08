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
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.number2.redbaby.DetailActivity;
import com.number2.redbaby.R;
import com.number2.redbaby.adapter.MyCuXiaoiAdapter;
import com.number2.redbaby.bean.BabyBean;
import com.number2.redbaby.bean.BabyBean.Topic;

public class Shouye_cuxiao extends Fragment {
	private String cuxiao_url = "http://121.42.8.95:8090/ECServer_D/topic";

	private View v;
	private ListView shouye_cuxiao_lv;
	private List<Topic> topiclist;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		v = View.inflate(getActivity(), R.layout.shouye_cuxiao, null);

		shouye_cuxiao_lv = (ListView) v.findViewById(R.id.shouye_cuxiao_lv);
		// 点击跳转详情
		shouye_cuxiao_lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// 跳转到详情页面
				Intent intent = new Intent(getActivity(), DetailActivity.class);
				int id = topiclist.get(arg2).id;

				Log.i("Tag", "跳转前商品ID===========" + id);

				intent.putExtra("id", id);
				startActivity(intent);
			}
		});
		// 请求数据
		initEvent();
		return v;
	}

	private void initEvent() {
		RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
		StringRequest request = new StringRequest(Request.Method.GET, cuxiao_url, new Response.Listener<String>() {

			@Override
			public void onResponse(String response) {
				Log.i("TAG", "===========shouye_xianshi+++" + response);

				Gson gson = new Gson();
				BabyBean xianShiBean = gson.fromJson(response.toString(), BabyBean.class);
				topiclist = xianShiBean.topic;

				shouye_cuxiao_lv.setAdapter(new MyCuXiaoiAdapter(getActivity(), topiclist));
			}

		}, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {

			}
		});
		requestQueue.add(request);
	}
}
