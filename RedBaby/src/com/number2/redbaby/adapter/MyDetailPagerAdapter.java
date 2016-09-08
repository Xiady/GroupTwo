package com.number2.redbaby.adapter;

import android.R.integer;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.number2.redbaby.DetailBigActivity;

public class MyDetailPagerAdapter extends PagerAdapter {

	Context context;
	String[] pics;
	String[] bigPics;

	public MyDetailPagerAdapter(Context context, String[] pics, String[] bigPics) {
		this.context = context;
		this.pics = pics;
		this.bigPics = bigPics;
	}

	@Override
	public int getCount() {
		return 2;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
	}

	@Override
	public Object instantiateItem(ViewGroup container, final int position) {
		ImageView iv = new ImageView(context);
		Glide.with(context).load(pics[position]).into(iv);
		container.addView(iv);

		iv.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, DetailBigActivity.class);
				intent.putExtra("bigPic1", bigPics);
				context.startActivity(intent);

			}
			/*
			 * iv.setOnClickListener(new OnClickListener() {
			 * 
			 * @Override public void onClick(View v) { Intent intent = new
			 * Intent(context, DetailBigActivity.class);
			 * intent.putExtra("bigPic1", bigPics); startActivity(intent);
			 * 
			 * }
			 * 
			 * 
			 * });
			 */

		});

		return iv;
	}

}
