package com.foodtruck.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.foodtruck.service.OrderDetailService;
import com.foodtruck.vo.OrderDetailVO;

@Controller
public class OrderDetailController {

	@Autowired
	private OrderDetailService orderDetailService;
	
	@RequestMapping("/orderDetail")
	public String orderDetailPage(Model model) {
		
		// 주문 상세 리스트
		model.addAttribute("orderDetailList", orderDetailService.getOrderDetailList());
		
		return "nav/orderDetail";
	}
}
