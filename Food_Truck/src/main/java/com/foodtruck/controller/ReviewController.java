package com.foodtruck.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.foodtruck.service.FoodTruckService;
import com.foodtruck.service.ReviewService;
import com.foodtruck.vo.FoodTruckVO;
import com.foodtruck.vo.MemberVO;
import com.foodtruck.vo.ReviewVO;

@Controller
public class ReviewController {

	@Autowired
	ReviewService reviewService;
	
	@Autowired
	FoodTruckService fService;
	
	// FoodTrcuk List
	@RequestMapping("/")
	public String menuBoarPage(Model model) throws Exception {

		return "";
	}
	
	@RequestMapping("/reviewRegit")
	public String reviewRegit(HttpSession session, ReviewVO rvo) throws Exception {
		
		MemberVO mvo = (MemberVO)session.getAttribute("member");
		rvo.setMemId(mvo.getMemberId());
		
		if(reviewService.insertReview(rvo) != 0) {
			FoodTruckVO vo = fService.getReviewCount(rvo.getFtruckNo());	// 푸드트럭 전체 리뷰 갯수
			FoodTruckVO vo2 = fService.getReviewTotal(rvo.getFtruckNo());	// 푸드트럭 전체 평점 합계
			double count = vo.getCount();
			double total = vo2.getTotal();
			double avg = (total/count);
			System.out.println("평점 총 합 " + total  + "총 갯수" + count);
			System.out.println("평균" + avg);
			FoodTruckVO vo3 = fService.getFoodTruck(rvo.getFtruckNo());		// 푸드트럭번호로 전체정보 vo3에 담기
			vo3.setFtruckGrade(avg);	// vo3에 평점값만 평균값으로 set
			fService.updateGrade(vo3);	// 수정
		}else {
			
		}
		
		return null;
	}
}
