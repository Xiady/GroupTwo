package com.number2.redbaby.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.number2.redbaby.R;
import com.number2.redbaby.SearchItemActivity;

public class Fragment_search extends Fragment implements OnClickListener {

	private View view;
	private EditText et_search_goods;
	private ImageView img_search_sure;
	private ExpandableListView expandableListView;
	private String search_goods;

	private String[] group = { "热门搜索", "搜索历史" };
	private String[][] child = { { "露的清", "孕妇装", "三鹿奶粉" },
			{ "父子装", "儿童奶粉", "雅培" } };

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = View.inflate(getActivity(), R.layout.fragment_search, null);
		// 找控件
		initView();
		// 根据输入内容查找
		initData();

		return view;
	}

	/**
	 * 根据输入内容查找、搜索按钮点击
	 */
	private void initData() {
		search_goods = et_search_goods.getText().toString().trim();
		// 按钮点击
		img_search_sure.setOnClickListener(this);
	}

	/**
	 * 找控件方法
	 */
	private void initView() {
		et_search_goods = (EditText) view.findViewById(R.id.et_search_goods);
		img_search_sure = (ImageView) view.findViewById(R.id.img_search_sure);
		expandableListView = (ExpandableListView) view
				.findViewById(R.id.expandableListView);

		expandableListView.setAdapter(new MyAdapter());

	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.img_search_sure:
			// 跳转到展示界面
			Intent intent = new Intent(getActivity(), SearchItemActivity.class);
			intent.putExtra("goods", search_goods);

			startActivity(intent);

			break;

		default:
			break;
		}

	}

	class MyAdapter extends BaseExpandableListAdapter {
		/**
		 * 获取子条目
		 */
		@Override
		public Object getChild(int groupPosition, int childPosition) {
			// TODO Auto-generated method stub
			return child[groupPosition][childPosition];
		}

		/**
		 * 获取子条目的id
		 */
		@Override
		public long getChildId(int groupPosition, int childPosition) {
			// TODO Auto-generated method stub
			return childPosition;
		}

		/**
		 * 获取子条目视图
		 */
		@Override
		public View getChildView(int groupPosition, int childPosition,
				boolean isLastChild, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub

			convertView = View
					.inflate(getActivity(), R.layout.child_item, null);

			TextView child_tv = (TextView) convertView
					.findViewById(R.id.child_tv);

			child_tv.setText(child[groupPosition][childPosition]);

			return convertView;
		}

		/**
		 * 获取子条目的数目
		 */
		@Override
		public int getChildrenCount(int groupPosition) {
			// TODO Auto-generated method stub
			// return child.length;
			return child[groupPosition].length;
		}

		/**
		 * 获取一级列表
		 */
		@Override
		public Object getGroup(int groupPosition) {
			// TODO Auto-generated method stub
			return group[groupPosition];
		}

		/**
		 * 获取一级列表的数目
		 */
		@Override
		public int getGroupCount() {
			// TODO Auto-generated method stub
			return group.length;
		}

		/**
		 * 获取一级列表的id
		 */
		@Override
		public long getGroupId(int groupPosition) {
			// TODO Auto-generated method stub
			return groupPosition;
		}

		/**
		 * 获取一级列表的视图
		 */
		@Override
		public View getGroupView(int groupPosition, boolean isExpanded,
				View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			convertView = View
					.inflate(getActivity(), R.layout.group_item, null);

			TextView group_tv = (TextView) convertView
					.findViewById(R.id.group_tv);

			group_tv.setText(group[groupPosition]);

			return convertView;
		}

		/**
		 * id是否为可变的
		 */
		@Override
		public boolean hasStableIds() {
			// TODO Auto-generated method stub
			return true;
		}

		/**
		 * 子条目是否可以点击
		 */
		@Override
		public boolean isChildSelectable(int groupPosition, int childPosition) {
			// TODO Auto-generated method stub
			return true;
		}

	}

}
