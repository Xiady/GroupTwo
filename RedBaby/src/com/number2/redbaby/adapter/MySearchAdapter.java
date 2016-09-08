package com.number2.redbaby.adapter;

import java.util.List;

import com.bumptech.glide.Glide;
import com.number2.redbaby.R;
import com.number2.redbaby.bean.Productlist1;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MySearchAdapter extends BaseAdapter {

	Context context;
	List<Productlist1> list_productlist1;

	public MySearchAdapter(Context context, List<Productlist1> list_productlist) {
		this.context = context;
		this.list_productlist1 = list_productlist;
	}

	@Override
	public int getCount() {
		return list_productlist1.size();
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
		View view = View.inflate(context, R.layout.search_adapter_item, null);

		TextView search_adapter_name = (TextView) view
				.findViewById(R.id.search_adapter_name);
		TextView search_adapter_comment_count = (TextView) view
				.findViewById(R.id.search_adapter_comment_count);
		TextView search_adapter_marketprice = (TextView) view
				.findViewById(R.id.search_adapter_marketprice);
		TextView search_adapter_price = (TextView) view
				.findViewById(R.id.search_adapter_price);
		ImageView search_adapter_img = (ImageView) view
				.findViewById(R.id.search_adapter_img);

		search_adapter_marketprice.getPaint().setFlags(
				Paint.STRIKE_THRU_TEXT_FLAG);

		search_adapter_name.setText(list_productlist1.get(position).name);
		search_adapter_price.setText("¥"
				+ list_productlist1.get(position).price);
		search_adapter_marketprice.setText("¥"
				+ list_productlist1.get(position).marketprice);
		search_adapter_comment_count.setText("已有"
				+ list_productlist1.get(position).comment_count + "人评价");
		Glide.with(context).load(list_productlist1.get(position).pic)
				.into(search_adapter_img);

		return view;
	}

}
