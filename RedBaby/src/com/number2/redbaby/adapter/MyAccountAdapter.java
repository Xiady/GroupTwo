package com.number2.redbaby.adapter;

import com.number2.redbaby.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAccountAdapter extends BaseAdapter {

	Context context;
	String[] data;
	private View mInflate;
	private TextView mTv;

	public MyAccountAdapter(Context context, String[] data) {

		this.data = data;
		this.context = context;
	}

	@Override
	public int getCount() {
		return data.length;
	}

	@Override
	public Object getItem(int position) {
		return data[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		mInflate = View.inflate(context, R.layout.account_item_layout, null);
		mTv = (TextView) mInflate.findViewById(R.id.tv);
		mTv.setText(data[position]);
		return mInflate;
	}

}
