package com.number2.redbaby;

import java.util.ArrayList;
import java.util.List;

import com.number2.redbaby.adapter.MyPayListAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

/*
 * 结算中心
 */
public class Cart_payActivity extends Activity implements OnClickListener {

	private Button pay_put;
	private TextView pay_address;
	private TextView pay_cuxiao;
	private TextView pay_money;
	private TextView pay_num;
	private TextView pay_paytype;
	private TextView pay_time;
	private TextView pay_type;
	private TextView pay_yingfu;
	private TextView pay_yunfei;
	private ListView pay_list;
	private TextView pay_text_fapiao;
	private TextView pay_address_;
	private TextView pay_paytype_;
	private TextView pay_text_fapiao_;
	private TextView pay_time_;
	private TextView pay_type_;
	private Button pay_edit;
	private String pay_type_text;
	private Button pay_account;
	private TextView pay_youhui;
	private TextView pay_youhui_quan;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cart_pay);

		// 找控件
		findView();
		// 监听事件
		setClick();
		setMyAdapter();


	}


	/*
	 * ListView的适配器
	 */
	private void setMyAdapter() {
		List<String> list_pay = new ArrayList<String>();
		for (int i = 0; i < 5; i++) {
			list_pay.add("1");
		}

		pay_list.setAdapter(new MyPayListAdapter(Cart_payActivity.this,
				list_pay));
	}

	private void setClick() {
		pay_address.setOnClickListener(this);
		pay_put.setOnClickListener(this);
		pay_cuxiao.setOnClickListener(this);
		pay_money.setOnClickListener(this);
		pay_num.setOnClickListener(this);
		pay_paytype.setOnClickListener(this);
		pay_time.setOnClickListener(this);
		pay_type.setOnClickListener(this);
		pay_yingfu.setOnClickListener(this);
		pay_yunfei.setOnClickListener(this);
		pay_text_fapiao.setOnClickListener(this);
		pay_edit.setOnClickListener(this);
		pay_youhui.setOnClickListener(this);
	}

	private void findView() {
		pay_put = (Button) findViewById(R.id.pay_button_put);
		pay_account = (Button) findViewById(R.id.cart_button_account);
		pay_edit = (Button) findViewById(R.id.cart_button_edit);
		pay_address = (TextView) findViewById(R.id.pay_text_address1);
		pay_address_ = (TextView) findViewById(R.id.pay_text_address);
		pay_cuxiao = (TextView) findViewById(R.id.pay_text_cuxiao);
		pay_money = (TextView) findViewById(R.id.pay_text_money);
		pay_num = (TextView) findViewById(R.id.pay_text_num);
		pay_paytype = (TextView) findViewById(R.id.pay_text_paytype1);
		pay_paytype_ = (TextView) findViewById(R.id.pay_text_paytype);
		pay_text_fapiao = (TextView) findViewById(R.id.pay_text_fapiao1);
		pay_text_fapiao_ = (TextView) findViewById(R.id.pay_text_fapiao);
		pay_time = (TextView) findViewById(R.id.pay_text_time1);
		pay_time_ = (TextView) findViewById(R.id.pay_text_time);
		pay_type = (TextView) findViewById(R.id.pay_text_type1);
		pay_type_ = (TextView) findViewById(R.id.pay_text_type);
		pay_yingfu = (TextView) findViewById(R.id.pay_text_yingfu);
		pay_yunfei = (TextView) findViewById(R.id.pay_text_yunfei);
		pay_youhui = (TextView) findViewById(R.id.pay_text_youhui);
		pay_youhui_quan = (TextView) findViewById(R.id.pay_text_youhuiquan);
		pay_list = (ListView) findViewById(R.id.cart_pay_list);
	}

	// 点击事件
	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		// 提交订单
		case R.id.pay_button_put:

			// 支付宝支付

			startActivity(new Intent(Cart_payActivity.this,
					PayDemoActivity.class));

			break;
		// 提交订单
		case R.id.cart_button_account:

			// 支付宝支付

			startActivity(new Intent(Cart_payActivity.this,
					PayDemoActivity.class));

			break;
		// 购物车
		case R.id.cart_button_edit:
			onBackPressed();
			break;
		// 优惠券
		case R.id.pay_text_youhui:
			startActivityForResult(new Intent(Cart_payActivity.this,
					CartPayYouhuiActivity.class), 5);
			break;
		// 收货地址管理
		case R.id.pay_text_address1:

			startActivityForResult(new Intent(Cart_payActivity.this,
					AddressActivity.class), 1);
			
			break;
		// 促销价格
		case R.id.pay_text_cuxiao:

			break;
		// 原始金额
		case R.id.pay_text_money:

			break;
		// 数量
		case R.id.pay_text_num:

			break;
		// 发票类型
		case R.id.pay_text_fapiao1:

			startActivityForResult(new Intent(Cart_payActivity.this,
					CartPayTypeActivity.class), 6);

			break;
		// 收货时间
		case R.id.pay_text_time1:
			startActivityForResult(new Intent(Cart_payActivity.this,
					PaySendTimeActivity.class), 3);
			break;
		// 支付方法
		case R.id.pay_text_type1:

			startActivityForResult(new Intent(Cart_payActivity.this,
					PayTypeActivity.class), 2);
			break;
		// 送货方式
		case R.id.pay_text_paytype1:

			break;

		}
	}

	/*
	 * 回传值(non-Javadoc)
	 * 
	 * @see android.app.Activity#onActivityResult(int, int,
	 * android.content.Intent)
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch (resultCode) {
		case 2:
			pay_type_text = data.getStringExtra("type");
			pay_type_.setText(data.getStringExtra("type"));
			break;
		case 3:

			pay_time_.setText(data.getStringExtra("time"));
			break;
		case 6:

			pay_text_fapiao_.setText("发票抬头人："
					+ data.getStringExtra("fapiao_people") + "\n" + "发票内容："
					+ data.getStringExtra("fapiao_message"));
			break;
		case 5:

			pay_youhui_quan.setText("优惠券：" + data.getStringExtra("liquan"));
			break;
		case 1:
			
			pay_address_.setText("地址：" + data.getStringExtra("address"));
			break;

		default:
			break;
		}
	}

}
