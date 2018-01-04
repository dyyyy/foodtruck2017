package com.foodtruck.vo;

public class OrderDetailVO {

	private String prodNo; 	 // 제품 번호
	private String ordNo; 		 // 주문 번호
	private String prodName; // 제품 이름
	private int ordQty; 	 // 수량
	private int ordPrice; 	 // 주문가격
	private String memId; 	 // 판매자 아이디

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

	public String getOrdNo() {
		return ordNo;
	}

	public void setOrdNo(String ordNo) {
		this.ordNo = ordNo;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getOrdQty() {
		return ordQty;
	}

	public void setOrdQty(int ordQty) {
		this.ordQty = ordQty;
	}

	public int getOrdPrice() {
		return ordPrice;
	}

	public void setOrdPrice(int ordPrice) {
		this.ordPrice = ordPrice;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}
	
}
