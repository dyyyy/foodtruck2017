package com.foodtruck.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.foodtruck.service.ReviewService;
import com.foodtruck.vo.MemberVO;
import com.foodtruck.vo.ReviewVO;

@Controller
public class ReviewController {

	@Autowired
	ReviewService reviewService;
	
	// FoodTrcuk List
	@RequestMapping("/")
	public String menuBoarPage(Model model) throws Exception {

		return "";
	}
	
	@RequestMapping("/reviewRegit")
	public String reviewRegit(HttpSession session, ReviewVO rvo) {
		
		MemberVO mvo = (MemberVO)session.getAttribute("member");
		rvo.setMemId(mvo.getMemberId());
		reviewService.insertReview(rvo);
		
		return null;
	}
}
