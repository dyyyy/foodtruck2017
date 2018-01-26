package com.foodtruck.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.foodtruck.service.OrderDetailService;
import com.foodtruck.vo.MemberVO;

@Controller
public class OrderDetailController {

	@Autowired
	private OrderDetailService orderDetailService;
	
	/*예약내역 이름변경하기*/
	@RequestMapping("/orderDetail")
	public String orderDetailPage(Model model, HttpSession session) {
 
		MemberVO mvo = (MemberVO)session.getAttribute("member");
		
		
		if(mvo != null) {
			model.addAttribute("orderDetailList", orderDetailService.getOrderDetailList(mvo.getMemberId()));	
		}else {
			return "home";
			
		}
		// 주문 상세 리스트
		
		
		return "nav/orderDetail";
	}
}
