package com.foodtruck.vo;

public class ReviewVO {
	
	private int revSeq;
	private String ftruckNo;
	private String revContent;
	private String revDtm;
	private String revDelYn;
	private double grade;
	private String memId;
	public int getRevSeq() {
		return revSeq;
	}
	public void setRevSeq(int revSeq) {
		this.revSeq = revSeq;
	}
	public String getFtruckNo() {
		return ftruckNo;
	}
	public void setFtruckNo(String ftruckNo) {
		this.ftruckNo = ftruckNo;
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
