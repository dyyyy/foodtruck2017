package com.foodtruck.vo;

public class MinquiryReplyVO {
	
	private String replyScNo;			// 답글 번호
	private String memId;				// 회원 아이디
	private int qaScNo;					// 글 번호
	private String replyScContent;		// 답글 내용
	private String replyScReg;			// 등록일
	
	
	// getter & setter
	
	public String getReplyScNo() {
		return replyScNo;
	}
	public void setReplyScNo(String replyScNo) {
		this.replyScNo = replyScNo;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public int getQaScNo() {
		return qaScNo;
	}
	public void setQaScNo(int qaScNo) {
		this.qaScNo = qaScNo;
	}
	public String getReplyScContent() {
		return replyScContent;
	}
	public void setReplyScContent(String replyScContent) {
		this.replyScContent = replyScContent;
	}
	public String getReplyScReg() {
		return replyScReg;
	}
	public void setReplyScReg(String replyScReg) {
		this.replyScReg = replyScReg;
	}
	
	
}
