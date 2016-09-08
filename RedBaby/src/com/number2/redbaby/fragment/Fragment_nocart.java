package com.number2.redbaby.fragment;

import com.number2.redbaby.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment_nocart extends Fragment {
	private Button nocart_back;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = View
				.inflate(getActivity(), R.layout.fregment_nocart_, null);

		return view;
	}

}
