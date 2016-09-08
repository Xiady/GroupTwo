package com.number2.redbaby.adapter;

import java.util.List;

import com.number2.redbaby.AddAddressActivity;
import com.number2.redbaby.R;
import com.number2.redbaby.bean.Addresssave;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAddressAdapter extends BaseAdapter {

	Context context;
	List<Addresssave> listAddresssaves;

	public MyAddressAdapter(Context context, List<Addresssave> listAddresssaves) {

		this.context = context;
		this.listAddresssaves = listAddresssaves;
	}

	@Override
	public int getCount() {
		return listAddresssaves!=null?listAddresssaves.size():0;
	}

	@Override
	public Object getItem(int position) {
		return listAddresssaves.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View view = View.inflate(context, R.layout.item_address_layout, null);
		TextView name = (TextView) view.findViewById(R.id.name_tv);
		TextView tel = (TextView) view.findViewById(R.id.tel_tv);
		TextView address = (TextView) view.findViewById(R.id.tv_xiangqing);
		
		
		name.setText(listAddresssaves.get(position).getName());
		tel.setText(listAddresssaves.get(position).getPhonenumber());
		address.setText(listAddresssaves.get(position).getAreaid()+listAddresssaves.get(position).getAreadetail());
		return view;
	}

}
