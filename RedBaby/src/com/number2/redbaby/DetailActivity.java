package com.number2.redbaby;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.number2.redbaby.adapter.MyDetailPagerAdapter;
import com.number2.redbaby.bean.DetailBean;
import com.number2.redbaby.bean.Product;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends Activity implements OnClickListener {

	private Handler handler = new Handler() {
		

		public void handleMessage(android.os.Message msg) {
			// 得到解析后的数据
			Product product = (Product) msg.obj;
			available = product.available;
			bigPics = product.bigPic;
			buyLimit = product.buyLimit;
			comment_count = product.comment_count;
			inventory_area = product.inventory_area;
			marketprice = product.marketprice;
			name = product.name;
			pics = product.pic;
			price = product.price;
			score = product.score;
			product_prom=product.product_prom;
			
			//促销信息
			prom1 = product_prom[0];
			prom2 = product_prom[1];
			//配置ViewPager适配器
			detail_vp.setAdapter(new MyDetailPagerAdapter(DetailActivity.this,pics,bigPics));
			
			
			
			// 为空间赋值
			detail_goodname.setText(name);
			detail_marketPrice.setText("¥"+marketprice + ".00");
			//为控件加中划线
			detail_marketPrice.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG);
			detail_score.setText(score + "");
			detail_price.setText("¥"+price + ".00");
			detail_comment_count.setText("共有" + comment_count + "人评论");
			detail_product_prom.setText(prom1+"\n"+prom2);
		};
	};

	private TextView detail_callBack;
	private TextView detail_addCar;
	private ViewPager detail_vp;
	private TextView detail_goodname;
	private TextView detail_marketPrice;
	private TextView detail_score;
	private TextView detail_price;
	private EditText detail_goodnum;
	private Button detail_add;
	private Button detail_shoucang;
	private TextView detail_available;
	private TextView detail_comment_count;
	private TextView detail_product_prom;
	private String id;
	private String available;
	private String[] bigPics;
	private String[] product_prom;
	private int buyLimit;
	private int comment_count;
	private String inventory_area;
	private String marketprice;
	private String name;
	private String[] pics;
	private int price;
	private String score;
	private String prom1;
	private String prom2;
	List<ImageView> listIv = new ArrayList<ImageView>();

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		// 得到跳转传的值
		Intent intent = getIntent();
		int intExtra = intent.getIntExtra("id", 1);
		// 商品ID
		id = intExtra + "";

		Log.i("Tag", "跳转后商品ID" + id);

		// 找控件
		initView();
		// 请求网络数据
		initData();
		
		
		//ViewPager点击事件
		detail_vp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DetailActivity.this, DetailBigActivity.class);
				intent.putExtra("bigPic1", bigPics);
				
				startActivity(intent);
				
			}
		});

	}

	/**
	 * 找控件方法
	 */
	private void initView() {
		detail_callBack = (TextView) findViewById(R.id.detail_callBack);
		detail_addCar = (TextView) findViewById(R.id.detail_addCar);
		detail_vp = (ViewPager) findViewById(R.id.detail_vp);
		detail_goodname = (TextView) findViewById(R.id.detail_goodname);
		detail_marketPrice = (TextView) findViewById(R.id.detail_marketPrice);
		detail_score = (TextView) findViewById(R.id.detail_score);
		detail_price = (TextView) findViewById(R.id.detail_price);
		detail_goodnum = (EditText) findViewById(R.id.detail_goodnum);
		detail_add = (Button) findViewById(R.id.detail_add);
		detail_shoucang = (Button) findViewById(R.id.detail_shoucang);
		detail_available = (TextView) findViewById(R.id.detail_available);
		detail_comment_count = (TextView) findViewById(R.id.detail_comment_count);
		detail_product_prom = (TextView) findViewById(R.id.detail_product_prom);
		
		// 控件点击事件
		detail_callBack.setOnClickListener(this);
		detail_addCar.setOnClickListener(this);
		detail_add.setOnClickListener(this);
		detail_shoucang.setOnClickListener(this);
		
	}

	/**
	 * 请求网络数据方法
	 */
	private void initData() {
		String path = "http://121.42.8.95:8090/ECServer_D/product?pId=" + id;
		// 请求网络接口
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(path).build();

		client.newCall(request).enqueue(new Callback() {

			
			
			@Override
			public void onFailure(Request arg0, IOException arg1) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onResponse(Response arg0) throws IOException {
				// 得到网络数据
				String result = arg0.body().string();
				// 解析数据
				Gson gson = new Gson();
				DetailBean detailBean = gson.fromJson(result, DetailBean.class);
				Product product = detailBean.product;
				// 通过handler发送数据
				Message message = new Message();
				message.obj = product;

				handler.sendMessage(message);
				
			}

			
		});

	}

	/**
	 * 点击事件
	 */
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// 返回按钮
		case R.id.detail_callBack:
			finish();
			break;

		// 加入购物车
		case R.id.detail_addCar:
			addCar();
			break;
		// 加入购物车
		case R.id.detail_add:
			addCar();
			break;
		// 添加进收藏夹
		case R.id.detail_shoucang:
			shouCang();
			break;
		}

	}

	/**
	 * 添加购物车方法
	 */
	private void addCar() {

		Toast.makeText(DetailActivity.this, "加入购物车成功！", Toast.LENGTH_SHORT).show();
		
	}

	/**
	 * 添加收藏夹方法
	 */
	private void shouCang() {
		String path = "http://121.42.8.95:8090/ECServer_D//product/collect?pId=" + id;

		// 创建一个RequestQueue对象
		RequestQueue mQueue = Volley.newRequestQueue(this);

		// 创建一个StringRequest对象==========get请求(3个请求参数)post请求(4个请求参数)
		StringRequest stringRequest = new StringRequest(path, new Listener<String>() {
			@Override
			public void onResponse(String response) {
				// 请求成功后具体解析数据方法.........

				Toast.makeText(DetailActivity.this, "添加收藏成功！", Toast.LENGTH_SHORT).show();

			}
		}, new ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				Log.e("TAG", error.getMessage(), error);
			}
		});

		// 将StringRequest对象添加到RequestQueue里面。
		mQueue.add(stringRequest);

	}
	
	
	

}
