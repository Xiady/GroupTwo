package com.number2.redbaby.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.number2.redbaby.Cart_payActivity;
import com.number2.redbaby.R;
import com.number2.redbaby.adapter.MyAddCartAdapter;
import com.number2.redbaby.bean.CartProduct;

public class Fragment_addcart extends Fragment implements OnClickListener {
	private ListView addcart_listView;
	private TextView addcart_money;
	private TextView addcart_num;
	private TextView addcart_total;
	private Button addcart_edit;
	private Button addcart_account;
	private Button pay_put;
	private TextView pay_address;
	private TextView pay_cuxiao;
	private TextView pay_money;
	private TextView pay_num;
	private TextView pay_paytype;
	private TextView pay_time;
	private TextView pay_type;
	private TextView pay_yingfu;
	private TextView pay_yunfei;
	private List<CartProduct> list;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = View
				.inflate(getActivity(), R.layout.fregment_addcart, null);

		findView(view);
		setclick();
		// 获取购物车数据
		getdata();
		
		//
		return view;
	}

	private void setclick() {
		addcart_account.setOnClickListener(this);

	}

	/*
	 * 找控件
	 */
	private void findView(View view) {
		addcart_listView = (ListView) view.findViewById(R.id.addcart_list);
		addcart_money = (TextView) view.findViewById(R.id.addcart_money);
		addcart_num = (TextView) view.findViewById(R.id.addcart_num);
		addcart_total = (TextView) view.findViewById(R.id.addcart_total);
		addcart_edit = (Button) view.findViewById(R.id.cart_button_edit);
		addcart_account = (Button) view.findViewById(R.id.cart_button_account);

	}

	/*
	 * 获取数据(购物车)
	 */
	private void getdata() {

		RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

		StringRequest stringRequest = new StringRequest(
				"http://121.42.8.95:8090/ECServer_D/cart",
				new Response.Listener<String>() {
					

					@Override
					public void onResponse(String response) {
						Gson gson = new Gson();
						list = new ArrayList<CartProduct>();
						CartProduct cartProduct1=new CartProduct("1000", "商品1", "100", "1000", "红色", "L");
						CartProduct cartProduct2=new CartProduct("1000", "商品2", "100", "1000", "红色", "L");
						CartProduct cartProduct3=new CartProduct("1000", "商品3", "100", "1000", "红色", "L");
						CartProduct cartProduct4=new CartProduct("1000", "商品4", "100", "1000", "红色", "L");
						CartProduct cartProduct5=new CartProduct("1000", "商品5", "100", "1000", "红色", "L");
						list.add(cartProduct1);
						list.add(cartProduct2);
						list.add(cartProduct3);
						list.add(cartProduct4);
						list.add(cartProduct5);
						addcart_listView.setAdapter(new MyAddCartAdapter(
								getActivity(), list));
						setdata(list);

					}

					
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
					}
				});

		requestQueue.add(stringRequest);

	}
	/*
	 * 设置值
	 */
	private void setdata(List<CartProduct> list2) {
		
	}
	

	/*
	 * 点击监听(non-Javadoc)
	 * 
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		// 去结算
		case R.id.cart_button_account:
			startActivity(new Intent(getActivity(), Cart_payActivity.class));
			break;
		// 编辑
		case R.id.cart_button_edit:

			break;

		}
	}

}
