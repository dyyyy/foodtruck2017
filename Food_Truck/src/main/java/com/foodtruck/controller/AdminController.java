package com.foodtruck.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.foodtruck.service.FoodTruckService;
import com.foodtruck.vo.FoodTruckVO;

@Controller
public class AdminController {
	@Autowired
	private FoodTruckService fservice;
	// ������ �޴� - ��������
	@RequestMapping("/stute")
	public String stute(@RequestParam("pageNo") int pageNo, HttpServletRequest request) throws Exception {
		int NpageNo = 0;
		if (pageNo == 1) {
			pageNo = 1;
		} else {
			NpageNo = (pageNo - 1) * 10 + 1;
		}
		List<FoodTruckVO> list=fservice.getFoodTruckList(NpageNo);
		
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

	@RequestMapping("/foodtruck")
	public String foodtruck() {
		System.out.println("진입");
		return "admin/foodturck";
	}
}
