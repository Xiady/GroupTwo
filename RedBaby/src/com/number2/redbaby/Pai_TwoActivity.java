package com.number2.redbaby;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.number2.redbaby.adapter.PaiAdapter;
import com.number2.redbaby.adapter.PaiTwoAdapter;
import com.number2.redbaby.bean.Pai_Category;
import com.number2.redbaby.bean.Pai_FirstCate;
import com.number2.redbaby.utils.HttpUtilmxq;
import com.number2.redbaby.utils.HttpUtilmxq.VolleyCallBack;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * 
 * @author mxq
 * @Date 2016/09/02
 */
public class Pai_TwoActivity extends Activity {

	private TextView pai_title_tv;
	private String title_name;
	private String oneID;
	private ListView pai_lv;
	private TextView pai_back;
	private List<Pai_Category> category;
	private String pai_versionCode = "2";
	private List<Pai_Category> newCategory = new ArrayList<Pai_Category>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pai__two);

		// 得到Intent的值
		getIntentData();
		// 找控件
		initView();
		// 请求数据的方法
		initData();
		// 设置监听的方法
		setListener();
	}

	/*
	 * //得到Intent的值
	 */
	private void getIntentData() {
		Intent intent = getIntent();
		title_name = intent.getStringExtra("title_Name");
		oneID = intent.getStringExtra("oneID");
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
					Intent intent = new Intent(Pai_TwoActivity.this,
							Pai_ThreeActivity.class);
					intent.putExtra("title_Name", newCategory.get(arg2).name);
					intent.putExtra("oneID", newCategory.get(arg2).id);
					startActivity(intent);

				} else {
					Intent intent = new Intent(Pai_TwoActivity.this,
							ProductlistActivity.class);
					intent.putExtra("oneID", newCategory.get(arg2).id);
					startActivity(intent);
				}
			}
		});

		pai_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}

	/*
	 * 找控件的方法
	 */
	private void initView() {
		// 标题的名字
		pai_title_tv = (TextView) findViewById(R.id.pai_title_tv);
		pai_title_tv.setText(title_name);
		// listView
		pai_lv = (ListView) findViewById(R.id.pai_lv);
		// 返回按钮
		pai_back = (TextView) findViewById(R.id.pai_back);
	}

	/*
	 * 请求数据的方法
	 */
	private void initData() {
		HttpUtilmxq util = new HttpUtilmxq(this);
		util.Get("category?version=" + pai_versionCode, new VolleyCallBack() {

			@Override
			public void setDataFromVolley(String json) {
				Gson g = new Gson();
				Pai_FirstCate cate = g.fromJson(json, Pai_FirstCate.class);
				category = cate.category;

				for (Pai_Category pai_cate : category) {
					if (pai_cate.parent_id.equals(oneID)) {
						newCategory.add(pai_cate);
					}
				}
				pai_lv.setAdapter(new PaiTwoAdapter(Pai_TwoActivity.this,
						newCategory));
			}
		});
	}

}
