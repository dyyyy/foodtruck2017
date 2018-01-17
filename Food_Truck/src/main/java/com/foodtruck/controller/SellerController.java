package com.foodtruck.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SellerController {

	// 관리자 메뉴 - 판매자  일정관리
	@RequestMapping("/sellerCalendar")
	public String sellerCalendar() {
		return "seller/calendar";
	}
	
	// 관리자 메뉴 - 차트
	@RequestMapping("/sellerChart")
	public String sellerChart() {
		return "seller/chart";
	}
	
	// 판매자 메뉴 - 판매자 통계 ?
	@RequestMapping("/sellerMain")
	public String sellerMain() {
		return "seller/main";
	}
}
