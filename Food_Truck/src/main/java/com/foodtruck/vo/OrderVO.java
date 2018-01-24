
package com.foodtruck.vo;

public class OrderVO {
	
	private String ordNo;		// 二쇰Ц踰덊샇
	private String ordName;		// �씠由�
	private String ordTel;		// �쟾�솕踰덊샇
	private String ordDate;		// 二쇰Ц�씪
	private String ordRsvDate;	// �삁�빟�떆媛�
	private String ordDlyYn;	// 諛곕떖 �뿬遺�(Y/N)
	private int ordStat;		// 二쇰Ц �긽�깭
	private int cookStat;		// 議곕━ �긽�깭
	private String memId;		// �쉶�썝 �븘�씠�뵒
	private String licenseNo;	// �뙋留ㅼ옄 �궗�뾽�옄踰덊샇
	private int ordQty;			// �닔�웾
	private int ordPrice;		// �젣�뭹媛�寃�
	private int sumPrice;		// 珥� �빀怨�
	private String ordReq;		// �슂援ъ궗�빆
	private String prodName;	// �젣�뭹�씠由�
	private String ftruckName;	// �뫖�뱶�듃�윮 �씠由�
	
	
	// getter & setter

	public String getOrdNo() {
		return ordNo;
	}
	public void setOrdNo(String ordNo) {
		this.ordNo = ordNo;
	}
	public String getOrdName() {
		return ordName;
	}
	public void setOrdName(String ordName) {
		this.ordName = ordName;
	}
	public String getOrdTel() {
		return ordTel;
	}
	public void setOrdTel(String ordTel) {
		this.ordTel = ordTel;
	}
	public String getOrdDate() {
		return ordDate;
	}
	public void setOrdDate(String ordDate) {
		this.ordDate = ordDate;
	}
	public String getOrdRsvDate() {
		return ordRsvDate;
	}
	public void setOrdRsvDate(String ordRsvDate) {
		this.ordRsvDate = ordRsvDate;
	}
	public String getOrdDlyYn() {
		return ordDlyYn;
	}
	public void setOrdDlyYn(String ordDlyYn) {
		this.ordDlyYn = ordDlyYn;
	}
	public int getOrdStat() {
		return ordStat;
	}
	public void setOrdStat(int ordStat) {
		this.ordStat = ordStat;
	}
	public int getCookStat() {
		return cookStat;
	}
	public void setCookStat(int cookStat) {
		this.cookStat = cookStat;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
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
	public int getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(int sumPrice) {
		this.sumPrice = sumPrice;
	}
	public String getOrdReq() {
		return ordReq;
	}
	public void setOrdReq(String ordReq) {
		this.ordReq = ordReq;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getFtruckName() {
		return ftruckName;
	}
	public void setFtruckName(String ftruckName) {
		this.ftruckName = ftruckName;
	}
}
