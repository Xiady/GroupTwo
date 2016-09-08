package com.number2.redbaby;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.number2.redbaby.fragment.Shouye_cuxiao;
import com.number2.redbaby.fragment.Shouye_remen;
import com.number2.redbaby.fragment.Shouye_tuijian;
import com.number2.redbaby.fragment.Shouye_xianshi;
import com.number2.redbaby.fragment.Shouye_xinpin;

public class ShouListActivity extends FragmentActivity {

	private TextView shouye_back;
	private TextView shouye_title_tv;
	private FrameLayout shouye_frafra;
	private String title;
	private Shouye_cuxiao cuxiao;
	private Shouye_remen remen;
	private Shouye_tuijian tuijian;
	private Shouye_xianshi xianshi;
	private Shouye_xinpin xinpin;
	private FragmentManager manager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shou_list);

		initData();

		initEvent();
	}

	private void initEvent() {
		// ������ת������ֵ
		Intent intent = getIntent();
		title = intent.getStringExtra("lname");
		shouye_title_tv.setText(title);

		// ���ذ�ť
		shouye_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
		manager = getSupportFragmentManager();
		// FragmentTransaction transaction = manager.beginTransaction();

		cuxiao = new Shouye_cuxiao();
		remen = new Shouye_remen();
		tuijian = new Shouye_tuijian();
		xianshi = new Shouye_xianshi();
		xinpin = new Shouye_xinpin();

		// transaction.add(R.id.shouye_frafra, cuxiao);
		// transaction.add(R.id.shouye_frafra, remen);
		// transaction.add(R.id.shouye_frafra, tuijian);
		// transaction.add(R.id.shouye_frafra, xianshi);
		// transaction.add(R.id.shouye_frafra, xinpin);

		switchTag(title);
		// transaction.commit();

	}

	private void switchTag(String tag) {
		FragmentTransaction transaction = manager.beginTransaction();
		if (tag.equals("��ʱ����")) {

			transaction.replace(R.id.shouye_frafra, xianshi).commit();

		} else if (tag.equals("�����챨")) {

			transaction.replace(R.id.shouye_frafra, cuxiao).commit();

		} else if (tag.equals("��Ʒ�ϼ�")) {

			transaction.replace(R.id.shouye_frafra, xinpin).commit();

		} else if (tag.equals("���ŵ�Ʒ")) {

			transaction.replace(R.id.shouye_frafra, remen).commit();

		} else if (tag.equals("�Ƽ�Ʒ��")) {

			transaction.replace(R.id.shouye_frafra, tuijian).commit();

		}
	}

	private void initData() {
		shouye_back = (TextView) findViewById(R.id.shouye_back);
		shouye_title_tv = (TextView) findViewById(R.id.shouye_title_tv);
		shouye_frafra = (FrameLayout) findViewById(R.id.shouye_frafra);

	}

}
