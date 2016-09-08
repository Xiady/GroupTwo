package com.number2.redbaby;

import java.util.List;

import com.number2.redbaby.adapter.MyAddressAdapter;
import com.number2.redbaby.app.MyApplication;
import com.number2.redbaby.bean.Addresssave;

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
 * 地址管理
 * 
 * @author HP
 * 
 */
public class AddressActivity extends Activity implements OnClickListener {

	private ListView mLv;
	private List<Addresssave> listAddresssaves;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_address);
		initView();
		listAddresssaves = MyApplication.getListAddresssaves();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		setAdapter();
		setClick();

	}

	/*
	 * 条目的点击事件
	 */
	private void setClick() {

		/*
		 * 条目的点击事件
		 */
		mLv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				String areaid = listAddresssaves.get(arg2).getAreaid();
				String detail = listAddresssaves.get(arg2).getAreadetail();

				Intent intent = new Intent();
				intent.putExtra("address", areaid );
				setResult(1, intent);
				finish();
			}
		});
	}

	private void setAdapter() {

		MyAddressAdapter adapter = new MyAddressAdapter(
				getApplicationContext(), listAddresssaves);
		mLv.setAdapter(adapter);
		adapter.notifyDataSetChanged();

	}

	private void initView() {
		TextView mCallBackIm = (TextView) findViewById(R.id.callBackIm);
		mCallBackIm.setOnClickListener(this);
		TextView mAddress = (TextView) findViewById(R.id.addAddress);
		mAddress.setOnClickListener(this);

		mLv = (ListView) findViewById(R.id.lv);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.callBackIm:
			onBackPressed();
			overridePendingTransition(R.anim.from_left, R.anim.from_right);

			break;
		case R.id.addAddress:
			startActivity(new Intent(AddressActivity.this,
					AddAddressActivity.class));
			overridePendingTransition(R.anim.in_from_right, R.anim.in_from_left);
			break;
		default:
			break;
		}
	}

	/**
	 * 返回上一级
	 */
	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}

}
