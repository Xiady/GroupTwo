package com.number2.redbaby.bean;

public class CartProduct {

	private String id;
	private String name;
	private String pic;
	private String price;
	private String color;
	private String size;

	@Override
	public String toString() {
		return "CartProduct [id=" + id + ", name=" + name + ", pic=" + pic
				+ ", price=" + price + ", color=" + color + ", size=" + size
				+ "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public CartProduct(String id, String name, String pic, String price,
			String color, String size) {
		super();
		this.id = id;
		this.name = name;
		this.pic = pic;
		this.price = price;
		this.color = color;
		this.size = size;
	}

	public CartProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

}
