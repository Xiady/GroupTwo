package com.number2.redbaby.adapter;

import java.util.List;

import com.number2.redbaby.R;
import com.number2.redbaby.bean.Pai_Category;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PaiAdapter extends BaseAdapter {
	Context context;
	List<Pai_Category> list;

	public PaiAdapter(Context context, List<Pai_Category> list) {
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = View.inflate(context, R.layout.pai_lv_item, null);
		TextView pai_tv_name = (TextView) view.findViewById(R.id.pai_tv_name);
		TextView pai_tv_tag = (TextView) view.findViewById(R.id.pai_tv_tag);
		pai_tv_name.setText(list.get(position).name);
		pai_tv_tag.setText(list.get(position).tag);

		return view;
	}

}
