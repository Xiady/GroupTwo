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
import android.widget.TextView;

public class PaySendTimeActivity extends Activity implements OnClickListener {

	private LinearLayout layout_total;
	private LinearLayout layout_weekday;
	private LinearLayout layout_workday;
	private RadioButton view_allday;
	private RadioButton view_weekday;
	private RadioButton view_workday;
	private Button button_jiesuan;

	String paytime = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pay_send_time);

		findView();
		setClick();

	}

	// 设置监听事件
	private void setClick() {

		layout_total.setOnClickListener(this);
		layout_weekday.setOnClickListener(this);
		layout_workday.setOnClickListener(this);
		button_jiesuan.setOnClickListener(this);
	}

	// 找控件
	private void findView() {

		layout_total = (LinearLayout) findViewById(R.id.pay_time_li_total);
		layout_weekday = (LinearLayout) findViewById(R.id.pay_time_li_weekday);
		layout_workday = (LinearLayout) findViewById(R.id.pay_time_li_workday);
		view_allday = (RadioButton) findViewById(R.id.payt_time_radio_allday);
		view_weekday = (RadioButton) findViewById(R.id.payt_time_radio_weekday);
		view_workday = (RadioButton) findViewById(R.id.payt_time_radio_workday);
		button_jiesuan = (Button) findViewById(R.id.cart_time_payjie);
	}

	/*
	 * 点击监听(non-Javadoc)
	 * 
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.pay_time_li_total:
			paytime = "工作日，双休日与节假日均可送货";
			view_allday.setBackgroundResource(R.drawable.ok);
			view_weekday.setBackgroundResource(R.drawable.write);
			view_workday.setBackgroundResource(R.drawable.write);

			Intent intent1 = new Intent();

			intent1.putExtra("time", paytime);
			setResult(3, intent1);
			// finish();

			break;
		case R.id.pay_time_li_weekday:
			paytime = "只双休日节假日送货（工作日不送货）";
			view_allday.setBackgroundResource(R.drawable.write);
			view_weekday.setBackgroundResource(R.drawable.ok);
			view_workday.setBackgroundResource(R.drawable.write);
			Intent intent2 = new Intent();

			intent2.putExtra("time", paytime);
			setResult(3, intent2);
			// finish();
			break;
		case R.id.pay_time_li_workday:
			paytime = "只工作日送货（双休日，节假日不送货）";
			view_allday.setBackgroundResource(R.drawable.write);
			view_weekday.setBackgroundResource(R.drawable.write);
			view_workday.setBackgroundResource(R.drawable.ok);
			Intent intent3 = new Intent();

			intent3.putExtra("time", paytime);
			setResult(3, intent3);
			break;
		case R.id.cart_time_payjie:

			// Intent intent = new
			// Intent(PaySendTimeActivity.this,Cart_payActivity.class);
			// intent.putExtra("paytime", paytime);
			// startActivity(intent);
			finish();
			break;

		}
	}

}
