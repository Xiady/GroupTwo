package com.number2.redbaby.fragment;

import com.number2.redbaby.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class Fragment_cart extends Fragment {

	int userID = 30505;

	// int userID=0;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = View.inflate(getActivity(), R.layout.fregment_cart, null);
		/*
		 * ÅÐ¶ÏÊÇ·ñµÇÂ¼
		 */
		if (userID != 0) {
			Fragment_addcart addcart = new Fragment_addcart();
			getActivity().getSupportFragmentManager().beginTransaction()
					.replace(R.id.cart_fr, addcart, "add").commit();
		} else// Ã»ÓÐµÇÂ¼
		{
			Fragment_nocart nocart = new Fragment_nocart();
			getActivity().getSupportFragmentManager().beginTransaction()
					.replace(R.id.cart_fr, nocart, "no").commit();
			Toast.makeText(getActivity(), "ÇëµÇÂ¼£¡", Toast.LENGTH_SHORT).show();
		}

		return view;
	}
}
