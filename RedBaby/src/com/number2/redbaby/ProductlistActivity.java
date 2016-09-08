package com.number2.redbaby;

import java.util.List;
import com.google.gson.Gson;
import com.number2.redbaby.adapter.ProdLvAdapter;
import com.number2.redbaby.bean.ProdInfo;
import com.number2.redbaby.bean.Productlist;
import com.number2.redbaby.utils.HttpUtilmxq;
import com.number2.redbaby.utils.HttpUtilmxq.VolleyCallBack;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

/**
 * 
 * @author mxq
 * @date 2016/09/03
 */
public class ProductlistActivity extends Activity implements OnClickListener {

	private Button prod_btn_num;
	private Button prod_btn_price;
	private Button prod_btn_haoping;
	private Button prod_btn_time;
	private TextView back;
	private TextView prod_shaixuan;
	private ListView prod_lv;
	private String oneID;
	private List<ProdInfo> productlist;
	private String orderby = "sale_down";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_prod);

		// 得到Intent的值
		getIntentData();
		// 找控件
		initView();
		// 请求网络的方法
		initData(orderby);

		// 设置监听的方法
		setListener();
	}

	/*
	 * 设置监听的方法
	 */
	private void setListener() {
		prod_btn_num.setOnClickListener(this);
		prod_btn_price.setOnClickListener(this);
		prod_btn_haoping.setOnClickListener(this);
		prod_btn_time.setOnClickListener(this);
		back.setOnClickListener(this);
		prod_shaixuan.setOnClickListener(this);

		prod_lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// Log.e("Tag", "1");
				Intent intent = new Intent(ProductlistActivity.this,
						DetailActivity.class);
				Log.e("Tag", productlist.get(arg2).id);
				intent.putExtra("id", productlist.get(arg2).id);
				startActivity(intent);
			}
		});
	}

	/*
	 * 得到Intent的值
	 */
	private void getIntentData() {
		Intent intent = getIntent();
		oneID = intent.getStringExtra("oneID");
	}

	/*
	 * 找控件的方法
	 */
	private void initView() {
		prod_btn_num = (Button) findViewById(R.id.prod_btn_num);
		prod_btn_price = (Button) findViewById(R.id.prod_btn_price);
		prod_btn_haoping = (Button) findViewById(R.id.prod_btn_haoping);
		prod_btn_time = (Button) findViewById(R.id.prod_btn_time);

		// 返回按钮
		back = (TextView) findViewById(R.id.pai_back);
		// 筛选按钮
		prod_shaixuan = (TextView) findViewById(R.id.prod_shaixuan);
		prod_lv = (ListView) findViewById(R.id.prod_lv);
	}

	/*
	 * 请求数据的方法
	 */
	private void initData(String orderby) {
		HttpUtilmxq util = new HttpUtilmxq(this);
		util.Get("productlist?page=1&pageNum=10&cId" + oneID,
				new VolleyCallBack() {

					@Override
					public void setDataFromVolley(String json) {
						Gson g = new Gson();
						Productlist prod = g.fromJson(json, Productlist.class);
						productlist = prod.productlist;
						prod_lv.setAdapter(new ProdLvAdapter(
								ProductlistActivity.this, productlist));
					}
				});
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.prod_btn_num:
			prod_btn_num
					.setBackgroundResource(R.drawable.segment_selected_1_bg);
			prod_btn_price
					.setBackgroundResource(R.drawable.segment_normal_1_bg);
			prod_btn_haoping
					.setBackgroundResource(R.drawable.segment_normal_1_bg);
			prod_btn_time.setBackgroundResource(R.drawable.segment_normal_1_bg);
			initData("sale_down");
			break;
		case R.id.prod_btn_price:
			prod_btn_price
					.setBackgroundResource(R.drawable.segment_selected_2_bg);
			prod_btn_num.setBackgroundResource(R.drawable.segment_normal_2_bg);
			prod_btn_haoping
					.setBackgroundResource(R.drawable.segment_normal_2_bg);
			prod_btn_time.setBackgroundResource(R.drawable.segment_normal_2_bg);
			initData("price_up");
			break;
		case R.id.prod_btn_haoping:
			prod_btn_haoping
					.setBackgroundResource(R.drawable.segment_selected_2_bg);
			prod_btn_price
					.setBackgroundResource(R.drawable.segment_normal_2_bg);
			prod_btn_num.setBackgroundResource(R.drawable.segment_normal_2_bg);
			prod_btn_time.setBackgroundResource(R.drawable.segment_normal_2_bg);
			initData("comment_down");
			break;
		case R.id.prod_btn_time:
			prod_btn_time
					.setBackgroundResource(R.drawable.segment_selected_3_bg);
			prod_btn_price
					.setBackgroundResource(R.drawable.segment_normal_3_bg);
			prod_btn_haoping
					.setBackgroundResource(R.drawable.segment_normal_3_bg);
			prod_btn_num.setBackgroundResource(R.drawable.segment_normal_3_bg);
			initData("shelves_down");
			break;

		case R.id.pai_back:
			finish();
			break;

		case R.id.prod_shaixuan:
			Intent intent = new Intent();
			intent.putExtra("oneID", oneID);
			startActivity(intent);
			break;
		}
	}

}
