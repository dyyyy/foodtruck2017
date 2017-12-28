package com.foodtruck.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.foodtruck.service.AdminService;
import com.foodtruck.service.MemberService;
import com.foodtruck.service.SellerService;
import com.foodtruck.vo.AdminVO;
import com.foodtruck.vo.MemberVO;
import com.foodtruck.vo.SellerVO;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	MemberService memberService;
	
	@RequestMapping("/loginChk")
	public String loginchk(@RequestParam("userId") String userId, @RequestParam("userPw") String userPw,
			HttpSession session, HttpServletRequest request) {

		System.out.println(userId + " / " + userPw);
		
		// 회원 구분     1.운영자     2. 판매자     3. 일반회원ss
		MemberVO mvo = memberService.getMember(userId);
		
		if(mvo != null) {
			if(mvo.getMemberPw().equals(userPw)) {
				if(mvo.getMemberAuth() == 1 ) {
					System.out.println("운영자 로그인");
					session.setAttribute("userId", mvo.getMemberId());
					session.setAttribute("gubun", mvo.getMemberAuth());
					return "loginChk";
				} else if(mvo.getMemberAuth() == 2) {
					System.out.println("판매자 로그인");
					session.setAttribute("userId", mvo.getMemberId());
					session.setAttribute("gubun", mvo.getMemberAuth());
					return "loginChk";
				} else if(mvo.getMemberAuth() == 3) {
					System.out.println("일반 회원 로그인");
					session.setAttribute("userId", mvo.getMemberId());
					session.setAttribute("gubun", mvo.getMemberAuth());
					return "loginChk";
				}
				return "home";
			} 
		}
		return "home";
	}
	
	@RequestMapping("/logout")
	public String logoutPage() {
		return "logout";
	}
}
