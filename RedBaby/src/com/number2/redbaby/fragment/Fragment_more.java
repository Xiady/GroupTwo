package com.number2.redbaby.fragment;

import com.number2.redbaby.AboutActivity;
import com.number2.redbaby.HelpCentreActivity;
import com.number2.redbaby.LoginActivity;
import com.number2.redbaby.MyAccountActivity;
import com.number2.redbaby.R;
import com.number2.redbaby.RecentlyActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class Fragment_more extends Fragment implements OnClickListener {

	String[] data = new String[] { "我的账户", "最近浏览", "登录", "帮助中心", "关于" };
	private View mView;
	private ListView mLv;
	private RelativeLayout my_account_zh;
	private RelativeLayout recent_browse_zjll;
	private RelativeLayout login_text;
	private RelativeLayout helpRelLay_text;
	private RelativeLayout aboutRelLay;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mView = View.inflate(getActivity(), R.layout.fregment_more, null);
		initView();
		return mView;
	}

	private void initView() {
		// 我的账户
		my_account_zh = (RelativeLayout) mView.findViewById(R.id.my_account_zh);
		my_account_zh.setOnClickListener(this);
		// 最近浏览
		recent_browse_zjll = (RelativeLayout) mView
				.findViewById(R.id.recent_browse_zjll);
		recent_browse_zjll.setOnClickListener(this);
		// 登录
		login_text = (RelativeLayout) mView.findViewById(R.id.login_text);
		login_text.setOnClickListener(this);
		// 帮助中心
		helpRelLay_text = (RelativeLayout) mView
				.findViewById(R.id.helpRelLay_text);
		helpRelLay_text.setOnClickListener(this);
		// 关于
		aboutRelLay = (RelativeLayout) mView.findViewById(R.id.aboutRelLay);
		aboutRelLay.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.my_account_zh:
			startActivity(new Intent(getActivity(), MyAccountActivity.class));
			getActivity().overridePendingTransition(R.anim.in_from_right,
					R.anim.in_from_left);
			break;
		case R.id.recent_browse_zjll:
			startActivity(new Intent(getActivity(), RecentlyActivity.class));
			getActivity().overridePendingTransition(R.anim.in_from_right,
					R.anim.in_from_left);
			break;
		case R.id.login_text:
			startActivity(new Intent(getActivity(), LoginActivity.class));
			getActivity().overridePendingTransition(R.anim.in_from_right,
					R.anim.in_from_left);
			break;
		case R.id.helpRelLay_text:
			startActivity(new Intent(getActivity(), HelpCentreActivity.class));
			getActivity().overridePendingTransition(R.anim.in_from_right,
					R.anim.in_from_left);
			break;
		case R.id.aboutRelLay:
			startActivity(new Intent(getActivity(), AboutActivity.class));
			getActivity().overridePendingTransition(R.anim.in_from_right,
					R.anim.in_from_left);
			break;

		}
	}

}
