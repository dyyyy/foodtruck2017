package com.foodtruck.vo;

public class DeliveryDetailVO {
	
	private int ordNo;			// 주문 번호
	private String dlvState;	// 배달 상태
	private String dlvAddr;		// 배달 주소
	private String dlvDate;		// 배달 시간
	
	// getter & setter
	public int getOrdNo() {
		return ordNo;
	}
	public void setOrdNo(int ordNo) {
		this.ordNo = ordNo;
	}
	public String getDlvState() {
		return dlvState;
	}
	public void setDlvState(String dlvState) {
		this.dlvState = dlvState;
	}
	public String getDlvAddr() {
		return dlvAddr;
	}
	public void setDlvAddr(String dlvAddr) {
		this.dlvAddr = dlvAddr;
	}
	public String getDlvDate() {
		return dlvDate;
	}
	public void setDlvDate(String dlvDate) {
		this.dlvDate = dlvDate;
	}
	
}
