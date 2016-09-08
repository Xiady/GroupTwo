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

	private String[] group = { "��������", "������ʷ" };
	private String[][] child = { { "¶����", "�и�װ", "��¹�̷�" },
			{ "����װ", "��ͯ�̷�", "����" } };

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = View.inflate(getActivity(), R.layout.fragment_search, null);
		// �ҿؼ�
		initView();
		// �����������ݲ���
		initData();

		return view;
	}

	/**
	 * �����������ݲ��ҡ�������ť���
	 */
	private void initData() {
		search_goods = et_search_goods.getText().toString().trim();
		// ��ť���
		img_search_sure.setOnClickListener(this);
	}

	/**
	 * �ҿؼ�����
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
			// ��ת��չʾ����
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
		 * ��ȡ����Ŀ
		 */
		@Override
		public Object getChild(int groupPosition, int childPosition) {
			// TODO Auto-generated method stub
			return child[groupPosition][childPosition];
		}

		/**
		 * ��ȡ����Ŀ��id
		 */
		@Override
		public long getChildId(int groupPosition, int childPosition) {
			// TODO Auto-generated method stub
			return childPosition;
		}

		/**
		 * ��ȡ����Ŀ��ͼ
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
		 * ��ȡ����Ŀ����Ŀ
		 */
		@Override
		public int getChildrenCount(int groupPosition) {
			// TODO Auto-generated method stub
			// return child.length;
			return child[groupPosition].length;
		}

		/**
		 * ��ȡһ���б�
		 */
		@Override
		public Object getGroup(int groupPosition) {
			// TODO Auto-generated method stub
			return group[groupPosition];
		}

		/**
		 * ��ȡһ���б����Ŀ
		 */
		@Override
		public int getGroupCount() {
			// TODO Auto-generated method stub
			return group.length;
		}

		/**
		 * ��ȡһ���б��id
		 */
		@Override
		public long getGroupId(int groupPosition) {
			// TODO Auto-generated method stub
			return groupPosition;
		}

		/**
		 * ��ȡһ���б����ͼ
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
		 * id�Ƿ�Ϊ�ɱ��
		 */
		@Override
		public boolean hasStableIds() {
			// TODO Auto-generated method stub
			return true;
		}

		/**
		 * ����Ŀ�Ƿ���Ե��
		 */
		@Override
		public boolean isChildSelectable(int groupPosition, int childPosition) {
			// TODO Auto-generated method stub
			return true;
		}

	}

}
