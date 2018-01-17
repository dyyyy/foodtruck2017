package com.foodtruck.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.foodtruck.service.FestivalService;
import com.foodtruck.service.FoodTruckService;
import com.foodtruck.vo.FestivalVO;
import com.foodtruck.vo.FoodTruckVO;

@Controller
public class AdminController {
	@Autowired
	private FoodTruckService fservice;
	@Autowired
	private FestivalService feservice;
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
		int count=fservice.getCountTruck();
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("list", list);
		request.setAttribute("pagecount", count);//�� ������ ��
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
	public String festival(@RequestParam("pageNo") int pageNo, HttpServletRequest request) throws Exception {
		int NpageNo = 0;
		if (pageNo == 1) {
			pageNo = 1;
		} else {
			NpageNo = (pageNo - 1) * 10 + 1;
		}
		List<FestivalVO> list=feservice.getFestivalList2(NpageNo);
		int count=feservice.getcountFestival();
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("list", list);
		request.setAttribute("pagecount", count);//�� ������ ��
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
	@RequestMapping("/list")
	public String list(@RequestParam("pageNo") int pageNo, HttpServletRequest request) throws Exception {
		int NpageNo = 0;
		if (pageNo == 1) {
			pageNo = 1;
		} else {
			NpageNo = (pageNo - 1) * 10 + 1;
		}
		
		
		return null;
	}
	
}
