
package com.foodtruck.controller;

import java.awt.List;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.foodtruck.service.MemberService;
import com.foodtruck.vo.MemberVO;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	MemberService memberService;

	// �α��� ������ �̵�
	@RequestMapping("/loginform")
	public String loginform() {
		System.out.println("loginform");
		logger.info("loginform");
		return "sign/login";
	}

	// �α��� ������
	@RequestMapping("/login")
	public String login(@RequestParam("id") String id, @RequestParam("pw") String pw, HttpSession session,
			HttpServletRequest request, HttpServletResponse response) {
		
		MemberVO mvo = memberService.getMember(id);

		if (mvo != null) {
			if (mvo.getMemberPw().equals(pw)) {
				session.setAttribute("member", mvo);
				session.setAttribute("memberId", mvo.getMemberName());
				if(mvo.getMemberAuth().equals("1")) {
					session.setAttribute("memberGubun","1");
				} else if(mvo.getMemberAuth().equals("2")) {
					session.setAttribute("memberGubun","2");
				}
				return "redirect:/";
			} else {
				request.setAttribute("msg", "비밀번호가 틀립니다.");
				request.setAttribute("addr", "loginform");
				return "comm/msg";
			}
		} else {

			request.setAttribute("msg", "아이디와 비밀번호를 입력해주세요");
			request.setAttribute("addr", "loginform");
			return "comm/msg";
		}
	}

	// �α׾ƿ� ������
	@RequestMapping("/logout")
	public String logout(HttpSession session, HttpServletRequest request) {
		session.invalidate();
		return "redirect:/";
	}
	
	// ȸ������������
	@RequestMapping("/joinform")
	public String joinFormPage() {
		return "sign/joinform";
	}

	// ȸ�� ����
	@RequestMapping("/join")
	public String insertMember(HttpServletRequest request, MemberVO vo) {

		String gubun[] = request.getParameterValues("gubun");

		for (String g : gubun) {
			if (g.equals("member")) {
				vo.setMemberAuth("3");
			} else if (g.equals("seller")) {
				vo.setMemberAuth("2");
			}
		}

		memberService.insertMember(vo);

		return "home";
	}

	// ID �ߺ�üũ
	@ResponseBody
	@RequestMapping("/idCheck")
	public MemberVO memberIdCheck(HttpServletRequest request) {
		String memberId = request.getParameter("memberId");

		return memberService.getMember(memberId);
	}
}

