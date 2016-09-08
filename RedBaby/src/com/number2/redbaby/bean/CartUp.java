package com.number2.redbaby.bean;

public class CartUp {
	private String total_count;
	private String total_point;
	private String total_price;

	@Override
	public String toString() {
		return "CartUp [total_count=" + total_count + ", total_point="
				+ total_point + ", total_price=" + total_price + "]";
	}

	public String getTotal_count() {
		return total_count;
	}

	public void setTotal_count(String total_count) {
		this.total_count = total_count;
	}

	public String getTotal_point() {
		return total_point;
	}

	public void setTotal_point(String total_point) {
		this.total_point = total_point;
	}

	public String getTotal_price() {
		return total_price;
	}

	public void setTotal_price(String total_price) {
		this.total_price = total_price;
	}

	public CartUp(String total_count, String total_point, String total_price) {
		super();
		this.total_count = total_count;
		this.total_point = total_point;
		this.total_price = total_price;
	}

	public CartUp() {
		super();
	}

}
