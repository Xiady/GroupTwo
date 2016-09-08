package com.number2.redbaby.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.number2.redbaby.R;
import com.number2.redbaby.SearchItemActivity;
import com.number2.redbaby.ShouListActivity;
import com.number2.redbaby.adapter.MyLunBoAdapter;
import com.number2.redbaby.adapter.MyShouLvAdapter;
import com.number2.redbaby.bean.LunBoBean;
import com.number2.redbaby.bean.LunBoBean.Home;

import java.util.ArrayList;
import java.util.List;

public class Fragment_shou extends Fragment {
	private String[] textview = { "限时抢购", "促销快报", "新品上架", "热门单品", "推荐品牌", };
	private int[] img = { R.drawable.home_classify_01,
			R.drawable.home_classify_02, R.drawable.home_classify_03,
			R.drawable.home_classify_04, R.drawable.home_classify_05 };

	private String shouye_lunbo = "http://121.42.8.95:8090/ECServer_D/home";
	//孟祥泉是大傻逼。
	private List<Home> hList;

	private View view;
	private LinearLayout shouye_round;
	public RelativeLayout shouye_ll;

	private ViewPager shouye_vp;// 轮播图
	private ListView shouye_lv;// ListView模块
	private Fragment_shou shou;
	private Fragment_cart cart;
	private Fragment_more more;
	private Fragment_pai pai;
	private Fragment_search search;
	List<ImageView> listIv = new ArrayList<ImageView>();

	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 0:
				shouye_vp.setAdapter(new MyLunBoAdapter(getActivity(), hList));
				// 小圆点
				xiaoyuandian();
				shouye_vp.setCurrentItem(1000000);
				// 滑动ViewPager
				vpchange();
				sendmessage();
				break;

			case 1:
				sendmessage();
				break;
			}
		};
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = View.inflate(getActivity(), R.layout.fregment_shou, null);
		// 获得控件
		initData();

		// 请求轮播图图片
		initVolley();
		// ListView模块
		initListView();
		return view;
	}

	private void initListView() {
		shouye_lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent = new Intent(getActivity(),
						ShouListActivity.class);
				intent.putExtra("lname", textview[arg2]);
				startActivity(intent);
			}
		});
	}

	protected void xiaoyuandian() {
		if (listIv == null) {
			listIv.clear();
		}
		for (int i = 0; i < hList.size(); i++) {
			ImageView iv = new ImageView(getActivity());
			if (i == 0) {
				iv.setImageResource(R.drawable.shixin);
			} else {
				iv.setImageResource(R.drawable.kongxin);
			}
			LayoutParams params = new LayoutParams(10, 10);
			params.setMargins(10, 0, 10, 0);

			listIv.add(iv);
			shouye_round.addView(iv, params);
		}
	}

	protected void vpchange() {
		shouye_vp.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				for (int i = 0; i < hList.size(); i++) {
					if (i == arg0 % hList.size()) {
						listIv.get(i).setImageResource(R.drawable.shixin);
					} else {
						listIv.get(i).setImageResource(R.drawable.kongxin);
					}
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
	}

	protected void sendmessage() {
		int currentItem = shouye_vp.getCurrentItem();
		currentItem++;
		shouye_vp.setCurrentItem(currentItem);

		handler.sendEmptyMessageDelayed(1, 2000);
	}

	private void initVolley() {
		RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
		StringRequest request = new StringRequest(Request.Method.GET,
				shouye_lunbo, new Response.Listener<String>() {

					@Override
					public void onResponse(String response) {
						Log.i("TAG", "===========response+++" + response);
						Gson gson = new Gson();
						LunBoBean boBean = gson.fromJson(response.toString(),
								LunBoBean.class);
						hList = boBean.home_banner;

						handler.sendEmptyMessage(0);

					}

				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {

					}
				});
		requestQueue.add(request);
	}

	private void initData() {
		shouye_vp = (ViewPager) view.findViewById(R.id.shouye_vp);
		shouye_lv = (ListView) view.findViewById(R.id.shouye_lv);
		shouye_round = (LinearLayout) view.findViewById(R.id.shouye_round);
		shouye_ll = (RelativeLayout) view.findViewById(R.id.shouye_ll);

		// 给ListView赋上图标和文字
		shouye_lv.setAdapter(new MyShouLvAdapter(getActivity(), textview, img));

		shouye_ll.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 跳转到展示界面
				Intent intent = new Intent(getActivity(),
						SearchItemActivity.class);
				intent.putExtra("goods", "...");

				startActivity(intent);
			}
		});
	}
}
