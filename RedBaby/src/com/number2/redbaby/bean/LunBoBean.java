package com.number2.redbaby.bean;

import java.util.List;

public class LunBoBean {
	public List<Home> home_banner;

	public class Home {
		public int id;
		public String pic;
		public String title;
	}

	@Override
	public String toString() {
		return "LunBoBean [home_banner=" + home_banner + "]";
	}

}
