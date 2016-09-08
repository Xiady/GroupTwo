package com.number2.redbaby.fragment;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.number2.redbaby.Pai_TwoActivity;
import com.number2.redbaby.ProductlistActivity;
import com.number2.redbaby.R;
import com.number2.redbaby.adapter.PaiAdapter;
import com.number2.redbaby.bean.Pai_Category;
import com.number2.redbaby.bean.Pai_FirstCate;
import com.number2.redbaby.utils.HttpUtilmxq.VolleyCallBack;
import com.number2.redbaby.utils.HttpUtilmxq;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/**
 * 
 * @author mxq
 * @date 2016/09/02
 */
public class Fragment_pai extends Fragment {

	private View view;
	private ListView pai_lv;
	private String pai_versionCode = "1.0";
	private List<Pai_Category> category;
	private List<Pai_Category> newCategory = new ArrayList<Pai_Category>();
	private HttpUtilmxq util;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = View.inflate(getActivity(), R.layout.fragment_pai, null);
		// 找控件
		initView();

		// 设置监听的方法
		setListener();
		return view;
	}

	@Override
	public void onStart() {
		super.onStart();
		newCategory.clear();
		// 请求数据的方法
		initData();
	}

	/*
	 * 设置监听的方法
	 */
	private void setListener() {
		pai_lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				if (newCategory.get(arg2).isleafnode == false) {
					// 跳转
					// Log.e("tag","false"+newCategory.get(arg2).name);
					Intent intent = new Intent(getActivity(),
							Pai_TwoActivity.class);
					intent.putExtra("title_Name", newCategory.get(arg2).name);
					intent.putExtra("oneID", newCategory.get(arg2).id);
					startActivity(intent);
				} else {
					Intent intent = new Intent(getActivity(),
							ProductlistActivity.class);
					intent.putExtra("oneID", newCategory.get(arg2).id);
					startActivity(intent);
				}
			}
		});

	}

	/*
	 * 请求数据的方法
	 */
	private void initData() {
		util = new HttpUtilmxq(getActivity());
		util.Get("category?version=" + pai_versionCode, new VolleyCallBack() {

			@Override
			public void setDataFromVolley(String json) {
				Gson g = new Gson();
				Pai_FirstCate cate = g.fromJson(json, Pai_FirstCate.class);
				category = cate.category;

				for (Pai_Category pai_cate : category) {
					if (pai_cate.parent_id.equals("0")) {
						newCategory.add(pai_cate);
					}
				}
				pai_lv.setAdapter(new PaiAdapter(getActivity(), newCategory));
				// newCategory.clear();
			}
		});
	}

	/*
	 * 找控件的方法
	 */
	private void initView() {
		// listView
		pai_lv = (ListView) view.findViewById(R.id.pai_lv);
	}
}
