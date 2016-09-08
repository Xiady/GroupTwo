package com.number2.redbaby.adapter;

import java.util.List;

import com.number2.redbaby.R;
import com.number2.redbaby.bean.BabyBean.Topic;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

public class MyCuXiaoiAdapter extends BaseAdapter implements ListAdapter {

	Context context;
	List<Topic> topiclist;

	public MyCuXiaoiAdapter(Context context, List<Topic> topiclist) {
		this.context = context;
		this.topiclist = topiclist;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return topiclist.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if (convertView == null) {
			convertView = View.inflate(context, R.layout.cuxiao_item, null);
			viewHolder = new ViewHolder();

			viewHolder.cuxiao_name = (TextView) convertView
					.findViewById(R.id.cuxiao_name);
			viewHolder.cuxiao_pic = (ImageView) convertView
					.findViewById(R.id.cuxiao_pic);

			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		Picasso.with(context).load(topiclist.get(position).pic)
				.into(viewHolder.cuxiao_pic);
		viewHolder.cuxiao_name.setText(topiclist.get(position).name);
		return convertView;
	}

	class ViewHolder {
		ImageView cuxiao_pic;
		TextView cuxiao_name;
	}

}
