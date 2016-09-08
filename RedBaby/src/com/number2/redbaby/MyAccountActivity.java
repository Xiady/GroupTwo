package com.number2.redbaby;

import com.number2.redbaby.adapter.MyAccountAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

/**
 * 账户订单
 * 
 * @author HP
 */
public class MyAccountActivity extends Activity implements OnClickListener,
		OnItemClickListener {

	String[] data = new String[] { "我的订单", "地址管理", "收藏夹" };
	private ListView mListView_user;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_account);
		initView();
		setAdapter();
	}

	private void setAdapter() {
		MyAccountAdapter accountAdapter = new MyAccountAdapter(
				MyAccountActivity.this, data);
		mListView_user.setAdapter(accountAdapter);
	}

	private void initView() {

		TextView mCallBackIm = (TextView) findViewById(R.id.callBackIm);
		mCallBackIm.setOnClickListener(this);
		mListView_user = (ListView) findViewById(R.id.listView_user);
		mListView_user.setOnItemClickListener(this);
		TextView mExit = (TextView) findViewById(R.id.exit);
		mExit.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.callBackIm:
			onBackPressed();
			overridePendingTransition(R.anim.from_left, R.anim.from_right);

			break;

		}
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		switch (arg2) {
		case 0:
			startActivity(new Intent(MyAccountActivity.this,
					IndentActivity.class));
			overridePendingTransition(R.anim.in_from_right, R.anim.in_from_left);
			break;

		case 1:
			startActivity(new Intent(MyAccountActivity.this,
					AddressActivity.class));
			overridePendingTransition(R.anim.in_from_right, R.anim.in_from_left);
			break;
		case 2:
			startActivity(new Intent(MyAccountActivity.this,
					CollectActivity.class));
			overridePendingTransition(R.anim.in_from_right, R.anim.in_from_left);
			break;
		}
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}

}
