package com.foodtruck.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	// ������ �޴� - ��������
	@RequestMapping("/stute")
	public String stute() {
		return "admin/stute";
	}

	// ������ �޴� - ��Ʈ
	@RequestMapping("/sellerQnA")
	public String sellerQnA() {
		return "admin/sellerQnA";
	}

	// ������ �޴� - ��� ?
	@RequestMapping("/memberQnA")
	public String memberQnA() {
		return "admin/memberQnA";
	}

	@RequestMapping("/festival")
	public String festival() {
		return "admin/festival";
	}
	@RequestMapping("/admin")
	public String admin() {
		return "admin/main";
	}
}
