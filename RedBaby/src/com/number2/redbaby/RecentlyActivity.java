package com.number2.redbaby;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 最进浏览
 * 
 * @author HP
 * 
 */
public class RecentlyActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recently);

		initView();
	}

	private void initView() {
		TextView mCallBackIm = (TextView) findViewById(R.id.callBackIm);
		mCallBackIm.setOnClickListener(this);
		TextView mEmpty = (TextView) findViewById(R.id.empty);
		mEmpty.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.callBackIm:
			onBackPressed();
			overridePendingTransition(R.anim.from_left, R.anim.from_right);

			break;
		case R.id.exit:
			Toast.makeText(RecentlyActivity.this, "成功清除", Toast.LENGTH_SHORT)
					.show();
			break;
		default:
			break;
		}
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
	}
}
