package com.number2.redbaby.adapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.content.Context;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.number2.redbaby.R;
import com.number2.redbaby.bean.BabyBean.Productlist;
import com.squareup.picasso.Picasso;

public class MyXianShiAdapter extends BaseAdapter {

	Context context;
	List<Productlist> productlist;
	private long t;

	public MyXianShiAdapter(Context context, List<Productlist> productlist) {
		this.context = context;
		this.productlist = productlist;
	}

	@Override
	public int getCount() {
		return productlist.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@SuppressWarnings("deprecation")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder viewHolder;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = View.inflate(context, R.layout.xianshi_item, null);
			viewHolder.xianshi_pic = (ImageView) convertView
					.findViewById(R.id.xianshi_pic);
			viewHolder.xianshi_name = (TextView) convertView
					.findViewById(R.id.xianshi_name);
			viewHolder.xianshi_price = (TextView) convertView
					.findViewById(R.id.xianshi_price);
			viewHolder.xianshi_limitprice = (TextView) convertView
					.findViewById(R.id.xianshi_limitprice);
			viewHolder.xianshi_lefttime = (TextView) convertView
					.findViewById(R.id.xianshi_lefttime);
			viewHolder.xianshi_qianggou = (Button) convertView
					.findViewById(R.id.xianshi_qianggou);

			convertView.setTag(viewHolder);

		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		Picasso.with(context).load(productlist.get(position).pic)
				.into(viewHolder.xianshi_pic);
		viewHolder.xianshi_name.setText(productlist.get(position).name);
		viewHolder.xianshi_price.setText("￥" + productlist.get(position).price
				+ "");
		// 加横线
		viewHolder.xianshi_price.getPaint().setFlags(
				Paint.STRIKE_THRU_TEXT_FLAG);
		viewHolder.xianshi_limitprice.setText("限时特价:"
				+ productlist.get(position).limitprice + "");

		// 系统当前时间
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String time = dateFormat.format(date);
		// 把系统当前时间转换为long类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date d = sdf.parse(time);
			Log.i("TAG", "time++++++++++" + time);

			t = d.getTime();
			Log.i("TAG", "t++++++++++" + t);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		long lefttime = productlist.get(position).lefttime;
		// 两个long类型相减
		long tt = lefttime - t;
		Log.i("TAG", "tt++++++++++" + tt);
		Date date2 = new Date(tt);
		SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
		String time2 = sdf1.format(date2);
		Log.i("TAG", "转换后的时间" + time2);
		viewHolder.xianshi_lefttime.setText("剩余时间:" + time2);

		return convertView;
	}

	class ViewHolder {
		ImageView xianshi_pic;
		TextView xianshi_name;
		TextView xianshi_price;
		TextView xianshi_limitprice;
		TextView xianshi_lefttime;
		Button xianshi_qianggou;
	}

}
