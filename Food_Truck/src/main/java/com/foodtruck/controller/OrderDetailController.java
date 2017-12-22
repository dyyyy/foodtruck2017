package com.foodtruck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.foodtruck.service.OrderDetailService;
import com.foodtruck.vo.OrderDetailVO;

@Controller
public class OrderDetailController {

	@Autowired
	private OrderDetailService orderDetailService;
	
	@RequestMapping("/orderDetail")
	public String orderDetailPage(OrderDetailVO vo) {

		// 판매자 메뉴에서 예약 내역 클릭 했을 경우
		return "nav/orderDetail";
	}
}
