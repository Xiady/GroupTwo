package com.number2.redbaby;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/*
 * 
 * 索要发票
 */
public class CartPayTypeActivity extends Activity implements OnClickListener {

	private LinearLayout paytype_book_li;
	private LinearLayout paytype_game_li;
	private LinearLayout paytype_person_li;
	private LinearLayout paytype_ruanjian_li;
	private LinearLayout paytype_team_li;
	private LinearLayout paytype_voice_li;
	private LinearLayout paytype_ziliao_li;
	String fapiao_people = "";
	String fapiao_message = "";
	private Button back_jiesuan_li;
	private Button paytype_book;
	private Button paytype_game;
	private Button paytype_person;
	private Button paytype_ruanjian;
	private Button paytype_team;
	private Button paytype_voice;
	private Button paytype_ziliao;
	private TextView view_peytype;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cart_pay_type);

		findView();
		setClick();
		Intent intent = new Intent();

		intent.putExtra("fapiao_people", fapiao_people);
		intent.putExtra("fapiao_message", fapiao_message);
		setResult(6, intent);

	}

	/*
	 * 找控件
	 */
	private void findView() {

		paytype_book_li = (LinearLayout) findViewById(R.id.paytype_radio_book_li);
		paytype_game_li = (LinearLayout) findViewById(R.id.paytype_radio_game_li);
		paytype_person_li = (LinearLayout) findViewById(R.id.paytype_radio_person_li);
		paytype_ruanjian_li = (LinearLayout) findViewById(R.id.paytype_radio_ruanjian_li);
		paytype_team_li = (LinearLayout) findViewById(R.id.paytype_radio_team_li);
		paytype_voice_li = (LinearLayout) findViewById(R.id.paytype_radio_voice_li);
		paytype_ziliao_li = (LinearLayout) findViewById(R.id.paytype_radio_ziliao_li);
		back_jiesuan_li = (Button) findViewById(R.id.cart_fapiao_payjie);
		paytype_book = (Button) findViewById(R.id.paytype_radio_book);
		paytype_game = (Button) findViewById(R.id.paytype_radio_game);
		paytype_person = (Button) findViewById(R.id.paytype_radio_person);
		paytype_ruanjian = (Button) findViewById(R.id.paytype_radio_ruanjian);
		paytype_team = (Button) findViewById(R.id.paytype_radio_team);
		paytype_voice = (Button) findViewById(R.id.paytype_radio_voice);
		paytype_ziliao = (Button) findViewById(R.id.paytype_radio_ziliao);
		view_peytype = (TextView) findViewById(R.id.pay_text_paytype);
	}

	/*
	 * 点击替换
	 */
	public void setClick() {
		paytype_book_li.setOnClickListener(this);
		paytype_game_li.setOnClickListener(this);
		paytype_person_li.setOnClickListener(this);
		paytype_ruanjian_li.setOnClickListener(this);
		paytype_team_li.setOnClickListener(this);
		paytype_voice_li.setOnClickListener(this);
		paytype_ziliao_li.setOnClickListener(this);
		back_jiesuan_li.setOnClickListener(this);
	}

	/*
	 * 点击事件(non-Javadoc)
	 * 
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.paytype_radio_book_li:
			fapiao_message = "图书";
			paytype_book.setBackgroundResource(R.drawable.ok);
			paytype_game.setBackgroundResource(R.drawable.write);
			paytype_ruanjian.setBackgroundResource(R.drawable.write);
			paytype_voice.setBackgroundResource(R.drawable.write);
			paytype_ziliao.setBackgroundResource(R.drawable.write);
			Intent intent1 = new Intent();

			intent1.putExtra("fapiao_people", fapiao_people);
			intent1.putExtra("fapiao_message", fapiao_message);
			setResult(6, intent1);
			break;
		case R.id.paytype_radio_game_li:
			fapiao_message = "游戏";
			paytype_book.setBackgroundResource(R.drawable.write);
			paytype_game.setBackgroundResource(R.drawable.ok);
			paytype_ruanjian.setBackgroundResource(R.drawable.write);
			paytype_voice.setBackgroundResource(R.drawable.write);
			paytype_ziliao.setBackgroundResource(R.drawable.write);
			Intent intent2 = new Intent();

			intent2.putExtra("fapiao_people", fapiao_people);
			intent2.putExtra("fapiao_message", fapiao_message);
			setResult(6, intent2);
			break;
		case R.id.paytype_radio_person_li:
			fapiao_people = "个人";
			paytype_person.setBackgroundResource(R.drawable.ok);
			paytype_team.setBackgroundResource(R.drawable.write);
			Intent intent3 = new Intent();

			intent3.putExtra("fapiao_people", fapiao_people);
			intent3.putExtra("fapiao_message", fapiao_message);
			setResult(6, intent3);
			break;
		case R.id.paytype_radio_ruanjian_li:
			fapiao_message = "软件";
			paytype_book.setBackgroundResource(R.drawable.write);
			paytype_game.setBackgroundResource(R.drawable.write);
			paytype_ruanjian.setBackgroundResource(R.drawable.ok);
			paytype_voice.setBackgroundResource(R.drawable.write);
			paytype_ziliao.setBackgroundResource(R.drawable.write);
			Intent intent4 = new Intent();

			intent4.putExtra("fapiao_people", fapiao_people);
			intent4.putExtra("fapiao_message", fapiao_message);
			setResult(6, intent4);
			break;
		case R.id.paytype_radio_team_li:
			fapiao_people = "单位";
			paytype_person.setBackgroundResource(R.drawable.write);
			paytype_team.setBackgroundResource(R.drawable.ok);
			Intent intent5 = new Intent();

			intent5.putExtra("fapiao_people", fapiao_people);
			intent5.putExtra("fapiao_message", fapiao_message);
			setResult(6, intent5);
			break;
		case R.id.paytype_radio_voice_li:
			fapiao_message = "音响";
			paytype_book.setBackgroundResource(R.drawable.write);
			paytype_game.setBackgroundResource(R.drawable.write);
			paytype_ruanjian.setBackgroundResource(R.drawable.write);
			paytype_voice.setBackgroundResource(R.drawable.ok);
			paytype_ziliao.setBackgroundResource(R.drawable.write);
			Intent intent6 = new Intent();

			intent6.putExtra("fapiao_people", fapiao_people);
			intent6.putExtra("fapiao_message", fapiao_message);
			setResult(6, intent6);
			break;
		case R.id.paytype_radio_ziliao_li:
			fapiao_message = "资料";
			paytype_book.setBackgroundResource(R.drawable.write);
			paytype_game.setBackgroundResource(R.drawable.write);
			paytype_ruanjian.setBackgroundResource(R.drawable.write);
			paytype_voice.setBackgroundResource(R.drawable.write);
			paytype_ziliao.setBackgroundResource(R.drawable.ok);
			Intent intent7 = new Intent();

			intent7.putExtra("fapiao_people", fapiao_people);
			intent7.putExtra("fapiao_message", fapiao_message);
			setResult(6, intent7);
			break;
		case R.id.cart_fapiao_payjie:
			finish();
			break;

		}
	}

}
