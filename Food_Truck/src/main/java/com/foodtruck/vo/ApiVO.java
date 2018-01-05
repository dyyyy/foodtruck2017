package com.foodtruck.vo;
//최초 api를 가져오는 VO입니다.
public class ApiVO {
	private String bplcNm;//사업장명
	private String siteTel;//전화번호
	private String rdnWhlAddr;//도로명주소
	private String siteWhlAddr;//구주소
	private String apvPermYmd;//푸드트럭 등록일
	private String dtlStateNm;//영업상태
	private String x;//위도
	private String y;//경도
	
	
	public String getBplcNm() {
		return bplcNm;
	}
	public void setBplcNm(String bplcNm) {
		this.bplcNm = bplcNm;
	}
	public String getSiteTel() {
		return siteTel;
	}
	public void setSiteTel(String siteTel) {
		this.siteTel = siteTel;
	}
	public String getRdnWhlAddr() {
		return rdnWhlAddr;
	}
	public void setRdnWhlAddr(String rdnWhlAddr) {
		this.rdnWhlAddr = rdnWhlAddr;
	}
	public String getSiteWhlAddr() {
		return siteWhlAddr;
	}
	public void setSiteWhlAddr(String siteWhlAddr) {
		this.siteWhlAddr = siteWhlAddr;
	}
	public String getApvPermYmd() {
		return apvPermYmd;
	}
	public void setApvPermYmd(String apvPermYmd) {
		this.apvPermYmd = apvPermYmd;
	}
	public String getDtlStateNm() {
		return dtlStateNm;
	}
	public void setDtlStateNm(String dtlStateNm) {
		this.dtlStateNm = dtlStateNm;
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	
	
}
