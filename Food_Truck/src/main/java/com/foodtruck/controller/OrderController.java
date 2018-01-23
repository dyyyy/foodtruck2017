package com.foodtruck.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.foodtruck.service.OrderService;
import com.foodtruck.service.ProductService;
import com.foodtruck.vo.OrderVO;
import com.foodtruck.vo.ProductVO;


@Controller
public class OrderController {
	@Autowired
	ProductService Pservice;
	
	@Autowired
	OrderService Oservice;	
	
	@RequestMapping("/order")
	public String order(HttpSession session,@RequestParam("licenseNo") String licenseNo,HttpServletRequest request) {
		System.out.println("����");
		System.out.println(licenseNo);
		List<ProductVO> Plist = Pservice.getProductList(licenseNo);

		request.setAttribute("list",Plist);
		return "nav/order";
	}
	
	//비회원 주문번호 + 전화번호로 주문내역 보기 
	@RequestMapping("/nonMemberOrderDetail")
	public String nonMemberOrderDetail(HttpServletRequest request) {
		String ordNo = request.getParameter("ordNo");
		String ordTel = request.getParameter("ordTel");
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ordNo", ordNo);
		map.put("ordTel", ordTel);
		
		List<OrderVO> list = (List<OrderVO>) Oservice.getNonmemberInfo(map);
		request.setAttribute("nonList", list);
		request.setAttribute("ordNo", list.get(0).getOrdNo());
		request.setAttribute("ordName", list.get(0).getOrdName());
		request.setAttribute("ordTel", list.get(0).getOrdTel());
		request.setAttribute("ordDate", list.get(0).getOrdDate());
		request.setAttribute("ordReq", list.get(0).getOrdReq());
		request.setAttribute("sumPrice", list.get(0).getSumPrice());
		
		return "nav/nonMemberOrderDetail";
	}		
}
