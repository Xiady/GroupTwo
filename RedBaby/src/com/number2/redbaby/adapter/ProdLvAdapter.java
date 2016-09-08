package com.number2.redbaby.adapter;

import java.util.List;

import com.bumptech.glide.Glide;
import com.number2.redbaby.R;
import com.number2.redbaby.R.id;
import com.number2.redbaby.R.layout;
import com.number2.redbaby.bean.ProdInfo;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ProdLvAdapter extends BaseAdapter {
	Context context;
	List<ProdInfo> list;

	public ProdLvAdapter(Context context, List<ProdInfo> list) {
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		return arg0;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = View.inflate(context, R.layout.prod_lv_item, null);

		TextView prod_tv_name = (TextView) view.findViewById(R.id.prod_tv_name);
		TextView prod_tv_count = (TextView) view
				.findViewById(R.id.prod_tv_count);
		TextView prod_tv_price = (TextView) view
				.findViewById(R.id.prod_tv_price);
		TextView prod_tv_mkprice = (TextView) view
				.findViewById(R.id.prod_tv_mkprice);
		ImageView img = (ImageView) view.findViewById(R.id.prod_iv_img);

		prod_tv_name.setText(list.get(position).name);
		prod_tv_count.setText("已有" + list.get(position).comment_count + "人评价");
		prod_tv_mkprice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
		prod_tv_mkprice.setText("￥" + list.get(position).marketprice);
		prod_tv_price.setText("￥" + list.get(position).price);
		Glide.with(context).load(list.get(position).pic).into(img);
		return view;
	}

}
