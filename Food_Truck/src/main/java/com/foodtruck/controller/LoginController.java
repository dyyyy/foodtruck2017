package com.foodtruck.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.foodtruck.service.MemberService;
import com.foodtruck.vo.MemberVO;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	MemberService memberService;
	
	
	
	// 로그인 폼으로 이동
		@RequestMapping("/loginform")
		public String loginform() {
			System.out.println("loginform");
			return "/login/login";
		}

		// 로그인 했을때
		@RequestMapping("/login")
		public String login(@RequestParam("id") String id, @RequestParam("pw") String pw, HttpSession session,
				HttpServletRequest request, HttpServletResponse response) {
			
			
			MemberVO mvo = memberService.getMember(id);

			if (mvo!=null) {
				if(mvo.getMemberPw().equals(pw)) {
					session.setAttribute("member", mvo);	
					System.out.println("로그인성공");
					return "home";
				}else{
					request.setAttribute("msg", "비밀번호가 맞지 않습니다.");
					return "/login/msg";
				}
			}else {
				
				request.setAttribute("msg", "회원정보가 없거나 입력되지 않았습니다.");
				return "/login/msg";	
			}
		}
		// 로그아웃 했을때
		@RequestMapping("/logout")
		public String logout(HttpSession session, HttpServletRequest request) {
			session.invalidate();
			return "home";
		}
	

	/*
	@RequestMapping("/loginChk")
	public String loginchk(@RequestParam("userId") String userId, @RequestParam("userPw") String userPw,
			HttpSession session, HttpServletRequest request) {

		System.out.println(userId + " / " + userPw);
		
		// 회원 구분     1.운영자     2. 판매자     3. 일반회원
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

	*/
}
