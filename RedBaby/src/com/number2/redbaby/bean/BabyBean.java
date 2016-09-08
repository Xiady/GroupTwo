package com.number2.redbaby.bean;

import java.util.List;

public class BabyBean {
	public List<Productlist> productlist;

	public class Productlist {
		public int id;
		public long lefttime;
		public int limitprice;
		public int price;
		public String pic;
		public String name;

		@Override
		public String toString() {
			return "Productlist [id=" + id + ", lefttime=" + lefttime + ", limitprice=" + limitprice + ", price=" + price + ", pic=" + pic
					+ ", name=" + name + "]";
		}

	}

	@Override
	public String toString() {
		return "BabyBean [productlist=" + productlist + "]";
	}

	public List<Topic> topic;

	public class Topic {
		public int id;
		public String pic;
		public String name;

	}

	public List<Brand> brand;

	public class Brand {
		public String key;
		public List<Value> value;

		public class Value {
			public int id;
			public String pic;
			public String name;
		}
	}
}
