package com.number2.redbaby.bean;

public class Addresssave {

	// "id": "1001", //��ַ��ID
	// "name": "Ф��", //�ջ�������
	// "phonenumber": "15801477821", //�ֻ�����
	// "fixedtel":"010-88496666" //�̶��绰
	// "provinceid": "102", //ʡID
	// "cityid": "10203", //��ID
	// "areaid": "1020304", //����ID
	// "areadetail": "��ׯ·3��", //������ַ
	// "zipcode": "100195",

	private String id;// ��ַ��ID
	private String name;// �ջ�������
	private String phonenumber;// �ֻ�����
	private String fixedtel;// �̶��绰
	private String provinceid;// ʡID
	private String cityid;// ��ID
	private String areaid;// ����ID
	private String areadetail;// ������ַ
	private String zipcode;// �ʱ�

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
