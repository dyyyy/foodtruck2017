package com.foodtruck.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.foodtruck.service.FoodTruckService;
import com.foodtruck.service.OrderService;
import com.foodtruck.service.SellerService;
import com.foodtruck.vo.FoodTruckVO;
import com.foodtruck.vo.MemberVO;
import com.foodtruck.vo.OrderVO;
import com.foodtruck.vo.SellerVO;

@Controller
public class SellerController {

	@Autowired
	FoodTruckService foodTruckService;
	
	@Autowired
	SellerService sellerService;
	
	
	// ������ �޴� - �Ǹ���  ��������
	@RequestMapping("/sellerCalendar")
	public String sellerCalendar() {
		return "seller/calendar";
	}
	
	// ������ �޴� - ��Ʈ
	@RequestMapping("/sellerChart")
	public String sellerChart() {
		return "seller/chart";
	}
	
	// �Ǹ��� �޴� - �Ǹ��� ��� ?
	@RequestMapping("/sellerMain")
	public String sellerMain(@RequestParam(value = "licenseNo", required = false, defaultValue = "5165133515")String licenseNo,HttpServletRequest request, Model model, HttpSession session) {
		
		MemberVO mvo = (MemberVO)session.getAttribute("member");
//		OrderVO ovo = (OrderVO) session.getAttribute("licenseNo");
		
		model.addAttribute("order1", sellerService.getLicense(mvo.getMemberId()));
		model.addAttribute("order2", sellerService.getOrderList(request.getParameter("licenseNo")));
		model.addAttribute("img", sellerService.getFoodTruckList(request.getParameter("licenseNo")));
		
		return "seller/main";
	}
	
	
	@RequestMapping("/insertFoodTruckForm")
	public String insertFoodTruckForm() {
		return "seller/insertFoodTruck";
	}
	
	
	@RequestMapping("/insertFoodTruck")
	public String insertFoodTruck(HttpServletRequest request, FoodTruckVO vo) {
		
		String category[] = request.getParameterValues("category");
		String ftruckDlvYn[] = request.getParameterValues("ftruckDlvYn");
		String ftruckRsvYn[] = request.getParameterValues("ftruckRsvYn");
		String ftruckState[] = request.getParameterValues("ftruckState");
		
		for(String c : category) {
			switch(c) {
			case "1" : vo.setCategory(1); break;
			case "2" : vo.setCategory(2); break;
			case "3" : vo.setCategory(3); break;
			case "4" : vo.setCategory(4); break;
			}
			
			/*
			if(c.equals("1")) {
				vo.setCategory(1);
			} else if(c.equals("2")) {
				vo.setCategory(2);
			} else if(c.equals("3")) {
				vo.setCategory(3);
			} else if(c.equals("4")) {
				vo.setCategory(4);
			}*/
		}
		
		for(String dlv : ftruckDlvYn) {
			switch(dlv) {
			case "Y" : vo.setFtruckDlvYn("Y"); break;
			case "N" : vo.setFtruckDlvYn("N"); break;
			}
		}
		
		for(String rsv : ftruckRsvYn) {
			switch(rsv) {
			case "Y" : vo.setFtruckRsvYn("Y"); break;
			case "N" : vo.setFtruckRsvYn("N"); break;
			}
		}
		
		for(String state : ftruckState) {
			switch(state) {
			case "Y" : vo.setFtruckState("Y"); break;
			case "N" : vo.setFtruckState("N"); break;
			}
		}
		
		sellerService.insertFoodTruck(vo);
		
		return "seller/main";
	}
	
	
	@RequestMapping("/detailFoodTruckForm")
	public String detailFoodTruckForm() {
		return "seller/detailFoodTruck";
	}
	
	@ResponseBody
	@RequestMapping("/licenseNoCheck")
	public FoodTruckVO licenseNoCheck(HttpServletRequest request) {
		String licenseNo = request.getParameter("licenseNo");

		return sellerService.getFoodTruck(licenseNo);
	}
		
}
