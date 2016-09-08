package com.number2.redbaby.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.number2.redbaby.R;
import com.number2.redbaby.bean.BabyBean.Productlist;
import com.squareup.picasso.Picasso;

public class MyReMenAdapter extends BaseAdapter {

	Context context;
	List<Productlist> productlist;

	public MyReMenAdapter(Context context, List<Productlist> productlist) {
		this.context = context;
		this.productlist = productlist;
	}

	@Override
	public int getCount() {
		return productlist.size();
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
		MyViewHolder viewHolder;
		if (convertView == null) {
			convertView = View.inflate(context, R.layout.remen_item, null);
			viewHolder = new MyViewHolder();

			viewHolder.xinpin_iv = (ImageView) convertView.findViewById(R.id.xinpin_iv);
			viewHolder.xinpin_name = (TextView) convertView.findViewById(R.id.xinpin_tv_name);
			viewHolder.xinpin_price = (TextView) convertView.findViewById(R.id.xinpin_tv_price);

			convertView.setTag(viewHolder);
		} else {
			viewHolder = (MyViewHolder) convertView.getTag();
		}
		Picasso.with(context).load(productlist.get(position).pic).into(viewHolder.xinpin_iv);
		viewHolder.xinpin_name.setText(productlist.get(position).name);
		viewHolder.xinpin_price.setText("¼ÛÇ®:" + productlist.get(position).price + "");

		return convertView;
	}

	class MyViewHolder {

		ImageView xinpin_iv;
		TextView xinpin_name;
		TextView xinpin_price;

	}
}
