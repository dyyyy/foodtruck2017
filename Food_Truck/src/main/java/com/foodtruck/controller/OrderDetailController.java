package com.foodtruck.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.foodtruck.service.OrderDetailService;
import com.foodtruck.vo.OrderDetailVO;

@Controller
public class OrderDetailController {

	@Autowired
	private OrderDetailService orderDetailService;
	
	@RequestMapping("/orderDetail")
	public String orderDetailPage(Model model, HttpSession session) {

		String selId = (String)session.getAttribute("userId");
		// 주문 상세 리스트
		model.addAttribute("orderDetailList", orderDetailService.getOrderDetailList(selId));
		
		return "nav/orderDetail";
	}
}
