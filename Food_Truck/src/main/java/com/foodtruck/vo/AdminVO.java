package com.foodtruck.vo;

public class AdminVO {

	private String adminId;		// 관리자 아이디
	private String adminPw;		// 관리자 비밀번호
	private String adminTel;	// 관리자 전화번호
	
	// getter & setter
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPw() {
		return adminPw;
	}
	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}
	public String getAdminTel() {
		return adminTel;
	}
	public void setAdminTel(String adminTel) {
		this.adminTel = adminTel;
	}
}
