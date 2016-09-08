package com.number2.redbaby.adapter;

import com.bumptech.glide.Glide;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MyDetailBigImgAdapter extends PagerAdapter {

	Context context;
	String[] bigPic;

	public MyDetailBigImgAdapter(Context context, String[] bigPic) {
		this.context = context;
		this.bigPic = bigPic;
	}

	@Override
	public int getCount() {

		return bigPic.length;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		ImageView iv = new ImageView(context);
		Glide.with(context).load(bigPic[position]).into(iv);
		container.addView(iv);
		return iv;
	}

}
