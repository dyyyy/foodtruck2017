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

		if (mvo != null) {
			if (mvo.getMemberPw().equals(pw)) {
				session.setAttribute("member", mvo);
				System.out.println("로그인성공");
				return "home";
			} else {
				request.setAttribute("msg", "비밀번호가 맞지 않습니다.");
				return "/login/msg";
			}
		} else {

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

}
