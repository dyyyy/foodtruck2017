package com.foodtruck.vo;

public class SellerVO {
	
	private String selId;		// 판매자 아이디
	private String selPw;		// 판매자 비밀번호
	private String selName;		// 판매자 이름
	private String selTel;		// 판매자 연락처
	private String licenseNo;	// 사업자 번호
	
	// getter & setter
	public String getSelId() {
		return selId;
	}
	public void setSelId(String selId) {
		this.selId = selId;
	}
	public String getSelPw() {
		return selPw;
	}
	public void setSelPw(String selPw) {
		this.selPw = selPw;
	}
	public String getSelName() {
		return selName;
	}
	public void setSelName(String selName) {
		this.selName = selName;
	}
	public String getSelTel() {
		return selTel;
	}
	public void setSelTel(String selTel) {
		this.selTel = selTel;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
}
