package com.number2.redbaby.bean;

public class Addresssave {

	// "id": "1001", //地址簿ID
	// "name": "肖文", //收货人姓名
	// "phonenumber": "15801477821", //手机号码
	// "fixedtel":"010-88496666" //固定电话
	// "provinceid": "102", //省ID
	// "cityid": "10203", //市ID
	// "areaid": "1020304", //地区ID
	// "areadetail": "闵庄路3号", //订单地址
	// "zipcode": "100195",

	private String id;// 地址簿ID
	private String name;// 收货人姓名
	private String phonenumber;// 手机号码
	private String fixedtel;// 固定电话
	private String provinceid;// 省ID
	private String cityid;// 市ID
	private String areaid;// 地区ID
	private String areadetail;// 订单地址
	private String zipcode;// 邮编

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

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getFixedtel() {
		return fixedtel;
	}

	public void setFixedtel(String fixedtel) {
		this.fixedtel = fixedtel;
	}

	public String getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getAreaid() {
		return areaid;
	}

	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}

	public String getAreadetail() {
		return areadetail;
	}

	public void setAreadetail(String areadetail) {
		this.areadetail = areadetail;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Addresssave [id=" + id + ", name=" + name + ", phonenumber="
				+ phonenumber + ", fixedtel=" + fixedtel + ", provinceid="
				+ provinceid + ", cityid=" + cityid + ", areaid=" + areaid
				+ ", areadetail=" + areadetail + ", zipcode=" + zipcode + "]";
	}

	public Addresssave() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Addresssave(String id, String name, String phonenumber,
			String fixedtel, String provinceid, String cityid, String areaid,
			String areadetail, String zipcode) {
		super();
		this.id = id;
		this.name = name;
		this.phonenumber = phonenumber;
		this.fixedtel = fixedtel;
		this.provinceid = provinceid;
		this.cityid = cityid;
		this.areaid = areaid;
		this.areadetail = areadetail;
		this.zipcode = zipcode;
	}

}
