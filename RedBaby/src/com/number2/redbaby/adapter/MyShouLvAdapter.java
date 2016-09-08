package com.number2.redbaby.adapter;

import com.number2.redbaby.R;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

public class MyShouLvAdapter extends BaseAdapter implements ListAdapter {
	Context context;
	String[] textview;
	int[] image;

	public MyShouLvAdapter(Context context, String[] textview, int[] image) {
		this.context = context;
		this.textview = textview;
		this.image = image;

	}

	@Override
	public int getCount() {
		return textview.length;
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = View.inflate(context, R.layout.menu_lv, null);
		}
		ImageView iv = (ImageView) convertView.findViewById(R.id.menu_lv_iv);
		TextView tv = (TextView) convertView.findViewById(R.id.menu_lv_tv);
		iv.setImageResource(image[position]);
		tv.setText(textview[position]);
		return convertView;
	}
}
