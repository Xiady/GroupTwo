package com.number2.redbaby;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.number2.redbaby.adapter.MyDetailBigImgAdapter;

public class DetailBigActivity extends Activity {

	private ViewPager detailBig_img;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_big);

		detailBig_img = (ViewPager) findViewById(R.id.detailBig_img);

		Intent intent = getIntent();
		String[] bigPic = intent.getStringArrayExtra("bigPic1");

		detailBig_img.setAdapter(new MyDetailBigImgAdapter(
				DetailBigActivity.this, bigPic));

	}

}
