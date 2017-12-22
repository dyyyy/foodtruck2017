package com.foodtruck.vo;

public class OrderDetailVO {
	
	private int prodNo;		// 제품 번호
	private int ordNo;	// 주문번호
	private int qty;		// 수량
	private int ordPrice;	// 주문가격
	
	// getter & setter
	public int getProdNo() {
		return prodNo;
	}
	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}
	public int getOrdNo() {
		return ordNo;
	}
	public void setOrdNo(int ordNo) {
		this.ordNo = ordNo;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getOrdPrice() {
		return ordPrice;
	}
	public void setOrdPrice(int ordPrice) {
		this.ordPrice = ordPrice;
	}
}
