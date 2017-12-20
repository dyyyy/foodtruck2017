package com.foodtruck.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavController {
	
	// 공지사항
	@RequestMapping("/noticeBoard")
	public String noticeBoardPage() {
		return "nav/noticeBoard";
	}
	
	// 이벤트
	@RequestMapping("/eventBoard")
	public String eventBoardPage() {
		return "nav/eventBoard";
	}
	
	// 1:1 문의
	@RequestMapping("/inquiry")
	public String inquiryPage() {
		return "nav/inquiry";
	}
	
	// 로그인  가입 폼 테스트중  -> nav/login 으로 바꾸기
	@RequestMapping("/login")
	public String loginPage() {
		return "nav/join";
	}
	
	// 가입
	@RequestMapping("/join")
	public String joinPage() {
		return "nav/test";
	}

	// FoodTrcuk List
	@RequestMapping("/menuBoard")
	public String menuBoarPage() {
		return  "nav/menuBoard";
	}
	
	// Korean Food
	@RequestMapping("/korFood")
	public String korFoodPage() {
		return "nav/korFood";
	}
	
	// Chinese Food
	@RequestMapping("/chiFood")
	public String chiFoodPage() {
		return "nav/chiFood";
	}
	
	// Western Food
	@RequestMapping("/westFood")
	public String westFoodPage() {
		return "nav/westFood";
	}
	
	// Japanese Food
	@RequestMapping("/jpFood")
	public String jpFoodPage() {
		return "nav/jpFood";
	}
	
	// 관리자 메뉴
	@RequestMapping("/adminBoard")
	public String adminBoardPage() {
		return "nav/adminBoard";
	}
	
	// 관리자 메뉴 - 회원관리
	@RequestMapping("/adminMember")
	public String adminMemberPage() {
		return "nav/adminMember";
	}
	
	// 관리자 메뉴 - 판매자 관리
	@RequestMapping("/adminSeller")
	public String adminSellerPage() {
		return "nav/adminSeller";
	}
	
	// 관리자 메뉴 - 푸드트럭 관리
	@RequestMapping("/adminFoodTruck")
	public String adminFoodTruckPage() {
		return "nav/adminFoodTruck";
	}
	
	// 판매자 메뉴
	@RequestMapping("/sellerBoard")
	public String sellerBoardPage() {
		return "nav/sellerBoard";
	}
	
	// 판매자 메뉴 - 예약 내역
	@RequestMapping("/orderDetail")
	public String orderDetailPage() {
		return "nav/orderDetail";
	}
	
	// 판매자 메뉴 - 예약 내역
	@RequestMapping("/productInsert")
	public String productInsertPage() {
		return "nav/productInsert";
	}
	
	// 판매자 메뉴 - 배달 내역
	@RequestMapping("/deliveryDetails")
	public String deliveryDetailsPage() {
		return "nav/deliveryDetails";
	}
		
	// 판매자 메뉴 - 판매자 설정
	@RequestMapping("/sellerSetting")
	public String sellerSettingPage() {
		return "nav/sellerSetting";
	}
	
	// 구매자 메뉴
	@RequestMapping("/myBoard")
	public String myBoardPage() {
		return "nav/myBoard";
	}
	
	// 구매자 메뉴 - 전체 주문 내역
	@RequestMapping("/orderList")
	public String orderListPage() {
		return "nav/orderList";
	}
	
	// 구매자 메뉴 - 관심 푸드트럭
	@RequestMapping("/favoritFoodtruck")
	public String favoritFoodtruckPage() {
		return "nav/favoritFoodtruck";
	}
	
	// 구매자 메뉴 - 내가 쓴글
	@RequestMapping("/myWriting")
	public String myWritingPage() {
		return "nav/myWriting";
	}
	
	// 구매자 메뉴 - 나의 설정
	@RequestMapping("/mySetting")
	public String mySettingPage() {
		return "nav/mySetting";
	}
}
