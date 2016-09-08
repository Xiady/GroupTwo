package com.number2.redbaby.fragment;

import java.util.List;

import com.number2.redbaby.R;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class MyAddCartAdapter extends BaseAdapter {
	Context context;
	List<String> list;
	public MyAddCartAdapter(Context context,
			List<String> list) {
		this.context=context;
		this.list=list;
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
		View view=View.inflate(context, R.layout.fragment_addcart_item, null);
		view.findViewById(R.id.addcart_item_accout);
		return view;
	}

}
