package com.number2.redbaby;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

/**
 * ��Ʒ�ղ�
 * 
 * @author HP
 * 
 */
public class CollectActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_collect);
		initView();
	}

	private void initView() {
		TextView mCallBackIm = (TextView) findViewById(R.id.callBackIm);
		mCallBackIm.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.callBackIm:
			onBackPressed();
			overridePendingTransition(R.anim.from_left, R.anim.from_right);

			break;

		default:
			break;
		}
	}

	/**
	 * ������һ��
	 */
	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}

}
