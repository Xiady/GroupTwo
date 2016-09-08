package com.number2.redbaby.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.number2.redbaby.R;
import com.number2.redbaby.bean.BabyBean.Brand;
import com.squareup.picasso.Picasso;

public class MyTuiJian1Adapter extends BaseAdapter {

	Context context;
	List<Brand> brandList;

	public MyTuiJian1Adapter(Context context, List<Brand> brandList) {
		this.context = context;
		this.brandList = brandList;
	}

	@Override
	public int getCount() {
		return brandList.get(0).value.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if (convertView == null) {
			convertView = View.inflate(context, R.layout.tuijian_item, null);
			viewHolder = new ViewHolder();
			viewHolder.tuijian_iv = (ImageView) convertView.findViewById(R.id.tuijian_iv);
			viewHolder.tuijian_tv = (TextView) convertView.findViewById(R.id.tuijian_tv);

			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		Picasso.with(context).load(brandList.get(0).value.get(position).pic).into(viewHolder.tuijian_iv);
		viewHolder.tuijian_tv.setText(brandList.get(0).value.get(position).name);
		return convertView;
	}

	class ViewHolder {
		ImageView tuijian_iv;
		TextView tuijian_tv;
	}
}
