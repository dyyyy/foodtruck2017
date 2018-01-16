package com.foodtruck.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	// 관리자 메뉴 - 일정관리
	@RequestMapping("/adminCalendar")
	public String adminFoodTruckPage() {
		return "admin/calendar";
	}
	
	// 관리자 메뉴 - 차트
	@RequestMapping("/adminChart")
	public String adminChart() {
		return "admin/chart";
	}
	
	// 관리자 메뉴 - 통계 ? 
	@RequestMapping("/adminMain")
	public String adminMain() {
		return "admin/main";
	}
}
