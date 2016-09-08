package com.number2.redbaby.adapter;

import java.util.List;

import com.number2.redbaby.R;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class MyPayListAdapter extends BaseAdapter {

	Context context;
	List<String> list_pay;
	private ViewHolder holder;

	public MyPayListAdapter(Context context, List<String> list_pay) {
		this.context = context;
		this.list_pay = list_pay;
	}

	@Override
	public int getCount() {
		return list_pay.size();
	}

	@Override
	public Object getItem(int position) {
		return list_pay.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// 判断缓存是否为空
		if (convertView == null) {
			convertView = View.inflate(context, R.layout.fragment_addcart_item,
					null);
			holder = new ViewHolder();
			holder.box = (CheckBox) convertView
					.findViewById(R.id.addcart_check_item);
			holder.addcart_item_image = (ImageView) convertView
					.findViewById(R.id.addcart_item_image);
			holder.addcart_item_num = (TextView) convertView
					.findViewById(R.id.addcart_item_num);
			holder.addcart_item_color = (TextView) convertView
					.findViewById(R.id.addcart_item_color);
			holder.addcart_item_size = (TextView) convertView
					.findViewById(R.id.addcart_item_size);
			holder.addcart_item_money = (TextView) convertView
					.findViewById(R.id.addcart_item_money);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		//holder.addcart_item_image.setBackgroundResource(list_pay.get(position));
		//holder.box.setChecked(list_pay.get(position));
		holder.addcart_item_num.setText(list_pay.get(position));
		holder.addcart_item_color.setText(list_pay.get(position));
		holder.addcart_item_size.setText(list_pay.get(position));
		holder.addcart_item_money.setText(list_pay.get(position));
		// 单选框的选择事件
		holder.box.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
//				if (list_pay.get(position).isChecked) {
//					list_pay.get(position).isChecked = false;
//				} else {
//					list_pay.get(position).isChecked = true;
//				}
			}
		});

		return convertView;
	}

	class ViewHolder {
		ImageView addcart_item_image;
		CheckBox box;
		TextView addcart_item_num;
		TextView addcart_item_color;
		TextView addcart_item_size;
		TextView addcart_item_money;
	}

}
