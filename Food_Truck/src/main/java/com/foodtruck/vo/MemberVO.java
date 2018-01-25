package com.foodtruck.vo;

public class MemberVO extends LicenseVO{
	//private String licenseNo;
	private String memberId;	// ȸ�� ���̵�
	private String memberName;	// ȸ�� �̸�
	private String memberPw;	// ȸ�� ��й�ȣ
	private String memberTel;	// ȸ�� ��ȭ��ȣ
	private String memberAuth;		// ȸ�� ����
	
	// getter & setter
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberTel() {
		return memberTel;
	}
	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}
	public String getMemberAuth() {
		return memberAuth;
	}
	public void setMemberAuth(String memberAuth) {
		this.memberAuth = memberAuth;
	}
	
	

}
