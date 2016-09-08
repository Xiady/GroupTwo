package com.number2.redbaby.app;

import java.util.ArrayList;
import java.util.List;

import com.number2.redbaby.bean.Addresssave;

import android.app.Application;

public class MyApplication extends Application {

	public static String sessionid;
	public static String getSessionid() {
		return sessionid;
	}

	public static void setSessionid(String sessionid) {
		MyApplication.sessionid = sessionid;
	}

	public static List<Addresssave> listAddresssaves;

	public static List<Addresssave> getListAddresssaves() {
		return listAddresssaves;
	}

	public void setListAddresssaves(List<Addresssave> listAddresssaves) {
		MyApplication.listAddresssaves = listAddresssaves;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		listAddresssaves=new ArrayList<Addresssave>();
	}

}
