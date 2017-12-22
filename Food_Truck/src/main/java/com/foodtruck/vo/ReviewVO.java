package com.foodtruck.vo;

public class ReviewVO {
	private String licenseNo;
	private int revSeq;
	private String revContent;
	private String revDtm;
	private String revDelYn;
	private double grade;
	private String memId;
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public int getRevSeq() {
		return revSeq;
	}
	public void setRevSeq(int revSeq) {
		this.revSeq = revSeq;
	}
	public String getRevContent() {
		return revContent;
	}
	public void setRevContent(String revContent) {
		this.revContent = revContent;
	}
	public String getRevDtm() {
		return revDtm;
	}
	public void setRevDtm(String revDtm) {
		this.revDtm = revDtm;
	}
	public String getRevDelYn() {
		return revDelYn;
	}
	public void setRevDelYn(String revDelYn) {
		this.revDelYn = revDelYn;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	
	
}
