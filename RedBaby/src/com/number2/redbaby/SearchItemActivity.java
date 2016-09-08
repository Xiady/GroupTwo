package com.number2.redbaby;

import java.io.IOException;
import java.util.List;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.number2.redbaby.adapter.MySearchAdapter;
import com.number2.redbaby.bean.Productlist1;
import com.number2.redbaby.bean.SearchBean;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class SearchItemActivity extends FragmentActivity implements
		OnClickListener {

	private Handler handler = new Handler() {

		public void handleMessage(android.os.Message msg) {
			// ����������
			adapter = new MySearchAdapter(SearchItemActivity.this,
					list_productlist);
			search_lv.setAdapter(adapter);
		};

	};

	private String keyword;
	private TextView search_num;
	private TextView search_back;
	private Button search_sales;
	private Button search_price;
	private Button search_praise;
	private Button search_time;
	private ListView search_lv;
	private List<Productlist1> list_productlist;
	private MySearchAdapter adapter;
	private int list_count;

	String path = "http://121.42.8.95:8090/ECServer_D/search";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_item);
		// ������ת������ֵ
		Intent intent = getIntent();
		keyword = intent.getStringExtra("goods");
		// �ҿؼ�
		initView();
		// �����������ݷ���
		initDatas();

		// ����Ĭ��ҳ��
		search_sales.setBackgroundResource(R.drawable.segment_selected_1_bg);
		search_price.setBackgroundResource(R.drawable.segment_normal_1_bg);
		search_praise.setBackgroundResource(R.drawable.segment_normal_1_bg);
		search_time.setBackgroundResource(R.drawable.segment_normal_1_bg);

		// ��ť����¼�
		search_sales.setOnClickListener(this);
		search_price.setOnClickListener(this);
		search_praise.setOnClickListener(this);
		search_time.setOnClickListener(this);
		search_back.setOnClickListener(this);

	}

	/**
	 * �ҿؼ��ŷ�
	 */
	private void initView() {
		search_num = (TextView) findViewById(R.id.search_num);
		search_back = (TextView) findViewById(R.id.search_back);
		search_sales = (Button) findViewById(R.id.search_sales);
		search_price = (Button) findViewById(R.id.search_price);
		search_praise = (Button) findViewById(R.id.search_praise);
		search_time = (Button) findViewById(R.id.search_time);
		search_lv = (ListView) findViewById(R.id.search_lv);
		// ��Ŀ����¼�
		search_lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// ��ת������ҳ��
				Intent intent = new Intent(SearchItemActivity.this,
						DetailActivity.class);
				int id = list_productlist.get(arg2).id;

				Log.i("Tag", "��תǰ��ƷID===========" + id);

				intent.putExtra("id", id);
				startActivity(intent);

			}

		});

	}

	/**
	 * �����������ݷ���
	 */
	private void initDatas() {
		OkHttpClient client = new OkHttpClient();
		

		Request request = new Request.Builder().url(path).build();

		// �������ݲ�����
		client.newCall(request).enqueue(new Callback() {

		

			@Override
			public void onFailure(Request arg0, IOException arg1) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onResponse(Response arg0) throws IOException {
				// ���󵽵�Json
				String result = arg0.body().string();

				// ����
				Gson gson = new Gson();
				SearchBean searchBean = gson.fromJson(result, SearchBean.class);
				list_count = searchBean.list_count;
				list_productlist = searchBean.productlist;

				// ͨ��handler����
				handler.sendEmptyMessage(0);
			}
		});

	}

	// ����¼�
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.search_sales:
			adapter.notifyDataSetChanged();
			search_sales
					.setBackgroundResource(R.drawable.segment_selected_1_bg);
			search_price.setBackgroundResource(R.drawable.segment_normal_1_bg);
			search_praise.setBackgroundResource(R.drawable.segment_normal_1_bg);
			search_time.setBackgroundResource(R.drawable.segment_normal_1_bg);
			break;
		case R.id.search_price:
			adapter.notifyDataSetChanged();
			search_price
					.setBackgroundResource(R.drawable.segment_selected_1_bg);
			search_sales.setBackgroundResource(R.drawable.segment_normal_1_bg);
			search_praise.setBackgroundResource(R.drawable.segment_normal_1_bg);
			search_time.setBackgroundResource(R.drawable.segment_normal_1_bg);
			break;

		case R.id.search_praise:
			adapter.notifyDataSetChanged();
			search_praise
					.setBackgroundResource(R.drawable.segment_selected_1_bg);
			search_price.setBackgroundResource(R.drawable.segment_normal_1_bg);
			search_sales.setBackgroundResource(R.drawable.segment_normal_1_bg);
			search_time.setBackgroundResource(R.drawable.segment_normal_1_bg);
			break;
		case R.id.search_time:
			adapter.notifyDataSetChanged();
			search_time.setBackgroundResource(R.drawable.segment_selected_1_bg);
			search_sales.setBackgroundResource(R.drawable.segment_normal_1_bg);
			search_praise.setBackgroundResource(R.drawable.segment_normal_1_bg);
			search_price.setBackgroundResource(R.drawable.segment_normal_1_bg);
			break;

		case R.id.search_back:
			finish();
			break;

		}

	}

}
