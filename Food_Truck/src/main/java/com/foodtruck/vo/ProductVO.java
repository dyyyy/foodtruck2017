
package com.foodtruck.vo;

public class ProductVO {
	
	private String prodNo;				// 제품 번호
	private String prodName;		// 제품 이름
	private String prodContent;		// 제품 내용
	private String prodImg;			// 제품 이미지
	private int prodPrice;			// 금액
	private String licenseNo;		// 사업자 번호
	
	// getter & setter
	
	public String getProdName() {
		return prodName;
	}
	public String getProdNo() {
		return prodNo;
	}
	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdContent() {
		return prodContent;
	}
	public void setProdContent(String prodContent) {
		this.prodContent = prodContent;
	}
	public String getProdImg() {
		return prodImg;
	}
	public void setProdImg(String prodImg) {
		this.prodImg = prodImg;
	}
	public int getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
}

