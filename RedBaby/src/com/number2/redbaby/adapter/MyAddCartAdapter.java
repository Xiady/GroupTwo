package com.number2.redbaby.adapter;

import java.util.List;

import com.number2.redbaby.R;
import com.number2.redbaby.adapter.MyPayListAdapter.ViewHolder;
import com.number2.redbaby.bean.CartProduct;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAddCartAdapter extends BaseAdapter {
	Context context;

	List<CartProduct> list;

	public MyAddCartAdapter(Context context, List<CartProduct> list) {
		this.context = context;
		this.list = list;

	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder;
		if (convertView == null) {

			convertView = View.inflate(context, R.layout.fragment_addcart_item,
					null);
			holder = new ViewHolder();
			holder.text_name = (TextView) convertView
					.findViewById(R.id.addcart_item_name);
			holder.text_color = (TextView) convertView
					.findViewById(R.id.addcart_item_color);
			holder.imageView = (ImageView) convertView
					.findViewById(R.id.addcart_item_image);
			holder.text_money = (TextView) convertView
					.findViewById(R.id.addcart_item_money);
			holder.text_num = (TextView) convertView
					.findViewById(R.id.addcart_item_num);
			holder.text_sixe = (TextView) convertView
					.findViewById(R.id.addcart_item_size);

			convertView.setTag(holder);

		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		return convertView;


	}

	class ViewHolder {
		ImageView imageView;
		TextView text_name;
		TextView text_color;
		TextView text_money;
		TextView text_num;
		TextView text_sixe;
	}

}
