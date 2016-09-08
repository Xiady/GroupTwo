package com.number2.redbaby.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.format.DateUtils;
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
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshBase.State;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.extras.SoundPullEventListener;
import com.number2.redbaby.DetailActivity;
import com.number2.redbaby.R;
import com.number2.redbaby.adapter.MyReMenAdapter;
import com.number2.redbaby.bean.BabyBean;
import com.number2.redbaby.bean.BabyBean.Productlist;

public class Shouye_remen extends Fragment {

	private String remenUrl = "http://121.42.8.95:8090/ECServer_D/hotproduct";
	private View v;
	private PullToRefreshListView refreshListView;
	private MyReMenAdapter adapter;
	private List<Productlist> productlist;
	List<Productlist> pulllist = new ArrayList<Productlist>();

	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {

			msg.obj = productlist;

			if (msg.arg1 == 1) {
				pulllist.clear();
				pulllist.addAll(0, productlist);

				Log.i("TAG", "刷新的数据" + pulllist.toString());

				refreshListView.onRefreshComplete();

			} else {
				pulllist.addAll(productlist);

				Log.i("TAG", "加载的数据" + pulllist.toString());

				refreshListView.onRefreshComplete();
			}

			if (adapter == null) {
				adapter = new MyReMenAdapter(getActivity(), pulllist);
				refreshListView.setAdapter(adapter);
			} else {
				adapter.notifyDataSetChanged();

			}

		};
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		v = View.inflate(getActivity(), R.layout.shouye_remen, null);

		refreshListView = (PullToRefreshListView) v.findViewById(R.id.shouye_remne_lv);
		initEvent(1);
		handler.postDelayed(new Runnable() {

			@Override
			public void run() {
				// 一进来就自动刷新
				refreshListView.setRefreshing(true);
			}
		}, 3000);

		// 设置刷新和加载
		initList();

		return v;
	}

	private void initList() {
		// 点击跳转详情
		refreshListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// 跳转到详情页面
				Intent intent = new Intent(getActivity(), DetailActivity.class);
				int id = pulllist.get(arg2).id;

				Log.i("Tag", "跳转前商品ID===========" + id);

				intent.putExtra("id", id);
				startActivity(intent);
			}
		});

		refreshListView.setOnRefreshListener(new OnRefreshListener2<ListView>() {

			// 刷新
			@Override
			public void onPullDownToRefresh(final PullToRefreshBase<ListView> refreshView) {

				handler.postDelayed(new Runnable() {

					@Override
					public void run() {
						String label = DateUtils.formatDateTime(getActivity().getApplicationContext(), System.currentTimeMillis(),
								DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);

						// 设置下拉时显示的时间
						refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);
						initEvent(1);
					}
				}, 3000);

			}

			// 加载
			@Override
			public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
				handler.postDelayed(new Runnable() {

					@Override
					public void run() {
						initEvent(2);

					}
				}, 3000);
			}
		});
		// 可以刷新加载
		refreshListView.setMode(Mode.BOTH);
		// 加载的文字
		refreshListView.getLoadingLayoutProxy(false, true).setPullLabel("上拉加载...");
		refreshListView.getLoadingLayoutProxy(false, true).setRefreshingLabel("加载中...");
		refreshListView.getLoadingLayoutProxy(false, true).setReleaseLabel("放开以加载...");

		SoundPullEventListener<ListView> sounListener = new SoundPullEventListener<ListView>(getActivity());
		// 下拉刷新时
		sounListener.addSoundEvent(State.PULL_TO_REFRESH, R.raw.pull_event);
		// 拉到最后时
		sounListener.addSoundEvent(State.RESET, R.raw.reset_sound);
		// 刷新中
		sounListener.addSoundEvent(State.REFRESHING, R.raw.refreshing_sound);

		refreshListView.setOnPullEventListener(sounListener);
	}

	private void initEvent(final int i) {
		RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
		StringRequest request = new StringRequest(Request.Method.GET, remenUrl, new Response.Listener<String>() {

			@Override
			public void onResponse(String response) {
				Log.i("TAG", "===========shouye_remen+++" + response);

				Gson gson = new Gson();
				BabyBean bean = gson.fromJson(response.toString(), BabyBean.class);
				productlist = bean.productlist;

				Message msg = new Message();
				msg.obj = productlist;
				msg.arg1 = i;
				handler.sendMessage(msg);

			}

		}, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {

			}
		});
		requestQueue.add(request);
	}
}
