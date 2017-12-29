package com.foodtruck.vo;

public class FoodTruckVO {
   private String licenseNo;      	// 사업자 번호
   private String ftruckName;   // 푸드 트럭 이름(상호명)
   private String ftruckTel;   	// 푸드 트럭 전화번호
   private String ftruckAddr;   // 푸드 트럭 주소
   private String ftruckDlvYn;  // 배달 여부(Y/N)
   private String ftruckRsvYn;  // 예약 여부(Y/N)
   private String ftruckState; 	// 영업 상태(Y/N)
   private double ftruckGrade;  // 푸드트럭 평점
   private String ftruckImg;   	// 푸드트럭 이미지
   private String latitude;     // 위도
   private String longitude;   	// 경도
   private int category;		// 카테고리번호
   private String ftruckIntro;	//푸드트럭 소개
   private String ftruckReg; //푸드트럭 등록일자
   // getter & setter
   
   
   public String getLicenseNo() {
      return licenseNo;
   }
   public void setLicenseNo(String licenseNo) {
      this.licenseNo = licenseNo;
   }
   public String getFtruckName() {
      return ftruckName;
   }
   public void setFtruckName(String ftruckName) {
      this.ftruckName = ftruckName;
   }
   public String getFtruckTel() {
      return ftruckTel;
   }
   public void setFtruckTel(String ftruckTel) {
      this.ftruckTel = ftruckTel;
   }
   public String getFtruckAddr() {
      return ftruckAddr;
   }
   public void setFtruckAddr(String ftruckAddr) {
      this.ftruckAddr = ftruckAddr;
   }
   public String getFtruckDlvYn() {
      return ftruckDlvYn;
   }
   public void setFtruckDlvYn(String ftruckDlvYn) {
      this.ftruckDlvYn = ftruckDlvYn;
   }
   public String getFtruckRsvYn() {
      return ftruckRsvYn;
   }
   public void setFtruckRsvYn(String ftruckRsvYn) {
      this.ftruckRsvYn = ftruckRsvYn;
   }
   public String getFtruckState() {
      return ftruckState;
   }
   public void setFtruckState(String ftruckState) {
      this.ftruckState = ftruckState;
   }
   public double getFtruckGrade() {
      return ftruckGrade;
   }
   public void setFtruckGrade(double ftruckGrade) {
      this.ftruckGrade = ftruckGrade;
   }
   public String getFtruckImg() {
      return ftruckImg;
   }
   public void setFtruckImg(String ftruckImg) {
      this.ftruckImg = ftruckImg;
   }
   public String getLatitue() {
      return latitude;
   }
   public void setLatitue(String latitude) {
      this.latitude = latitude;
   }
   public String getLongitude() {
      return longitude;
   }
   public void setLongitude(String longitude) {
      this.longitude = longitude;
   }
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getFtruckIntro() {
		return ftruckIntro;
	}
	public void setFtruckIntro(String ftruckIntro) {
		this.ftruckIntro = ftruckIntro;
	}
	public String getFtruckReg() {
		return ftruckReg;
	}
	public void setFtruckReg(String ftruckReg) {
		this.ftruckReg = ftruckReg;
	}
	
	
	
}