package com.number2.redbaby;

import com.number2.redbaby.fragment.Fragment_cart;
import com.number2.redbaby.fragment.Fragment_more;
import com.number2.redbaby.fragment.Fragment_pai;
import com.number2.redbaby.fragment.Fragment_search;
import com.number2.redbaby.fragment.Fragment_shou;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.RadioButton;

public class HomeActivity extends FragmentActivity implements OnClickListener {

	private RadioButton button_cart;
	private RadioButton button_more;
	private RadioButton button_home;
	private RadioButton button_pai;
	private RadioButton button_search;
	private Fragment_shou shou;
	private Fragment_cart cart;
	private Fragment_more more;
	private Fragment_pai pai;
	private Fragment_search search;
	public static FragmentManager manager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		findView();

		initEvent();

		button_home.setBackgroundResource(R.drawable.bar_home_selected);
		button_cart.setBackgroundResource(R.drawable.bar_shopping_normal);
		button_pai.setBackgroundResource(R.drawable.bar_class_normal);
		button_search.setBackgroundResource(R.drawable.bar_search_normal);
		button_more.setBackgroundResource(R.drawable.bar_more_normal);

	}

	private void initEvent() {
		manager = getSupportFragmentManager();
		final FragmentTransaction transaction = manager.beginTransaction();

		shou = new Fragment_shou();
		cart = new Fragment_cart();
		more = new Fragment_more();
		pai = new Fragment_pai();
		search = new Fragment_search();

		transaction.add(R.id.home_fr, shou, "shou");
		transaction.add(R.id.home_fr, cart, "cart");
		transaction.add(R.id.home_fr, more, "more");
		transaction.add(R.id.home_fr, pai, "pai");
		transaction.add(R.id.home_fr, search, "search");
		switchTag("shou");

		transaction.commit();
	}

	private void switchTag(String tag) {
		FragmentTransaction transaction = manager.beginTransaction();
		if (tag.equals("shou")) {
			transaction.show(shou);
			transaction.hide(cart);
			transaction.hide(more);
			transaction.hide(pai);
			transaction.hide(search);

		} else if (tag.equals("cart")) {
			transaction.show(cart);
			transaction.hide(shou);
			transaction.hide(more);
			transaction.hide(pai);
			transaction.hide(search);

		} else if (tag.equals("more")) {
			transaction.show(more);
			transaction.hide(shou);
			transaction.hide(cart);
			transaction.hide(pai);
			transaction.hide(search);
		} else if (tag.equals("pai")) {
			transaction.show(pai);
			transaction.hide(shou);
			transaction.hide(more);
			transaction.hide(cart);
			transaction.hide(search);
		} else if (tag.equals("search")) {
			transaction.show(search);
			transaction.hide(shou);
			transaction.hide(more);
			transaction.hide(cart);
			transaction.hide(pai);
		}
		transaction.commit();
	}

	private void findView() {
		button_cart = (RadioButton) findViewById(R.id.home_radio_cart);
		button_more = (RadioButton) findViewById(R.id.home_radio_more);
		button_home = (RadioButton) findViewById(R.id.home_radio_shou);
		button_pai = (RadioButton) findViewById(R.id.home_radio_pai);
		button_search = (RadioButton) findViewById(R.id.home_radio_search);

		button_cart.setOnClickListener(this);
		button_more.setOnClickListener(this);
		button_home.setOnClickListener(this);
		button_pai.setOnClickListener(this);
		button_search.setOnClickListener(this);

	}

	/*
	 * µã»÷¼àÌý(non-Javadoc)
	 * 
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.home_radio_shou:

			switchTag("shou");
			button_home.setBackgroundResource(R.drawable.bar_home_selected);
			button_cart.setBackgroundResource(R.drawable.bar_shopping_normal);
			button_pai.setBackgroundResource(R.drawable.bar_class_normal);
			button_search.setBackgroundResource(R.drawable.bar_search_normal);
			button_more.setBackgroundResource(R.drawable.bar_more_normal);

			break;
		case R.id.home_radio_cart:
			switchTag("cart");

			button_home.setBackgroundResource(R.drawable.bar_home_normal);
			button_cart.setBackgroundResource(R.drawable.bar_shopping_selected);
			button_pai.setBackgroundResource(R.drawable.bar_class_normal);
			button_search.setBackgroundResource(R.drawable.bar_search_normal);
			button_more.setBackgroundResource(R.drawable.bar_more_normal);

			break;
		case R.id.home_radio_more:
			switchTag("more");

			button_home.setBackgroundResource(R.drawable.bar_home_normal);
			button_cart.setBackgroundResource(R.drawable.bar_shopping_normal);
			button_pai.setBackgroundResource(R.drawable.bar_class_normal);
			button_search.setBackgroundResource(R.drawable.bar_search_normal);
			button_more.setBackgroundResource(R.drawable.bar_more_selected);

			break;
		case R.id.home_radio_search:

			switchTag("search");

			button_home.setBackgroundResource(R.drawable.bar_home_normal);
			button_cart.setBackgroundResource(R.drawable.bar_shopping_normal);
			button_pai.setBackgroundResource(R.drawable.bar_class_normal);
			button_search.setBackgroundResource(R.drawable.bar_search_selected);
			button_more.setBackgroundResource(R.drawable.bar_more_normal);
			break;
		case R.id.home_radio_pai:
			switchTag("pai");

			button_home.setBackgroundResource(R.drawable.bar_home_normal);
			button_cart.setBackgroundResource(R.drawable.bar_shopping_normal);
			button_pai.setBackgroundResource(R.drawable.bar_class_selected);
			button_search.setBackgroundResource(R.drawable.bar_search_normal);
			button_more.setBackgroundResource(R.drawable.bar_more_normal);

			break;

		}
	}

}
