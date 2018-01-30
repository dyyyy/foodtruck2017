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

import com.foodtruck.service.OrderDetailService;
import com.foodtruck.service.OrderService;
import com.foodtruck.service.ProductService;
import com.foodtruck.service.ReviewService;
import com.foodtruck.vo.MemberVO;
import com.foodtruck.vo.OrderDetailVO;
import com.foodtruck.vo.OrderVO;
import com.foodtruck.vo.ProductVO;
import com.foodtruck.vo.ReviewVO;


@Controller
public class OrderController {
	@Autowired
	ProductService Pservice;
	
	@Autowired
	OrderService Oservice;
	
	@Autowired
	OrderDetailService orderdetailService;
	 
	@Autowired
	ReviewService reviewService;
	
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

	// 사용자 주문내역 조회
	@RequestMapping("/memberOrderInfo")
	public String memberOrderInfo(HttpSession session,HttpServletRequest request) {
		MemberVO vo = (MemberVO)session.getAttribute("member");
		List<OrderVO> list = Oservice.getMemberOrderList(vo.getMemberId());
		request.setAttribute("list", list);
		
		MemberVO mvo = (MemberVO)session.getAttribute("member");
		String memId = mvo.getMemberId(); 
		
		List<ReviewVO> reviewList = reviewService.getFoodTrcukName(memId);
		request.setAttribute("reviewList", reviewList);
		
		return "member/memberOrderInfo";
	}
	
	
	@RequestMapping("/orderRegit")
	public String wishInsert(HttpSession session, HttpServletRequest request,
										@RequestParam("ordName") String ordName, 
										@RequestParam("ordTel") String ordTel, 
										@RequestParam("ordReq") String ordReq, 
										@RequestParam("ftruckNo") String ftruckNo, 
										@RequestParam("licenseNo") String licenseNo, 
										@RequestParam("prodNo") List<String> prodNo, 
										@RequestParam("prodName") List<String> prodName,
										@RequestParam("ordQty") List<Integer> ordQty,
										@RequestParam("ordPrice") List<Integer> ordPrice,
										@RequestParam("sumPrice") int sumPrice) {
		

		System.out.println("주문할 거 디비에 넣자!");
		Map<String,Object> orderMap = new HashMap<String, Object>();
		Map<String,Object> orderdetailMap = new HashMap<String, Object>();
		Map<String,Object> orderInfoList = new HashMap<String, Object>();
		
		// order 테이블에 들어갈껑!
		if(ordName != null) {
			orderMap.put("ordName", ordName);
			orderMap.put("ordTel", ordTel);
			orderMap.put("ordReq", ordReq);
			orderMap.put("licenseNo", licenseNo);
			orderMap.put("sumPrice", sumPrice);
		}
		
		Oservice.insertOrder(orderMap); 
		String ordNo = String.valueOf(orderMap.get("ordNo"));
		
		for(int i = 0 ; i < prodNo.size() ; i++) {
			// orderdetail 테이블
			orderdetailMap.put("prodNo", prodNo.get(i));
			orderdetailMap.put("ordQty", ordQty.get(i));
			orderdetailMap.put("ordPrice", ordPrice.get(i));
			
			if(ordQty.get(i) != 0) {
				System.out.println(ordNo);
				orderdetailMap.put("ordNo", ordNo);
				orderdetailService.insertOrderDetail(orderdetailMap);
			}
		}
		
		orderInfoList.put("ordNo", ordNo);
		orderInfoList.put("licenseNo", licenseNo);
		List<OrderDetailVO> orderInfolist = orderdetailService.getOrderInfoList(ordNo);
		
		request.setAttribute("ordNo", orderInfolist.get(0).getOrdNo());
		request.setAttribute("ordName", orderInfolist.get(0).getOrdName());
		request.setAttribute("ordTel", orderInfolist.get(0).getOrdTel());
		request.setAttribute("ordDate", orderInfolist.get(0).getOrdDate());
		request.setAttribute("ordReq", orderInfolist.get(0).getOrdReq());
		request.setAttribute("sumPrice", orderInfolist.get(0).getSumPrice());
		
		// 다수의 값들
		request.setAttribute("orderInfolist", orderInfolist);
		return "nav/orderChk";
	}
}
