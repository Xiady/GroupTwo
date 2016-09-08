package com.number2.redbaby;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;

public class CartPayYouhuiActivity extends Activity implements OnClickListener {

	private LinearLayout layout_9;
	private LinearLayout layout_guoqing;
	private LinearLayout layout_shengdan;
	private RadioButton radio_9;
	private RadioButton radio_guoqing;
	private RadioButton radio_shengdan;
	String liquan = "";
	private Button button_payjie;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cart_pay_youhui);

		initView();
		setClick();

	}

	/*
	 * 设置监听
	 */
	private void setClick() {
		layout_9.setOnClickListener(this);
		layout_guoqing.setOnClickListener(this);
		layout_shengdan.setOnClickListener(this);
		button_payjie.setOnClickListener(this);
	}

	/*
	 * 找控件
	 */
	private void initView() {
		layout_9 = (LinearLayout) findViewById(R.id.pay_liqaun_li_9);
		layout_guoqing = (LinearLayout) findViewById(R.id.pay_liquan_li_guoqing);
		layout_shengdan = (LinearLayout) findViewById(R.id.pay_liquan_li_shengdan);
		radio_9 = (RadioButton) findViewById(R.id.payt_liquan_radio_9);
		radio_guoqing = (RadioButton) findViewById(R.id.payt_liquan_radio_guoqing);
		radio_shengdan = (RadioButton) findViewById(R.id.payt_liquan_radio_shengdan);
		button_payjie = (Button) findViewById(R.id.cart_liquan_payjie);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		// 九月大放送
		case R.id.pay_liqaun_li_9:

			liquan = "9月惊喜50元礼券";
			radio_9.setBackgroundResource(R.drawable.ok);
			radio_guoqing.setBackgroundResource(R.drawable.write);
			radio_shengdan.setBackgroundResource(R.drawable.write);

			Intent intent1 = new Intent();

			intent1.putExtra("liquan", liquan);
			setResult(5, intent1);
			break;
		// 国庆发送
		case R.id.pay_liquan_li_guoqing:
			liquan = "国庆节80元礼券";
			radio_9.setBackgroundResource(R.drawable.write);
			radio_guoqing.setBackgroundResource(R.drawable.ok);
			radio_shengdan.setBackgroundResource(R.drawable.write);

			Intent intent2 = new Intent();

			intent2.putExtra("liquan", liquan);
			setResult(5, intent2);

			break;
		// 圣诞
		case R.id.pay_liquan_li_shengdan:
			liquan = "圣诞节大发送80元礼券";
			radio_9.setBackgroundResource(R.drawable.write);
			radio_guoqing.setBackgroundResource(R.drawable.write);
			radio_shengdan.setBackgroundResource(R.drawable.ok);

			Intent intent3 = new Intent();

			intent3.putExtra("liquan", liquan);
			setResult(5, intent3);

			break;
		case R.id.cart_liquan_payjie:

			finish();
			break;

		}
	}

}
