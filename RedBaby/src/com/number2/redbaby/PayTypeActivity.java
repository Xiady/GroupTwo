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

/*
 * 支付方式
 */
public class PayTypeActivity extends Activity implements OnClickListener {

	private LinearLayout layout_xianjin;
	private LinearLayout layout_pos;
	private LinearLayout layout_zhifubao;
	private RadioButton radio_pos;
	private RadioButton radio_money;
	private RadioButton radio_zhifubao;

	String type = "";
	private Button cart_pay_jiesuan;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pay_type);

		findView();
		setClick();
	}

	private void setClick() {
		layout_pos.setOnClickListener(this);
		layout_xianjin.setOnClickListener(this);
		layout_zhifubao.setOnClickListener(this);
		cart_pay_jiesuan.setOnClickListener(this);
	}

	/*
	 * 找控件
	 */
	private void findView() {
		cart_pay_jiesuan = (Button) findViewById(R.id.cart_pay_payjie);
		layout_xianjin = (LinearLayout) findViewById(R.id.pay_type_li_xianjin);
		layout_pos = (LinearLayout) findViewById(R.id.pay_type_li_pos);
		radio_pos = (RadioButton) findViewById(R.id.payt_ype_radio_pos);
		radio_money = (RadioButton) findViewById(R.id.payt_ype_radio_money);
		radio_zhifubao = (RadioButton) findViewById(R.id.payt_ype_radio_zhifubao);
		layout_zhifubao = (LinearLayout) findViewById(R.id.pay_type_li_zhifubao);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.pay_type_li_pos:
			// type="到付—pos";
			radio_pos.setBackgroundResource(R.drawable.ok);
			radio_money.setBackgroundResource(R.drawable.write);
			radio_zhifubao.setBackgroundResource(R.drawable.write);
			Intent intent1 = new Intent();
			intent1.putExtra("type", "到付—pos");
			setResult(2, intent1);
			// finish();
			break;
		case R.id.pay_type_li_xianjin:
			// type="到付—现金";
			radio_money.setBackgroundResource(R.drawable.ok);
			radio_pos.setBackgroundResource(R.drawable.write);
			radio_zhifubao.setBackgroundResource(R.drawable.write);
			Intent intent2 = new Intent();

			intent2.putExtra("type", "到付—现金");
			setResult(2, intent2);
			// finish();
			break;
		case R.id.pay_type_li_zhifubao:
			// type="支付宝";
			radio_zhifubao.setBackgroundResource(R.drawable.ok);
			radio_money.setBackgroundResource(R.drawable.write);
			radio_pos.setBackgroundResource(R.drawable.write);
			Intent intent3 = new Intent();

			intent3.putExtra("type", "支付宝");
			setResult(2, intent3);
			// finish();
			break;

		case R.id.cart_pay_payjie:

			finish();
			break;

		}
	}

}
