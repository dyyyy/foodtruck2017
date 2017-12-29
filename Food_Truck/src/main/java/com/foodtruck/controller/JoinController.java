package com.foodtruck.controller;

import java.io.UnsupportedEncodingException;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.foodtruck.service.MemberService;
import com.foodtruck.vo.MemberVO;

@Controller
public class JoinController {
	
	private static final Logger logger = LoggerFactory.getLogger(JoinController.class);
	
	@Autowired
	MemberService memberService;
	
	// 회원 가입
	@RequestMapping("/join1")
	public String insertMember(HttpServletRequest request, MemberVO vo) {

		String gubun[] = request.getParameterValues("gubun");

		for(String g : gubun) {
			if(g.equals("member")) {
				vo.setMemberAuth(3);
			} else if(g.equals("seller")) {
				vo.setMemberAuth(2);
			}
		}

		memberService.insertMember(vo);

		return "home";
	}

	// ID 중복체크
	@ResponseBody
	@RequestMapping("/idCheck")
	public MemberVO memberIdCheck(HttpServletRequest request) {
		String memberId = request.getParameter("memberId");

		return memberService.getMember(memberId);
	}
	
	
}
