package com.number2.redbaby.adapter;

import java.util.List;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.number2.redbaby.R;
import com.number2.redbaby.bean.LunBoBean.Home;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MyLunBoAdapter extends PagerAdapter {

	Context context;
	List<Home> hList;

	public MyLunBoAdapter(Context context, List<Home> hList) {
		this.context = context;
		this.hList = hList;
	}

	@Override
	public int getCount() {
		return Integer.MAX_VALUE;
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
	public Object instantiateItem(ViewGroup container, int position) {
		ImageView iv = new ImageView(context);
		Picasso.with(context).load(hList.get(position % hList.size()).pic)
				.error(R.drawable.ic_launcher).into(iv);
		container.addView(iv);
		return iv;
	}

}
