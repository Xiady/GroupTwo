package com.number2.redbaby;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.utils.URIUtils;

import com.number2.redbaby.app.MyApplication;
import com.number2.redbaby.bean.Addresssave;
import com.number2.redbaby.utils.HttpUtil;
import com.number2.redbaby.utils.HttpUtil.RequestListener;
import com.number2.redbaby.utils.URLUtils;

import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AddAddressActivity extends Activity implements OnClickListener {

	private EditText mNameEdit;
	private EditText mMobileEdit;
	@SuppressWarnings("unused")
	private EditText mTelEdit, address_cityid, address_detail;
	private EditText mDetailEdit;
	private EditText mZipcodeEdit;
	private HttpUtil mHttpUtil;
	private String name;
	private String phonenumber;
	private String fixedtel;
	private String provinceid;
	private String cityid;
	private String areadetail;
	private String zipcode;
	private LoginActivity activity;
	private List<Addresssave> listAddresssaves;
	private Addresssave addresssave;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_address);
		initView();
		mHttpUtil = new HttpUtil();
 
		listAddresssaves = MyApplication.getListAddresssaves();
	}

	private void initView() {
		// 返回
		TextView mCallBackIm = (TextView) findViewById(R.id.callBackIm);
		mCallBackIm.setOnClickListener(this);


		mNameEdit = (EditText) findViewById(R.id.add_address_name_edit);
		mMobileEdit = (EditText) findViewById(R.id.add_address_phonenumber_edit);
		mTelEdit = (EditText) findViewById(R.id.add_address_fixedtel_edit);
		mDetailEdit = (EditText) findViewById(R.id.add_address_provinceid_edit);
		address_cityid = (EditText) findViewById(R.id.add_address_cityid_edit);
		address_detail = (EditText) findViewById(R.id.add_address_detail_edit);
		mZipcodeEdit = (EditText) findViewById(R.id.add_address_zipcode_edit);

		// 保存
		findViewById(R.id.save_address_button).setOnClickListener(this);
		// 取消
		findViewById(R.id.cancel_address_button).setOnClickListener(this);


	}

	/**
	 * 
	 * 得到输入框的值
	 */
	private void getEditTextData() {

		name = mNameEdit.getText().toString();
		phonenumber = mMobileEdit.getText().toString();
		fixedtel = mTelEdit.getText().toString();
		provinceid = mDetailEdit.getText().toString();
		cityid = address_cityid.getText().toString();
		areadetail = address_detail.getText().toString();
		zipcode = mZipcodeEdit.getText().toString();

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// 返回
		case R.id.callBackIm:
			onBackPressed();
			overridePendingTransition(R.anim.from_left, R.anim.from_right);
			break;
		// 保存
		case R.id.save_address_button:

			name = mNameEdit.getText().toString();
			phonenumber = mMobileEdit.getText().toString();
			fixedtel = mTelEdit.getText().toString();
			provinceid = mDetailEdit.getText().toString();
			cityid = address_cityid.getText().toString();
			areadetail = address_detail.getText().toString();
			zipcode = mZipcodeEdit.getText().toString();
//			Toast.makeText(
//					AddAddressActivity.this,
//					name + phonenumber + fixedtel + provinceid + cityid
//							+ areadetail + zipcode, 0).show();
			addresssave = new Addresssave("1", name, phonenumber,
					fixedtel, provinceid, cityid, cityid + areadetail,
					areadetail, zipcode);
			listAddresssaves.add(addresssave);
			Log.i("TAG", listAddresssaves + "");
			finish();

			break;
		// 取消
		case R.id.cancel_address_button:
			finish();
			break;
		}
	}

	public List<Addresssave> getListAddresssaves() {
		return listAddresssaves;
	}

	public void setListAddresssaves(List<Addresssave> listAddresssaves) {
		this.listAddresssaves = listAddresssaves;
	}

	/**
	 * 返回上一级
	 */
	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}

}
